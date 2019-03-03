package com.strawpall.strawpall.services;

import com.strawpall.strawpall.models.Answer;
import com.strawpall.strawpall.models.Question;
import com.strawpall.strawpall.repositories.AnswerReposiory;
import com.strawpall.strawpall.repositories.QuestionReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionReposiory questionRepo;
    private AnswerReposiory answerRepo;

    @Autowired
    public QuestionServiceImpl(QuestionReposiory questionRepo, AnswerReposiory answerRepo) {
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
    }

    @Override
    public boolean addNewQuestion(String text) throws Exception {
        try {
            Question question = new Question();
            question.setQuestionText(text);
            questionRepo.save(question);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteQuestion(long quiestionId) throws Exception {
        try {
            questionRepo.deleteById(quiestionId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addAnswerToQuestion(long questionID, long answerID) throws Exception {
        try {
            Question question = questionRepo.findById(questionID).get();
            Answer answer = answerRepo.findById(answerID).get();
            question.getAnswers().add(answer);
            answer.setQuestion(question);
            questionRepo.save(question);
            answerRepo.save(answer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeAnswerFormQuestion(long questionID, long answerID) throws Exception {
        try {
            Question question = questionRepo.findById(questionID).get();
            Answer answer = answerRepo.findById(answerID).get();
            question.getAnswers().remove(answer);
            answer.setQuestion(null);
            questionRepo.save(question);
            answerRepo.save(answer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepo.findAll();
    }


    //todo finish this
    @Override
    public Question findByText() {
        return null;
    }


}