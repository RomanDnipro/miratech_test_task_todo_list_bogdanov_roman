package com.miratech.test_task_todo_list_bogdanov_roman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@SpringBootApplication
public class Application {

    public static ArrayList<Task> toDoList = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Task task1 = new Task("bring water");
        Task task2 = new Task("finish the test task", LocalDate.of(2018, Month.FEBRUARY, 5));
        toDoList.add(task1);
        toDoList.add(task2);
    }
}
