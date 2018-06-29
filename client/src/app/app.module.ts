import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms'
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ToastModule, ToastOptions} from 'ng2-toastr/ng2-toastr';
import { DropdownModule } from 'ngx-dropdown';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { AppRoutingModule } from './app-routing.module';

import { ExamService } from './exams/exam.service';
import { ApplyingExamService } from './applying-exam/applying-exam.service';
import { PagerService } from './pager.service';
import { ExaminationPeriodService } from './examination-period/examination-period.service';
import { SubjectService } from './subjects/subject.service';
import { ProfessorService } from './professors/professor.service';
import { DepartmanService } from './departmans/departman.service';
import { UserService } from './users/user.service';
import { StudentService } from './students/student.service';
import { AuthService } from './login/auth.service';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TokenInterceptorService } from './token-interceptor.service';
import { HomeStudentComponent } from './home-student/home-student.component';
import { HomeAdminComponent } from './home-admin/home-admin.component';
import { HomeProfComponent } from './home-prof/home-prof.component';
import { StudentsComponent } from './students/students.component';
import { AddStudentComponent } from './students/add-student/add-student.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { UsersComponent } from './users/users.component';
import { DepartmansComponent } from './departmans/departmans.component';
import { AddDepartmanComponent } from './departmans/add-departman/add-departman.component';
import { ProfessorsComponent } from './professors/professors.component';
import { AddProfessorComponent } from './professors/add-professor/add-professor.component';
import { SubjectsComponent } from './subjects/subjects.component';
import { AddSubjectComponent } from './subjects/add-subject/add-subject.component';
import { ExaminationPeriodComponent } from './examination-period/examination-period.component';
import { AddEperiodComponent } from './examination-period/add-eperiod/add-eperiod.component';
import { ApplyingExamComponent } from './applying-exam/applying-exam.component';
import { AddApplyingExamComponent } from './applying-exam/add-applying-exam/add-applying-exam.component';
import { RemoveApplyingExamComponent } from './applying-exam/remove-applying-exam/remove-applying-exam.component';
import { ExamsComponent } from './exams/exams.component';
import { AddExamComponent } from './exams/add-exam/add-exam.component';

export class CustomOption extends ToastOptions {
  animate = 'flyRight'; // you can override any options available
  newestOnTop = false;
  showCloseButton = true;
}


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeStudentComponent,
    HomeAdminComponent,
    HomeProfComponent,
    StudentsComponent,
    AddStudentComponent,
    ChangePasswordComponent,
    UsersComponent,
    DepartmansComponent,
    AddDepartmanComponent,
    ProfessorsComponent,
    AddProfessorComponent,
    SubjectsComponent,
    AddSubjectComponent,
    ExaminationPeriodComponent,
    AddEperiodComponent,
    ApplyingExamComponent,
    AddApplyingExamComponent,
    RemoveApplyingExamComponent,
    ExamsComponent,
    AddExamComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    DropdownModule,
    Ng2OrderModule,
    ToastModule.forRoot(),
  ],
  providers: [
    AuthService,
    StudentService,
    UserService,
    DepartmanService,
    ProfessorService,
    SubjectService,
    ExaminationPeriodService,
    PagerService,
    ApplyingExamService,
    ExamService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
