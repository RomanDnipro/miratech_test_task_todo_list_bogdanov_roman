package com.miratech.test_task_todo_list_bogdanov_roman.controllers;

import com.miratech.test_task_todo_list_bogdanov_roman.models.Task;
import com.miratech.test_task_todo_list_bogdanov_roman.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/")
    public Task addTask(@Valid @RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        Task task = taskRepository.findOne(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTas(@PathVariable("id") Long id,
                                          @Valid @RequestBody Task task) {
        Task taskData = taskRepository.findOne(id);
        if (taskData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        taskData.setTitle(task.getTitle());
        taskData.setDone(task.isDone());
        Task updatedTask = taskRepository.save(taskData);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        taskRepository.delete(id);
    }
}
