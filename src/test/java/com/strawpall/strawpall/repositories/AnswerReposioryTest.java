package com.strawpall.strawpall.repositories;

import com.strawpall.strawpall.models.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnswerReposioryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AnswerReposiory answerReposiory;

    @Test
    public void findByAnswerTextTest() {
        Answer answer = new Answer();
        answer.setName("This is an answer!");
        entityManager.persist(answer);
        entityManager.flush();

        //when
        Answer found = answerReposiory.findByName(answer.getName());

        //then
        assertThat(found.getName()).isEqualTo(answer.getName());
    }
}