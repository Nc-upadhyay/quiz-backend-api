package com.nc.assingment.dto;

import com.nc.assingment.utils.Status;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class QuizModel {
    Long id;
    String question;
    List<String> options;
    int answerIndex;
    String startDate;
    String endDate;

    Status status;

}
