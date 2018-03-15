package org.tk2100.quiz;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by arcuri82 on 15-Mar-18.
 */
@ApiModel("A quiz is composed of 1 question with 4 possible answers, with only been the correct one")
public class QuizDto {

    @ApiModelProperty(value = "The question of the quiz", required = true)
    private String question;

    @ApiModelProperty(required = true)
    private String answer_0;

    @ApiModelProperty(required = true)
    private String answer_1;

    @ApiModelProperty(required = true)
    private String answer_2;

    @ApiModelProperty(required = true)
    private String answer_3;

    @ApiModelProperty(value = "The index of the correct answer, from 0 to 3", required = true)
    private int indexOfRightAnswer;

    public QuizDto() {
    }

    public QuizDto(String question, String answer_0, String answer_1, String answer_2, String answer_3, int indexOfRightAnswer) {
        this.question = question;
        this.answer_0 = answer_0;
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
        this.indexOfRightAnswer = indexOfRightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_0() {
        return answer_0;
    }

    public void setAnswer_0(String answer_0) {
        this.answer_0 = answer_0;
    }

    public String getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(String answer_1) {
        this.answer_1 = answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    public int getIndexOfRightAnswer() {
        return indexOfRightAnswer;
    }

    public void setIndexOfRightAnswer(int indexOfRightAnswer) {
        this.indexOfRightAnswer = indexOfRightAnswer;
    }
}
