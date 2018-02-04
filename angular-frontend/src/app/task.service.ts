import { Injectable } from '@angular/core';
import { Task } from './task';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class TaskService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: Http) { }

  getTasks():  Promise<Task[]> {
    return this.http.get(this.baseUrl + '/api/')
      .toPromise()
      .then(response => response.json() as Task[])
      .catch(this.handleError);
  }

  createTask(taskData: Task): Promise<Task> {
    return this.http.post(this.baseUrl + '/api/', taskData)
      .toPromise().then(response => response.json() as Task)
      .catch(this.handleError);
  }

  updateTask(taskData: Task): Promise<Task> {
    return this.http.put(this.baseUrl + '/api/' + taskData.id, taskData)
      .toPromise()
      .then(response => response.json() as Task)
      .catch(this.handleError);
  }

  deleteTask(id: long): Promise<any> {
    return this.http.delete(this.baseUrl + '/api/' + id)
      .toPromise()
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}