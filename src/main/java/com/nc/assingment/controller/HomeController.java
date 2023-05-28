package com.nc.assingment.controller;

import com.nc.assingment.dto.QuizModel;
import com.nc.assingment.service.QuizService;
import com.nc.assingment.utils.ResponseUtil;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignment")
public class HomeController {
    @Autowired
    private QuizService quizService;

    public HomeController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("get")
    public String getAll() {
        return "Wellcome to college Bazaar";
    }

    @PostMapping("/quizzes")
    ResponseEntity<QuizModel> createQuiz(@RequestBody QuizModel userModel) {
        return ResponseUtil.create(quizService.createQuiz(userModel));
    }

    @GetMapping("/quizzes/active")
    ResponseEntity<List<QuizModel>> activeQuiz() {
        return ResponseUtil.ok(quizService.getAllactiveQuizzes());
    }

    @GetMapping("/quizzes/all")
    ResponseEntity<List<QuizModel>> getAllQuiz() {
        return ResponseUtil.ok(quizService.getAllQuize());
    }

    @GetMapping("/quizzes/{id}/result")
    ResponseEntity<String> getResult(@PathVariable(name="id")long id)
    {
        return  ResponseUtil.ok(quizService.getQuizResult(id));
    }


}
