package com.nc.assingment.service;

import com.nc.assingment.dto.QuizModel;

import java.util.List;

public interface QuizService {

    List<QuizModel> getAllQuize();
    String getQuizResult(long id);

    QuizModel createQuiz(QuizModel userModel);

    List<QuizModel> getAllactiveQuizzes();

}
