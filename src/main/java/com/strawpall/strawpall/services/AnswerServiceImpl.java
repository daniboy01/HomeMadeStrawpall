package com.strawpall.strawpall.services;

import com.strawpall.strawpall.models.Answer;
import com.strawpall.strawpall.repositories.AnswerReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerReposiory answerRepo;

    @Autowired
    public AnswerServiceImpl(AnswerReposiory answerRepo) {
        this.answerRepo = answerRepo;
    }

    @Override
    public boolean addNewAnswer(String text) throws Exception {
        try {
            Answer answer = new Answer();
            answer.setAnswerText(text);
            answerRepo.save(answer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAnswer(long id) throws Exception {
        try {
            answerRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
