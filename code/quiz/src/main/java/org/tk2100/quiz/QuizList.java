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
                    new QuizDto("TODO 0",
                            "a",
                            "b",
                            "c",
                            "d",
                            0),
                    new QuizDto("TODO 1",
                            "a",
                            "b",
                            "c",
                            "d",
                            1)
            )
    );

}
