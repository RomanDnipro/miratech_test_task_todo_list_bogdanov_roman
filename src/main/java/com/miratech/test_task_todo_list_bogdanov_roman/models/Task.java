package com.miratech.test_task_todo_list_bogdanov_roman.models;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.Size;

@Document(collection="tasks")
public class Task {

    @Id
    private long id;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true)
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isDone=" + isDone +
                ", dueDate=" + dueDate +
                '}';
    }
}
