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

  getReturnBookList(): Observable<Detail[]>{
    return this.httpClient.get<Detail[]>("http://localhost:8080/return-book");
  }

  findBorrowService(data: any): Observable<Detail[]>{
    console.log( data );
    return this.httpClient.post<Detail[]>("http://localhost:8080/return-book", data);
  }

  startInventoryService(data: any): Observable<Detail[]>{
    return this.httpClient.post<Detail[]>("http://localhost:8080/return-book/start-inventory", data);
  }
}
