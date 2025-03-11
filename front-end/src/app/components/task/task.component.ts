import { Component, Input } from '@angular/core';
import { TaskModel } from '../../models/task/task.model';

@Component({
  selector: 'app-task',
  standalone: true,
  imports: [],
  templateUrl: './task.component.html',
  styleUrl: './task.component.sass'
})
export class TaskComponent {
  @Input() task: TaskModel | null = null;  
}
