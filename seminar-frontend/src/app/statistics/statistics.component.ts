import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { Statistics } from '../statistics';
import { StatisticsService } from '../statistics.service';
import { User } from '../user';


@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  users: User[] = [];
  statistics: Statistics[] = [];


  ngOnInit(): void {
  }

  constructor(private calendar: NgbCalendar, private statisticsService: StatisticsService) {
  }
  
  model1: NgbDateStruct | undefined;
  model2: NgbDateStruct | undefined;

  date: { year: number; month: number; } | undefined;
  
  submitForm = new FormGroup({
  });
  start:string | undefined;
  end:string | undefined;
  d:string | undefined;

  public submitCom(){
    if(this.model1==null){
      alert("Please choose started date!");
      return;
    }
    if(this.model2==null){
      alert("Please choose end date!");
      return;
    }
    const month1 = this.model1?.month || 0;
    const month2 = this.model2?.month || 0;

    if(month1 < 10 && month2 < 10){
      this.start =  this.model1?.year.toString() + "-0" + this.model1?.month + "-" + this.model1?.day;
      this.end =  this.model2?.year.toString() + "-0" + this.model2?.month + "-" + this.model2?.day;
      this.d = this.start + "," + this.end;
    }else{
      this.start =  this.model1?.year.toString() + "-" + this.model1?.month + "-" + this.model1?.day;
      this.end =  this.model2?.year.toString() + "-" + this.model2?.month + "-" + this.model2?.day;
      this.d = this.start + "," + this.end;
    }
    
    this.statisticsService.getStatisticsList(this.d).subscribe(data => {
      data.forEach( (value) => {        
        const temp = value.borrowDate?.slice(0,10);
        value.borrowDate = temp;
      });
      data.forEach( (value) => {        
        const temp = value.dueDate?.slice(0,10);
        value.dueDate = temp;

      });
      data.forEach( (value) => {        
        const temp = value.returnedDate?.slice(0,10);
        value.returnedDate = temp;

      });
      this.statistics = data;
    });

  }


  exportForm = new FormGroup({
    // borrowId: new FormControl( '' )
  });
  public exportCom(){}


  

  selectToday() {
    this.model1 = this.calendar.getToday();
  }

}
