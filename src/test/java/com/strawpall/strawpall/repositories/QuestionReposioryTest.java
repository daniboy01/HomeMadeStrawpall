package com.strawpall.strawpall.repositories;

import com.strawpall.strawpall.models.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionReposioryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private QuestionReposiory questionReposiory;

    @Test
    public void findByNameTest() {
        Question question = new Question();
        question.setName("This is the question");
        testEntityManager.persist(question);
        testEntityManager.flush();

        //when
        Question found = questionReposiory.findByName(question.getName());

        //then
        assertThat(found.getName()).isEqualTo(question.getName());
    }
}