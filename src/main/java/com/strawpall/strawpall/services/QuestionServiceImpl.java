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
    private AnswerService answerService;

    @Autowired
    public QuestionServiceImpl(QuestionReposiory questionRepo, AnswerReposiory answerRepo, AnswerService answerService) {
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
        this.answerService = answerService;
    }

    @Override
    public boolean addNewQuestion(String text){
        try {
            Question question = new Question();
            question.setName(text);
            questionRepo.save(question);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteQuestion(long quiestionId){
        try {
            questionRepo.deleteById(quiestionId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addAnswerToQuestionByIDs(long questionID, long answerID){
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
    public boolean removeAnswerFormQuestion(long questionID, long answerID){
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


    @Override
    public Question findByText() {
        return null;
    }

    @Override
    public Question findById(long id) {
        return questionRepo.findById(id).get();
    }

    @Override
    public List<Answer> getAnswersFromQuestion(long questionID) {
        Question actualQuestion = questionRepo.findById(questionID).get();
        return actualQuestion.getAnswers();
    }

    @Override
    public void initQuestions(){
        addNewQuestion("Kérdés1");
        addNewQuestion("Kérdés2");
        addNewQuestion("Kérdés3");
        addNewQuestion("Kérdés4");
    }

    @Override
    public boolean addAnswerByUser(long id, String answerText, boolean isRight) {
        try {
            Question actualQuestion = questionRepo.findById(id).get();
            Answer actualAnswer = answerService.addNewAnswer(answerText);
            actualAnswer.setRight(isRight);
            answerRepo.save(actualAnswer);
            addAnswerToQuestionByIDs(actualQuestion.getID(),actualAnswer.getID());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String validateQuestion(long questionID, long answerID) {
        Question question = questionRepo.findById(questionID).get();
        Answer answer = answerRepo.findById(answerID).get();

        if (!question.getAnswers().contains(answer)){
            return "This answer is not element of question!";
        }
        for (Answer actualAnswer : question.getAnswers()) {
            if (actualAnswer.isRight() && actualAnswer.equals(answer)) {
                return "The answer is correct!";
            }
        }
        return "The answer is not correct!";
    }


}
