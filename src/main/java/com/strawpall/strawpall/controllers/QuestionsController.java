package com.strawpall.strawpall.controllers;

import com.strawpall.strawpall.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionsController {
    private QuestionService questionService;

    @Autowired
    public QuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public String listQuestions(Model model) {
        model.addAttribute("questions",questionService.getAllQuestion());
        return "index";
    }
}
