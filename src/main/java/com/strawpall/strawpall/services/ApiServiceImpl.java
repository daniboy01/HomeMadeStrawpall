package com.strawpall.strawpall.services;

import com.strawpall.strawpall.Dtos.QuestionDto;
import com.strawpall.strawpall.models.Question;
import com.strawpall.strawpall.repositories.QuestionReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {
    private QuestionService questionService;
    private QuestionReposiory questionReposiory;

    @Autowired
    public ApiServiceImpl(QuestionService questionService, QuestionReposiory questionReposiory) {
        this.questionService = questionService;
        this.questionReposiory = questionReposiory;
    }

    @Override
    public QuestionDto getByID(long ID) {
        Question question = questionService.findById(ID);
        return parseQuestionToDto(question);
    }

    @Override
    public List<QuestionDto> getAllQuestion() {
        List<Question> questions = questionService.getAllQuestion();
        List<QuestionDto> dtos = new ArrayList<>();
        for (Question question : questions) {
            dtos.add(parseQuestionToDto(question));
        }
        return dtos;
    }

    private QuestionDto parseQuestionToDto(Question question) {
        QuestionDto actualDto = new QuestionDto();
        actualDto.name = question.getName();
        actualDto.ID = question.getID();
        actualDto.answers = question.getAnswers();
        return actualDto;
    }
}
