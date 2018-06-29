import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Student } from '../model/student';
import { User } from '../model/user';

@Injectable()
export class StudentService {

  constructor(private http: HttpClient) { }

  addStudent(student: User): Promise<User>{
    const url = '/api/student';
    return this.http
          .post(url, student)
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  getStudents(): Promise<User[]>{
    const url = '/api/student';
    return this.http
          .get(url)
          .toPromise()
          .then(res => res)
          .catch(this.handleError);

  }

  private handleError(error: any): Promise<any> {
    console.error("Error... ", error);
    return Promise.reject(error.message || error);
  }

}
