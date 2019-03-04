package com.strawpall.strawpall.services;


import com.strawpall.strawpall.models.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnswerService {
    Answer addNewAnswer(String text);

    void deleteAnswer(long id);

    Answer getAnswerById(long id);

    List<Answer> getAllAnswer();

}
