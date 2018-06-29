import { Injectable } from '@angular/core';

import { Exam } from '../model/exam';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ExamService {

  constructor(private http: HttpClient) { }

  addExam(exam: Exam, id: number, idS: number): Promise<{}>{
    const url = `/api/subject/${id}/student/${idS}/exam`;
    return this.http
          .post(url, exam)
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error("Error... ", error);
    return Promise.reject(error.message || error);
  }

}
