import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from './task';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class TaskService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getAllTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiServerUrl}/all`);
  }

  public getActiveTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiServerUrl}/active`);
  }

  public getCompletedTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiServerUrl}/completed`);
  }

  public addTask(task: Task): Observable<Task> {
    return this.http.post<Task>(`${this.apiServerUrl}/add`, task);
  }

  public updateTask(task: Task): Observable<Task> {
    return this.http.put<Task>(`${this.apiServerUrl}/update`, task);
  }

  public deleteTask(taskId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/delete/${taskId}`);
  }
}
