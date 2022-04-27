import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from './book';
import { Detail } from './detail';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseURL = "http://localhost:8080/books";
  constructor(private httpClient: HttpClient) { }

  getBooksList(): Observable<Book[]>{
    return this.httpClient.get<Book[]>(`${this.baseURL}`);
  }

  getBookById(id: string): Observable<Book>{
    return this.httpClient.get<Book>(`${this.baseURL}/${id}`);
  }

  getReturnBookList(): Observable<Detail[]>{
    return this.httpClient.get<Detail[]>("http://localhost:8080/return-book");
  }

  findBorrowService(data: any): Observable<Detail[]>{
    console.log( data );
    return this.httpClient.post<Detail[]>("http://localhost:8080/return-book", data);
  }

  startInventoryService(data: any): Observable<Detail[]>{
    console.log( data.borrowId );
    return this.httpClient.post<Detail[]>("http://localhost:8080/return-book/inventory/"+data.borrowId, data);
  }


  // getEmployeesList(): Observable<Employee[]>{
  //   return this.httpClient.get<Employee[]>(`${this.baseURL}`);
  // }

  // createEmployee(employee: Employee): Observable<Object>{
  //   return this.httpClient.post(`${this.baseURL}`, employee);
  // }

  // getEmployeeById(id: number): Observable<Employee>{
  //   return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  // }

  // updateEmployee(id: number, employee: Employee): Observable<Object>{
  //   return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  // }

  // deleteEmployee(id: number): Observable<Object>{
  //   return this.httpClient.delete(`${this.baseURL}/${id}`);
  // }
}
