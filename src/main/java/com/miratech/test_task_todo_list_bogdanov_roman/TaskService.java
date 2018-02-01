package com.miratech.test_task_todo_list_bogdanov_roman;

import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/rest/task")
public class TaskService {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ArrayList<Task> getAllTasks() {
        return Application.toDoList;
    }

    @RequestMapping(value = "/add"/*, method = RequestMethod.POST*/)    //do not specify a particular REST request(POST) to use it in address bar
    public Task addTask(@RequestParam(value = "title", required = false, defaultValue = "default title") String title) {
        Task task = new Task(title);
        Application.toDoList.add(task);
        return task;
    }


}
