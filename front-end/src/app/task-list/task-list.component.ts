import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';
import { TaskComponent } from "../task/task.component";
import { Task } from '../task';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [TaskComponent],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.sass'
})
export class TaskListComponent implements OnInit {
  tasks: Task[] = [];  

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
    this.taskService.getTasks().subscribe(
      (data) => {
        this.tasks = data;  
      },
      (error) => {
        console.error('Error fetching tasks:', error);
      }
    );
  }
}