package org.tk2100.quiz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by arcuri82 on 15-Mar-18.
 */
public class QuizList {

    public static List<QuizDto> getList() {
        return list;
    }

    public static QuizDto getQuizOrNull(int index){
        if(index < 0 || index >= list.size()){
            return null;
        }

        return list.get(index);
    }

    private static final List<QuizDto> list = Collections.unmodifiableList(
            Arrays.asList(
                    new QuizDto("What is a Smurf Attack?",
                            "A DoS attack via pings done to a broadcast address, where source IP address is spoofed with the target IP",
                            "A DoS attack in which the target machines are filled with pictures of Smurfs (small blue creatures), and every file name gets prefixed with “smurf-”",
                            "A DoS attack where TCP connections are stated with a SYN command, but never followed by any ACK",
                            "An old DoS attack that was exploiting an existing vulnerability in the Smurf Linux distribution",
                            0),
                    new QuizDto("In the contest of security, what is a Polymorphic Virus?",
                            "A virus whose encoding genotype can result in several different expressed phenotypes to avoid detection",
                            "A virus that encrypts parts of itself, and decrypts them on the fly when running",
                            "A virus that encrypts the hard-drive of the targets, and then can be used to ask for a ransom",
                            "A virus that changes its name when installed to resemble the other files in the same folder, and then move around to different folders every certain amount of time, each time changing name",
                            1),
                    new QuizDto("What is the main reason for why substitution cyphers (eg a +7 shift) are considered not secure?",
                            "They are very old",
                            "Substitution cyphers are actually secure",
                            "The probability distribution of the character occurrences in the cyphertext would be the same as in the original text",
                            "The probability distribution of the character occurrences in the cyphertext is proportional to the square logarithmic of a Poisson distribution, and so can be decoded by simply using its exponential inversion",
                            2),
                    new QuizDto("Considering a substitution cypher with a +7 position shift, given the text to encode 'HelloWorld!', what would be its cyphertext?",
                            "Olssv^vyrk(",
                            "Olssv^vysk(",
                            "Olssv^vytk(",
                            "Olssv^vyzk(",
                            1),
                    new QuizDto("Regarding the Top 10 Security Principles, what does the 'Psychological Acceptability' state?",
                            "Information systems should be designed to prevent people with psychological issues from being able to damage such systems, either accidentally or intentionally",
                            "Information systems should be designed to prevent people with psychological issues from being able to accidentally damage such systems",
                            "User interfaces regarding security (e.g., login/password forms) should take into account possible different kinds of psychological issues that users might have, like Bipolar Disorder",
                            "User interfaces should be well designed to increase usability and avoid possible misconfigurations by mistake",
                            3),
                    new QuizDto("In the context of security, what does C.I.A. stands for?",
                            "Confidentiality, Incognito, Availability",
                            "Confidentiality, Integrity, Availability",
                            "Confidentiality, Irreversibility, Authentication",
                            "Confidentiality, Integrity, Authentication",
                            1)
            )
    );

}
