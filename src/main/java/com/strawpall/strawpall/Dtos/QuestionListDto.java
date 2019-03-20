package com.strawpall.strawpall.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.strawpall.strawpall.models.Question;

import java.util.List;

public class QuestionListDto {
    public List<Question> questions;

    public QuestionListDto(List<Question> questions) {
        this.questions = questions;
    }
}
