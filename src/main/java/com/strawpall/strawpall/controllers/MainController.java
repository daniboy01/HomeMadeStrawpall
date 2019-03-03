package com.strawpall.strawpall.controllers;


import com.strawpall.strawpall.services.AnswerService;
import com.strawpall.strawpall.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("questions", questionService.getAllQuestion());
        return "index";
    }

    @PostMapping("/addQuestion")
    public String addQuestion(String question) throws Exception {
        questionService.addNewQuestion(question);
        return "redirect:/";
    }

    @PostConstruct
    private void init() throws Exception {
        questionService.initQuestions();
    }

}
