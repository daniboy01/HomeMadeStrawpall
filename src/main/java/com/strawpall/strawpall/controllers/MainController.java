package com.strawpall.strawpall.controllers;

import com.strawpall.strawpall.services.AnswerService;
import com.strawpall.strawpall.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class MainController {
    private AnswerService answerService;
    private QuestionService questionService;

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    //    @PostConstruct
//    private void init() throws Exception {
//        answerService.addNewAnswer("Ez a válasz");
//        questionService.addNewQuestion("Ez itt a kérdés");
//
//    }
}
