import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Subject } from '../../model/subject';
import { SubjectService } from '../../subjects/subject.service';
import { Router } from '@angular/router';
import { ToastsManager } from 'ng2-toastr';
import { ExaminationPeriodService } from '../examination-period.service';
import { ExaminationPeriod } from '../../model/examination-period';

@Component({
  selector: 'app-add-eperiod',
  templateUrl: './add-eperiod.component.html',
  styleUrls: ['./add-eperiod.component.css']
})
export class AddEperiodComponent implements OnInit {

  subjects: Subject[];
  subject: Subject;
  examinationPeriod: ExaminationPeriod;


  constructor(private subjectService: SubjectService,
              private ePeriodService: ExaminationPeriodService,
              private router: Router,
              private toastr: ToastsManager, 
              private vcr: ViewContainerRef) {
    this.toastr.setRootViewContainerRef(vcr); 
    this.examinationPeriod = {
      id: null,
      date: '',
      subject: null
    }
   
    this.subjectService.getAllSubjects()
        .then(res => this.subjects = res);
   }

   ngOnInit() {
    if(window.location.href.indexOf("loaded") > -1) {}
    else{
      let win = (window as any);
      win.location.href = "/#/admin/examinationPeriod/add/loaded";
      win.location.reload();
    }
  }

  save(){
    this.ePeriodService.addExaminationPeriod(this.examinationPeriod, this.subject.id)
      .then(res => this.router.navigate(['admin']))
      .catch(res => this.toastr.error('Prilikom upisa ispitnog roka došlo je do greške.'));
  }

}
