package com.nc.assingment.service.impl;

import com.nc.assingment.dto.QuizModel;
import com.nc.assingment.entiry.QuizEntity;
import com.nc.assingment.reposity.QuizReposity;
import com.nc.assingment.service.QuizService;
import com.nc.assingment.utils.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizReposity quizReposity;
    private ModelMapper modelMapper = new ModelMapper();

    public QuizServiceImpl(QuizReposity quizReposity) {
        this.quizReposity = quizReposity;
    }

    @Override
    public List<QuizModel> getAllQuize() {
        List<QuizModel> quizModels = modelMapper.map(quizReposity.findAll(), List.class);
        return quizModels;
    }

    @Override
    public String getQuizResult(long id) {
        List<QuizEntity> quizEntityList2 = quizReposity.findAll();
        quizEntityList2.stream().forEach((i) -> createQuiz(modelMapper.map(i, QuizModel.class)));
        Optional<QuizEntity> quizEntity = quizReposity.findById(id);
        String ans = "";
        if (quizEntity.isEmpty()) {
            // exception trhoe
        } else {
            QuizModel quizModel = modelMapper.map(quizEntity, QuizModel.class);
            System.out.println("============" + quizModel.getQuestion());
            int index = quizModel.getAnswerIndex();
            ans = quizModel.getOptions().get(index);
        }
        return ans;
    }

    @Override
    public QuizModel createQuiz(QuizModel quizModel) {
        QuizEntity quizEntity = modelMapper.map(quizModel, QuizEntity.class);

        Date currentData = new Date();
        Date startDate = new Date(quizEntity.getStartDate());
        Date endDate = new Date(quizEntity.getEndDate());
        if (currentData.compareTo(startDate) > 0 && currentData.compareTo(endDate) < 0)
            quizEntity.setStatus(Status.active);
        else if (currentData.compareTo(endDate) > 0)
            quizEntity.setStatus(Status.finished);
        else if (currentData.compareTo(startDate) < 0)
            quizEntity.setStatus(Status.inactive);


        QuizEntity quizEntity1 = quizReposity.save(quizEntity);

        return modelMapper.map(quizEntity1, QuizModel.class);
    }

    @Override
    public List<QuizModel> getAllactiveQuizzes() {
        List<QuizEntity> quizEntityList2 = quizReposity.findAll();
        quizEntityList2.stream().forEach((i) -> createQuiz(modelMapper.map(i, QuizModel.class)));
        List<QuizEntity> quizEntityList = quizReposity.findAll();
        List<QuizEntity> quizEntity2 = quizEntityList.stream().filter((i) -> {
            if (i.getStatus().equals(Status.active))
                return true;
            else
                return false;

        }).collect(Collectors.toList());
        return modelMapper.map(quizEntity2, List.class);
    }
}
