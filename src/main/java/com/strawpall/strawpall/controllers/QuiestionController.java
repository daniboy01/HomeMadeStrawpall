package com.strawpall.strawpall.controllers;

import com.strawpall.strawpall.services.AnswerService;
import com.strawpall.strawpall.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuiestionController {
    private QuestionService questionService;
    private AnswerService answerService;

    @Autowired
    public QuiestionController(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping("/{id}")
    public String getQuestionPage(@PathVariable long id, Model model) {
        model.addAttribute("question", questionService.findById(id));
        return "question";
    }
}
