import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { ProfessorService } from '../../professors/professor.service';
import { DepartmanService } from '../../departmans/departman.service';
import { Router } from '@angular/router';
import { ToastsManager } from 'ng2-toastr';
import { Professor } from '../../model/professor';
import { Departman } from '../../model/departman';
import { Subject } from '../../model/subject';
import { SubjectService } from '../subject.service';

@Component({
  selector: 'app-add-subject',
  templateUrl: './add-subject.component.html',
  styleUrls: ['./add-subject.component.css']
})
export class AddSubjectComponent implements OnInit {

  prof: Professor;
  profs: Professor[];
  departmans: Departman[];
  departman: Departman;
  subject: Subject;


  constructor(private profService: ProfessorService,
              private departmanService: DepartmanService,
              private subjectService: SubjectService,
              private router: Router,
              private toastr: ToastsManager, 
              private vcr: ViewContainerRef) {
    this.toastr.setRootViewContainerRef(vcr); 
    this.prof = {
      id: null,
      user : {
        id: null,
        firstName: '',
        lastName: '',
        username: '',
        roles: []

      },
      departman: null
    }
    this.departman = {
      id: null,
      name: ''
    }
    this.subject = {
      id: null,
      name: ''
    }
    this.departmanService.getAllDepartmans()
        .then(res => 
          {
            this.departmans = res;
            this.profService.getAllProfessors()
                .then(profs => this.profs = profs);
          });


   }

   ngOnInit() {
    if(window.location.href.indexOf("loaded") > -1) {}
    else{
      let win = (window as any);
      win.location.href = "/#/admin/subjects/add/loaded";
      win.location.reload();
    }
  }

  save(){
    this.subjectService.addSubject(this.subject, this.departman.id, this.prof.id)
      .then(res => this.router.navigate(['admin']))
      .catch(res => this.toastr.error('Prilikom upisa predmeta došlo je do greške.'));
  }

}
