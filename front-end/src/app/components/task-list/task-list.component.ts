import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../services/task/task.service';
import { TaskComponent } from "../task/task.component";
import { TaskModel } from '../../models/task/task.model';
import { CommonModule } from '@angular/common';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { DragDropModule } from '@angular/cdk/drag-drop'; 

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [TaskComponent, CommonModule, DragDropModule],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.sass'
})
export class TaskListComponent implements OnInit {
[x: string]: any;
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

  onDrop(event: CdkDragDrop<TaskModel[]>, newStatus: string) {
    const task: TaskModel = event.item.data;
  
    if (event.previousContainer !== event.container) {
      event.previousContainer.data.splice(event.previousIndex, 1);
  
      task.status = newStatus;
  
      event.container.data.splice(event.currentIndex, 0, task);
  
      this.taskService.updateTask(task.id, task).subscribe(
        () => console.log('Task status updated to:', newStatus),
        (error) => console.error('Failed to update task:', error)
      );
    } else {
      moveItemInArray(
        event.container.data,
        event.previousIndex,
        event.currentIndex
      );
    }
  }
}