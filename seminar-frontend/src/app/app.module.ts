import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; // setup for server communication
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './book-list/book-list.component';
import { ReturnBookComponent } from './return-book/return-book.component';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { StatisticsComponent } from './statistics/statistics.component';
import { SearchfilterPipe } from './searchfilter.pipe';
import {Ng2SearchPipeModule} from 'ng2-search-filter';



@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    ReturnBookComponent,
    StatisticsComponent,
    SearchfilterPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
