package com.strawpall.strawpall.controllers;

import com.strawpall.strawpall.Dtos.QuestionDto;
import com.strawpall.strawpall.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    private ApiService service;

    @Autowired
    public ApiController(ApiService service) {
        this.service = service;
    }

    @GetMapping("/question/{id}")
    public QuestionDto getQuestionById(@PathVariable long id) {
        return service.getByID(id);
    }
}
