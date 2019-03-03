package com.strawpall.strawpall.services;


import org.springframework.stereotype.Service;

public interface AnswerService {
    boolean addNewAnswer(String text) throws Exception;

    boolean deleteAnswer(long id) throws Exception;
}
