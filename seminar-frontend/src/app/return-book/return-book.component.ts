import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms'
import { BookService } from '../book.service'
import { Detail } from '../detail';


@Component({
  selector: 'app-return-book',
  templateUrl: './return-book.component.html',
  styleUrls: ['./return-book.component.css']
})
export class ReturnBookComponent implements OnInit {
  details: Detail[] = [];

  searchPost: any;
  searchTerm!: string;


  constructor(private book: BookService) { }

  findBorrowForm = new FormGroup({
    borrowId: new FormControl( '' )
  });

  ngOnInit(): void {
    this.getReturnBook();
  }

  private getReturnBook(){
    this.book.getReturnBookList().subscribe(data => {
      this.details = data;
    });
  }

  search(post: string){
     this.details = this.searchPost.filter((val: any) => 
     val.id.toLowerCase().includes(post))
  }

  findBorrowCom(){
    this.book.findBorrowService( this.findBorrowForm.value ).subscribe((result) => console.log( result ),)
  }

  startInventoryForm = new FormGroup({
    borrowId: new FormControl( '' )
  });

  startInventoryCom(){
    this.book.findBorrowService( this.findBorrowForm.value ).subscribe((result) => console.log( result ))
  }
}
