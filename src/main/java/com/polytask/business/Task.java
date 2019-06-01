package com.polytask.business;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="task_ID")
    private int task_id;

    @Column(name="CONTENT")
    private String content;


    @Column(name="username")
    private String username;

    @Column(name="done")
    private int done;

    public Task(){

    }
    public Task(String content, String username){
        this.content = content;
        this.username = username;
        this.done = 0;
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

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }


    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }
}
