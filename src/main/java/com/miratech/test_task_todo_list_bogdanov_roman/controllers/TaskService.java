package com.miratech.test_task_todo_list_bogdanov_roman.controllers;

import com.miratech.test_task_todo_list_bogdanov_roman.Application;
import com.miratech.test_task_todo_list_bogdanov_roman.models.Task;
import com.miratech.test_task_todo_list_bogdanov_roman.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/")
    public List<Task> getAllTasks() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAT");
        return taskRepository.findAll(sortByCreatedAtDesc);
    }

    @RequestMapping(value = "/add"/*, method = RequestMethod.POST*/)
    //do not specify a particular REST request(POST) to use it in browser address bar
    public Task addTask(@RequestBody String title) {
        Task task = new Task(title);
        Application.toDoMap.put(task.getId(), task);
        return task;
    }

    @RequestMapping(value = "/delete/{id}"/*, method = RequestMethod.DELETE*/)
    //do not specify a particular REST request(DELETE) to use it in browser address bar
    public Task deleteTask(@PathVariable long id) throws Exception {
        if (Application.toDoMap.containsKey(id)) {
            return Application.toDoMap.remove(id);
        } else {
            throw new Exception("Task " + id + " does not exists");
        }
    }

    @RequestMapping(value = "/done/{id}"/*, method = RequestMethod.PUT*/)
    //do not specify a particular REST request(PUT) to use it in browser address bar
    public Task setDone(@PathVariable long id) throws Exception {
        return changeDone(id, true);
    }

    @RequestMapping(value = "/notDone/{id}"/*, method = RequestMethod.PUT*/)
    //do not specify a particular REST request(PUT) to use it in browser address bar
    public Task setNotDone(@PathVariable long id) throws Exception {
        return changeDone(id, false);
    }

    @RequestMapping(value = "/switchDone/{id}"/*, method = RequestMethod.PUT*/)
    //do not specify a particular REST request(PUT) to use it in browser address bar
    public Task switchDone(@PathVariable long id) throws Exception {
        if (Application.toDoMap.containsKey(id)) {
            Task task = Application.toDoMap.get(id);
            task.setDone(!task.isDone());
            return task;
        } else {
            throw new Exception("Task " + id + " does not exists");
        }
    }

    private Task changeDone(long id, boolean isDone) throws Exception {
        if (Application.toDoMap.containsKey(id)) {
            Task task = Application.toDoMap.get(id);
            task.setDone(isDone);
            return task;
        } else {
            throw new Exception("Task " + id + " does not exists");
        }
    }
}
