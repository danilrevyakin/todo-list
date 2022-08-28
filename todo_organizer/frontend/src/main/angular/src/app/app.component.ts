import {Component, OnInit} from '@angular/core';
import { Task } from './task'
import {TaskService} from "./task.service";
import {HttpErrorResponse} from "@angular/common/http";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'todo-organizer';
  tasks: Task[] = [];
  editTask!: Task;
  deleteTask!: Task;
  navigationArray = [
    {'menuLink': '/all', 'menuName': 'All'},
    {'menuLink': '/active', 'menuName': 'Active'},
    {'menuLink': '/completed', 'menuName': 'Completed'}
  ]

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
       this.getTasks();
    }

  public getTasks():void{
    this.taskService.getAllTasks().subscribe(
      (response: Task[]) => {
        this.tasks = response;
      },
      (error: HttpErrorResponse) =>{
         alert(error.message);
      }
    );
  }

  public onOpenModal(task: Task, mode: string): void{
    const container = document.getElementById('main-content')
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add'){
      button.setAttribute('data-target', '#addTaskModal');
    }
    if (mode === 'delete'){
      this.deleteTask = task;
      button.setAttribute('data-target', '#deleteTaskModal');
    }
    if (mode === 'edit'){
      this.editTask = task;
      button.setAttribute('data-target', '#editTaskModal');
    }
    // @ts-ignore
    container.appendChild(button);
    button.click();
  }

  public getActiveTasks():void{
    this.taskService.getActiveTasks().subscribe(
      (response: Task[]) => {
        this.tasks = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }

  public getCompletedTasks():void {
    this.taskService.getCompletedTasks().subscribe(
      (response: Task[]) => {
        this.tasks = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  onUpdateTask(task: Task): void {
    this.taskService.updateTask(task).subscribe(
      (response: Task) => {
        console.log(response);
        this.getTasks();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteTask(taskId: number): void {
    this.taskService.deleteTask(taskId).subscribe(
      (response: void) => {
        console.log(response);
        this.getTasks();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddTask(addForm: NgForm): void {
    // @ts-ignore
    document.getElementById('add-task-form').click();
    this.taskService.addTask(addForm.value).subscribe(
      (response: Task) => {
        console.log(response);
        this.getTasks();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  getSomeTasks(menuName: string) {
    if (menuName === 'All'){
      this.getTasks();
    }
    if (menuName === 'Active'){
      this.getActiveTasks()
    }
    if (menuName === 'Completed'){
      this.getCompletedTasks()
    }
  }

  onChangeCheckbox(task: Task) {
    task.done = !task.done;
    this.taskService.updateTask(task).subscribe(
      (response: Task) => {
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
