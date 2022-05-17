import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';
import { Statistics } from './statistics';



@Injectable({
  providedIn: 'root'
})
export class StatisticsService {
  private baseURL =  "http://localhost:8080/statistics";
  constructor(private httpClient: HttpClient) { }

  getUsersList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}`);
  }

  getStatisticsList(date: any): Observable<Statistics[]>{
    console.log( date );
    return this.httpClient.post<Statistics[]>("http://localhost:8080/statistics/"+date, date);
  }
}
