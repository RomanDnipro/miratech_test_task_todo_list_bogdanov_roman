package com.miratech.test_task_todo_list_bogdanov_roman;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/rest/task")
public class TaskService {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HashMap<Long, Task> getAllTasks() {
        return Application.toDoMap;
    }

    @RequestMapping(value = "/add"/*, method = RequestMethod.POST*/)    //do not specify a particular REST request(POST) to use it in address bar
    public Task addTask(@RequestParam(value = "title", required = false, defaultValue = "default title") String title) {
        Task task = new Task(title);
        Application.toDoMap.put(task.getId(), task);
        return task;
    }

    @RequestMapping(value = "/delete/{id}"/*, method = RequestMethod.DELETE*/)  //do not specify a particular REST request(DELETE) to use it in address bar
    public Task deleteTask(@PathVariable long id){
        return Application.toDoMap.remove(id);
    }


}
