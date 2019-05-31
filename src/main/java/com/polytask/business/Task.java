package com.polytask.business;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue
    private int task_id;

    @Column(name="CONTENT")
    private String content;

    public Task(){

    }

    public Task(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "task{" +
                "content='" + content + '\'' + '}';
    }
}
