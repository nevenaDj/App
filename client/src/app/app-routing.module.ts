import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeAdminComponent } from './home-admin/home-admin.component';
import { HomeStudentComponent } from './home-student/home-student.component';
import { HomeProfComponent } from './home-prof/home-prof.component';
import { AddStudentComponent } from './students/add-student/add-student.component';
import { StudentsComponent } from './students/students.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { AddDepartmanComponent } from './departmans/add-departman/add-departman.component';
import { DepartmansComponent } from './departmans/departmans.component';
import { ProfessorsComponent } from './professors/professors.component';
import { AddProfessorComponent } from './professors/add-professor/add-professor.component';
import { AddSubjectComponent } from './subjects/add-subject/add-subject.component';
import { SubjectsComponent } from './subjects/subjects.component';
import { AddEperiodComponent } from './examination-period/add-eperiod/add-eperiod.component';
import { ExaminationPeriodComponent } from './examination-period/examination-period.component';
import { ApplyingExamComponent } from './applying-exam/applying-exam.component';
import { AddApplyingExamComponent } from './applying-exam/add-applying-exam/add-applying-exam.component';
import { RemoveApplyingExamComponent } from './applying-exam/remove-applying-exam/remove-applying-exam.component';
import { AddExamComponent } from './exams/add-exam/add-exam.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'admin',
    component: HomeAdminComponent,
    children: [
      {
        path: 'password',
        component: ChangePasswordComponent
      },
      {
        path: 'students/add',
        component: AddStudentComponent
      },
      {
        path: 'students',
        component: StudentsComponent
      },
      {
        path: 'departmans/add',
        component: AddDepartmanComponent
      },
      {
        path: 'departmans',
        component: DepartmansComponent
      },
      {
        path: 'professors/add/loaded',
        component: AddProfessorComponent
      },
      {
        path: 'professors/add',
        component: AddProfessorComponent
      },
      {
        path: 'professors',
        component: ProfessorsComponent
      },
      {
        path: 'subjects/add/loaded',
        component: AddSubjectComponent
      },
      {
        path: 'subjects/add',
        component: AddSubjectComponent
      },
      {
        path: 'subjects',
        component: SubjectsComponent
      },
      {
        path: 'examinationPeriod/add',
        component: AddEperiodComponent
      },
      {
        path: 'examinationPeriod/add/loaded',
        component: AddEperiodComponent
      },
      {
        path: 'examinationPeriod',
        component: ExaminationPeriodComponent
      }
    ]
  },
  {
    path: 'student',
    component: HomeStudentComponent,
    children: [
      {
        path: 'password',
        component: ChangePasswordComponent
      },
      {
        path: 'applying-exam/add',
        component: AddApplyingExamComponent
      },
      {
        path: 'applying-exam/remove',
        component: RemoveApplyingExamComponent
      },
     
    ]
  },
  {
    path: 'prof',
    component: HomeProfComponent,
    children: [
      {
        path: 'password',
        component: ChangePasswordComponent
      },
      {
        path: 'exam/add',
        component: AddExamComponent
      },
      {
        path: 'exam/add/loaded',
        component: AddExamComponent
      }

    ]
  },
  { path: '**', redirectTo: 'login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
