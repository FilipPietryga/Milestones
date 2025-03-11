import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private apiUrl = 'http://localhost:8080/api/tasks';

  constructor(private http: HttpClient) { }

  getTasks(): Observable<string> {
    return this.http.get(this.apiUrl, { responseType: 'text' });
  }
}
