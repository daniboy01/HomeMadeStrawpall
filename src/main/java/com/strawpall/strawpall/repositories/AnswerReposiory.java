package com.strawpall.strawpall.repositories;

import com.strawpall.strawpall.models.Answer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerReposiory extends CrudRepository<Answer, Long> {
    List<Answer> findAll();
    Answer findByName(String name);
}
