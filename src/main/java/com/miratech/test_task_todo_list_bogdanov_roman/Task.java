package com.miratech.test_task_todo_list_bogdanov_roman;

import java.util.Date;
import java.time.LocalDate;

public class Task {

    private long id;
    private String title;
    private boolean done = false;
    private LocalDate dueDate;

    public Task(String title, LocalDate dueDate) {
        this.id = new Date().getTime();
        this.title = title;
        this.dueDate = dueDate;
    }

    public Task(String title) {
        this.title = title;
    }

    public Task() {
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
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
