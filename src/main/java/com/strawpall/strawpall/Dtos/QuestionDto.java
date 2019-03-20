package com.strawpall.strawpall.Dtos;

import com.strawpall.strawpall.models.Answer;

import java.util.List;

public class QuestionDto {
    public long ID;
    public String name;
    public List<Answer> answers;

    public QuestionDto(long ID, String name, List<Answer> answers) {
        this.ID = ID;
        this.name = name;
        this.answers = answers;
    }

    public QuestionDto() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}

