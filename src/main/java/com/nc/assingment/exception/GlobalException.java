package com.nc.assingment.exception;

import com.nc.assingment.dto.QuizModel;
import com.nc.assingment.utils.ResponseUtil;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = QuizException.class)
    public ResponseEntity handleQuizException(QuizException quizException) {
        return ResponseUtil.internalError(new QuizException(quizException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, new QuizModel()));
    }


}
