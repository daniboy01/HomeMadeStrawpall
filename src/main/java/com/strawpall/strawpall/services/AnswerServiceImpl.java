package com.strawpall.strawpall.services;

import com.strawpall.strawpall.models.Answer;
import com.strawpall.strawpall.repositories.AnswerReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerReposiory answerRepo;

    @Autowired
    public void setAnswerRepo(AnswerReposiory answerRepo) {
        this.answerRepo = answerRepo;
    }

    @Override
    public Answer addNewAnswer(String text) {
        Answer answer = new Answer();
        answer.setName(text);
        answerRepo.save(answer);
        return answer;
    }

    @Override
    public void deleteAnswer(long id) {
        answerRepo.deleteById(id);
    }

    @Override
    public Answer getAnswerById(long id) {
        return answerRepo.findById(id).get();
    }

    @Override
    public List<Answer> getAllAnswer() {
        return answerRepo.findAll();
    }

    @Override
    public void init() {
        addNewAnswer("válasz1");
        addNewAnswer("válasz2");
        addNewAnswer("válasz3");
        addNewAnswer("válasz4");
    }

}
