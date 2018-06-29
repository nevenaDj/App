import { Component, OnInit } from '@angular/core';
import { Subject } from '../../model/subject';
import { User } from '../../model/user';
import { SubjectService } from '../../subjects/subject.service';
import { StudentService } from '../../students/student.service';
import { Exam } from '../../model/exam';
import { ExamService } from '../exam.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-exam',
  templateUrl: './add-exam.component.html',
  styleUrls: ['./add-exam.component.css']
})
export class AddExamComponent implements OnInit {

  subjects: Subject[];
  students: User[];
  student: User;
  subject: Subject;
  exam: Exam;


  constructor(private subjectService: SubjectService,
              private studentService: StudentService,
              private examService: ExamService,
              private router: Router) { 
    this.exam = {
      id: null,
      user: null,
      rating: null,
      subject: null
    }
    this.subjectService.getAllSubjects()
        .then(res => {
          this.subjects = res;
          this.studentService.getStudents()
              .then(std => this.students = std);
        });
  }

  ngOnInit() {
    if(window.location.href.indexOf("loaded") > -1) {}
    else{
      let win = (window as any);
      win.location.href = "/#/prof/exam/add/loaded";
      win.location.reload();
    }
  }

  save(){
    this.examService.addExam(this.exam, this.subject.id, this.student.id)
        .then(res => this.router.navigate(['prof']));
  }

}
