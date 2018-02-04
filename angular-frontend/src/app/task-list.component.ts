import { Component, OnInit } from '@angular/core';
import { Task } from './task';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'task-list',
  templateUrl: './task-list.component.html'
})

export class TaskListComponent implements OnInit {
  tasks: Task[];
  newTask: Task = new Task();
  editing: boolean = false;
  editingTask: Task = new Task();

  ngOnInit(): void {
    this.getTasks();
  }

  getTasks(): void {

  }

  createTask(taskForm: NgForm): void {

  }

  deleteTask(id: long): void {

  }

  updateTask(taskData: Task): void {

  }

  toggleCompleted(taskData: Task): void {

  }

  editTask(taskData: Task): void {

  }

  clearEditing(): void {

  }
}