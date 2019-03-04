package com.strawpall.strawpall.repositories;

import com.strawpall.strawpall.models.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionReposiory extends CrudRepository<Question, Long> {
    List<Question> findAll();

    Question findByName(String text);
}
