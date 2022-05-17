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

  constructor(private book: BookService) { }

  findBorrowForm = new FormGroup({
    borrowId: new FormControl( '' )
  });

  

  ngOnInit(): void {
    this.getReturnBook();
  }

  private getReturnBook(){
    this.book.getReturnBookList().subscribe(data => {
      data.forEach( (value) => {   
        if(value.returnedDate!=null) {
          const temp = value.returnedDate?.slice(0,10);
          value.returnedDate = temp;
          this.details = data;
        }  
      });
    });
  }

  public findBorrowCom(){ // search button handle
    // this.book.findBorrowService( this.findBorrowForm.value ).subscribe((result) => console.log( result[0].borrow?.id ))
  }

  startInventoryForm = new FormGroup({
    borrowId: new FormControl( '' )
  });

  nameBook:any;
  count=1
  startInventoryCom(){
    // this.book.findBorrowService( this.findBorrowForm.value ).subscribe((result) => console.log( result ))

    // this.details = this.details.filter(result => {        
    //   return result.note="true";  
    // });
    this.book.startInventoryService( this.findBorrowForm.value ).subscribe((result) => {
    if(result==null){
      alert("No tag scanned!")
    }
    });

    this.book.startInventoryService( this.findBorrowForm.value ).subscribe((result) => {
      result.forEach( (value) => {        
        if(value.note){
          console.log("ok");
          // !value.note;
          this.details.forEach(element => {
            if(element.bookId==value.bookId){
              element.note="true";
            }
          });
          
          // this.searchCheckBox(value.bookId);

        }
      });    
    });

  }



  
  searchCheckBox(bookIdInput: any):void{
    this.details  = this.details.filter(result => {     
      return (result.bookId)?.toString()?.match(bookIdInput);
      })  
  }


  // search
  id:any;
  search(){
    if(this.id == ""){
      this.ngOnInit();
      // console.log("rong");
      
    }else{
      this.details = this.details.filter(result => {        
        return (result.borrow?.id)?.toString()?.match(this.id);     
      })
    }
  }

  returnBooksForm = new FormGroup({
    borrowId: new FormControl( '' )
  });

  nD: any;
  public returnBooksCom(){ // return book button handle
    // console.log( this.findBorrowForm.value );
    this.book.updateDetailsService( this.findBorrowForm.value ).subscribe((data) => {
      data.forEach( (value) => {        
        const temp = value.returnedDate?.slice(0,10);
        value.returnedDate = temp;

      });
      this.details = data.filter(result => {        
        return (result.borrow?.id)?.toString()?.match(this.id);     
      })
    }    
    )
    
  }

}



