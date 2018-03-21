package org.tk2100.bank.unsecure.db;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.security.SecureRandom;


@Service
@Transactional
public class UserService {

    @PersistenceContext
    private EntityManager em;


    /**
     * @return {@code false} if any initial validation fails.
     *         Note: this method can still throw an exception if the transaction fails
     */
    public boolean createUser(String userId, String password) {
        if (userId == null) {
            return false;
        }

        User userDetails = getUser(userId);
        if (userDetails != null) {
            //a user with same id already exists
            return false;
        }

        userDetails = new User();
        userDetails.setUserId(userId);


        String hash = computeHash(password);

        userDetails.setPassword(hash);

        //some default balance
        userDetails.setBalance(1000);

        em.persist(userDetails);

        return true;
    }


    public boolean transferMoney(String fromUser, String toUser, int amount){

        User from = getUser(fromUser);
        User to = getUser(toUser);

        if(from == null || to == null || from.getBalance() < amount || amount <= 0){
            return false;
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        return true;
    }

    /**
     *
     * @param userId
     * @param password
     * @return  {@code true} if a user with the given password exists
     */
    public boolean canLogin(String userId, String password) {
        if (userId == null) {
            return false;
        }


        String hash = computeHash(password);

        //WARNING: SQL-Injection-prone query

        Query query = em.createNativeQuery("select * from user_table where USER_ID='"+userId+"' and PASSWORD='"+hash+"'");

        return query.getResultList().size() > 0;
    }


    public User getUser(String userId){
        return em.find(User.class, userId);
    }



    private String computeHash(String password){

        return DigestUtils.md5Hex(password);
    }

}
