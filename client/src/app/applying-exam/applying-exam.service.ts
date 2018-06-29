import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApplyingExam } from '../model/applying-exam';

@Injectable()
export class ApplyingExamService {

  constructor(private http: HttpClient) { }

  addApplyingExam(applyingExam: ApplyingExam,id: number): Promise<{}>{
    const url = `/api/examinationPeriod/${id}/applyingExam`;
    return this.http
          .post(url, applyingExam)
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error("Error... ", error);
    return Promise.reject(error.message || error);
  }

}
