export class TaskModel {
    id: number;
    name: string;
    description: string;
    status: 'todo' | 'in_progress' | 'done';
  
    constructor(id: number, name: string, description: string, status: 'todo' | 'in_progress' | 'done') {
      this.id = id;
      this.name = name;
      this.description = description;
      this.status = status;
    }
  }
  