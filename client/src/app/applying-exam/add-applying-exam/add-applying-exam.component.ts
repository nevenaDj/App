import { Component, OnInit } from '@angular/core';
import { ExaminationPeriod } from '../../model/examination-period';
import { ExaminationPeriodService } from '../../examination-period/examination-period.service';
import { ApplyingExamService } from '../applying-exam.service';
import { ApplyingExam } from '../../model/applying-exam';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-applying-exam',
  templateUrl: './add-applying-exam.component.html',
  styleUrls: ['./add-applying-exam.component.css']
})
export class AddApplyingExamComponent implements OnInit {
  examinationPeriods: ExaminationPeriod[];
  applyingExam: ApplyingExam;

  constructor(private examinationPeriodService: ExaminationPeriodService,
              private applyingExamService: ApplyingExamService,
              private router: Router) {

    this.applyingExam = {
      id: null,
      flag: false,
      subject: null   
    }            
    this.examinationPeriodService.getAllDepartmans()
        .then(res => this.examinationPeriods = res);
    
   }

  addApplyinExam(id: number){
    this.applyingExamService.addApplyingExam(this.applyingExam, id)
        .then(res => this.router.navigate(['student']));
  }

  ngOnInit() {
  }

}
