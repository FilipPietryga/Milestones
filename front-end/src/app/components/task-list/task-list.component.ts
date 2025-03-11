import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../services/task/task.service';
import { TaskComponent } from "../task/task.component";
import { TaskModel } from '../../models/task/task.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [TaskComponent, CommonModule],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.sass'
})
export class TaskListComponent implements OnInit {
  tasks: TaskModel[] = [];
  todoTasks: TaskModel[] = [];
  inProgressTasks: TaskModel[] = [];
  doneTasks: TaskModel[] = [];

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
    this.fetchTasks();
  }

  fetchTasks(): void {
    this.taskService.getTasks().subscribe((data: TaskModel[]) => {
      this.tasks = data;
      this.todoTasks = this.tasks.filter(task => task.status === 'todo');
      this.inProgressTasks = this.tasks.filter(task => task.status === 'in_progress');
      this.doneTasks = this.tasks.filter(task => task.status === 'done');
    });
  }
}