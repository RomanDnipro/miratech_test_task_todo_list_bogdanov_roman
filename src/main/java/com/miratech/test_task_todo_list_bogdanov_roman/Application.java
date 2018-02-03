package com.miratech.test_task_todo_list_bogdanov_roman;

import com.miratech.test_task_todo_list_bogdanov_roman.models.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

@SpringBootApplication
public class Application {

//    public static HashMap<Long, Task> toDoMap = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

//        Task task1 = new Task("test1 bring water");
//        Task task2 = new Task("test2 finish the test task", LocalDate.of(2018, Month.FEBRUARY, 5));
//        toDoMap.put(task1.getId(), task1);
//        toDoMap.put(task2.getId(), task2);
    }
}
