import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Professor } from '../../model/professor';
import { ProfessorService } from '../professor.service';
import { Router } from '@angular/router';
import { ToastsManager } from 'ng2-toastr';
import { Departman } from '../../model/departman';
import { DepartmanService } from '../../departmans/departman.service';

@Component({
  selector: 'app-add-professor',
  templateUrl: './add-professor.component.html',
  styleUrls: ['./add-professor.component.css']
})
export class AddProfessorComponent implements OnInit {

  prof: Professor;
  departmans: Departman[];


  constructor(private profService: ProfessorService,
              private departmanService: DepartmanService,
              private router: Router,
              private toastr: ToastsManager, 
              private vcr: ViewContainerRef) {
    this.toastr.setRootViewContainerRef(vcr); 
    this.prof = {
      id: null,
      user: {
        id: null,
        firstName: '',
        lastName: '',
        username: '',
        roles: ['ROLE_USER']
      },
      departman: null
    }
    this.departmanService.getAllDepartmans()
        .then(res => this.departmans = res);


   }

   ngOnInit() {
    if(window.location.href.indexOf("loaded") > -1) {}
    else{
      let win = (window as any);
      win.location.href = "/#/admin/professors/add/loaded";
      win.location.reload();
    }
  }

  save(){
    this.profService.addProfessor(this.prof, this.prof.departman.id)
      .then(res => this.router.navigate(['admin']))
      .catch(res => this.toastr.error('Prilikom upisa profesora došlo je do greške.'));
  }

}
