package com.strawpall.strawpall.services;

import com.strawpall.strawpall.Dtos.QuestionDto;

import java.util.List;

public interface ApiService {
    QuestionDto getByID(long ID);
    List<QuestionDto> getAllQuestion();
}
