package org.tk2100.quiz;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Random;

/**
 * Created by arcuri82 on 15-Mar-18.
 */
@Api(description = "Handling of Quizzes")
@CrossOrigin
@RestController
public class RestAPI {

    private Random random = new Random(System.currentTimeMillis());

    @ApiOperation("Return the Quiz with the given id")
    @GetMapping(path = "/quizzes/{id}")
    public ResponseEntity<QuizDto> getQuiz(@PathVariable("id") int id){

        QuizDto dto = QuizList.getQuizOrNull(id);
        if(dto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @ApiOperation("Return a Quiz at random from the existing ones")
    @GetMapping(path = "/randomQuiz")
    public ResponseEntity getRandomQuiz(){

        int index = random.nextInt(QuizList.getList().size());

        return ResponseEntity.status(307)
                .location(URI.create("/quizzes/"+index))
                .build();
    }
}
