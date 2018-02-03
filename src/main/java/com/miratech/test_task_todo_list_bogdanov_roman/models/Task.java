package com.miratech.test_task_todo_list_bogdanov_roman.models;

import java.util.Date;
import java.time.LocalDate;

public class Task {

    private long id;
    private String title;
    private boolean isDone = false;
    private LocalDate dueDate;

    public Task(String title, LocalDate dueDate) {
        this.id = new Date().getTime();
        this.title = title;
        this.dueDate = dueDate;
    }

    public Task(String title) {
        this.id = new Date().getTime();
        this.title = title;
    }

    public Task() {
        this.id = new Date().getTime();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
