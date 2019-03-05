package com.strawpall.strawpall.controllers;

import com.strawpall.strawpall.services.AnswerService;
import com.strawpall.strawpall.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/{questionID}")
    public String getQuestionPage(@PathVariable long questionID, Model model) {
        model.addAttribute("question", questionService.findById(questionID));
        model.addAttribute("allAnswer", answerService.getAllAnswer());
        model.addAttribute("answers",questionService.getAnswersFromQuestion(questionID));
        return "question";
    }

    @PostMapping("/{questionID}/addAnswer/{answerID}")
    public String addAnswerToQuestion(@PathVariable long questionID, @PathVariable long answerID) {
        questionService.addAnswerToQuestionByIDs(questionID,answerID);
        return "redirect:/{questionID}";
    }

    @PostMapping("/{questionID}/addAnswer")
    public String addAnswer(@PathVariable long id,String answerText) {
        questionService.addAnswerByUser(id,answerText);
        return "redirect:/{questionID}";
    }

    @GetMapping("/{questionID}/fill")
    public String fillQuestion(@PathVariable long questionID,Model model) {
        model.addAttribute("question",questionService.findById(questionID));
        model.addAttribute("answers",questionService.getAnswersFromQuestion(questionID));
        return "fill";
    }

    @PostMapping("/{questionID}/fill/{answerID}")
    public String tickOneAnswer(@PathVariable long questionID, @PathVariable long answerID) {
        questionService.validateQuestion(questionID, answerID);
        return "redirect:/{questionID}/fill}";
    }
}
