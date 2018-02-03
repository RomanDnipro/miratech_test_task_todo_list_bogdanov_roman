package com.miratech.test_task_todo_list_bogdanov_roman.repositories;

import com.miratech.test_task_todo_list_bogdanov_roman.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

}
