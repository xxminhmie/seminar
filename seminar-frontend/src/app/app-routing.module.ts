import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { ReturnBookComponent } from './return-book/return-book.component';

const routes: Routes = [
  {path: 'books', component: BookListComponent},
  {path: 'return-book', component: ReturnBookComponent},
  {path: '', redirectTo: 'books', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
