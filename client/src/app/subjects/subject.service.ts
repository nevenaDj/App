import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from '../model/subject';

@Injectable()
export class SubjectService {

  constructor(private http: HttpClient) { }

  addSubject(subject: Subject, id: number, idP: number): Promise<Subject>{
    const url = `/api/departman/${id}/professor/${idP}/subject`;
    return this.http
          .post(url, subject)
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  getAllSubjects(): Promise<Subject[]>{
    return this.http
          .get<Subject[]>("/api/subject")
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error("Error... ", error);
    return Promise.reject(error.message || error);
  }

}
