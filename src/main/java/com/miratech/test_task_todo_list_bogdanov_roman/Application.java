package com.miratech.test_task_todo_list_bogdanov_roman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

    public static ArrayList<Task> toDoList;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
