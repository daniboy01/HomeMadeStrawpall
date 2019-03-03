package com.strawpall.strawpall.services;

import com.strawpall.strawpall.models.Answer;
import com.strawpall.strawpall.models.Question;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public interface QuestionService {
    boolean addNewQuestion(String text) throws Exception;

    boolean deleteQuestion(long QuiestionId) throws Exception;

    boolean addAnswerToQuestion(long questionID, long answerID) throws Exception;

    boolean removeAnswerFormQuestion(long questionID, long answerID) throws Exception;

    List<Question> getAllQuestion();

    Question findByText();
}
