import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseURL = "http://localhost:8080/login";
  constructor(private httpClient: HttpClient) { }

  check(data: any): Observable<Boolean>{
    return this.httpClient.post<Boolean>("http://localhost:8080/login/"+data, data);
  }
}
