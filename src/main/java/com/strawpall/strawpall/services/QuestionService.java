package com.strawpall.strawpall.services;

import com.strawpall.strawpall.models.Answer;
import com.strawpall.strawpall.models.Question;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

public interface QuestionService {
    boolean addNewQuestion(String text);

    boolean deleteQuestion(long QuiestionId);

    boolean addAnswerToQuestion(long questionID, long answerID);

    boolean removeAnswerFormQuestion(long questionID, long answerID);

    List<Question> getAllQuestion();

    Question findByText();

    Question findById(long id);

    List<Answer> getAnswersFromQuestion(long questionID);

    void initQuestions();
}
