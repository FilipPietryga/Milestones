export class TaskModel {
    id: number;
    name: string;
    description: string;
    status: string | null;
  
    constructor(id: number, name: string, description: string, status: string | null) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.status = status;
    }
  }
  