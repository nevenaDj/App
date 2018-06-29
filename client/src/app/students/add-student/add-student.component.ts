import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Student } from '../../model/student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import { ToastsManager } from 'ng2-toastr';
import { User } from '../../model/user';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  student: User;

  constructor(private studentService: StudentService,
              private router: Router,
              private toastr: ToastsManager, 
              private vcr: ViewContainerRef) {
    this.toastr.setRootViewContainerRef(vcr); 
    this.student = {
      id: null,
      firstName: '',
      lastName: '',
      username: '',
      roles: ['ROLE_STUDENT']
    }
   }

  ngOnInit() {
  }

  save(){
    this.studentService.addStudent(this.student)
      .then(res => this.router.navigate(['admin']))
      .catch(res => this.toastr.error('Prilikom upisa studenta došlo je do greške.'));
  }

}
