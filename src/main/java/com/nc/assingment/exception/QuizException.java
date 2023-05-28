package com.nc.assingment.exception;

import com.nc.assingment.dto.QuizModel;
import org.springframework.http.HttpStatus;

public class QuizException  extends RuntimeException{

    HttpStatus httpStatus;
    String message;
    QuizModel quizModel;
    public QuizException(String message, HttpStatus httpStatus,QuizModel quizModel) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
        this.quizModel=quizModel;
    }

    public QuizModel getQuizModel() {
        return quizModel;
    }

    public void setQuizModel(QuizModel quizModel) {
        this.quizModel = quizModel;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
