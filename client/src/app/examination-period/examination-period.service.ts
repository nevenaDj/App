import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ExaminationPeriod } from '../model/examination-period';

@Injectable()
export class ExaminationPeriodService {

  constructor(private http: HttpClient) { }

  addExaminationPeriod(ePeriod: ExaminationPeriod, id: number): Promise<{}>{
    const url = `/api/subject/${id}/examinationPeriod`;
    return this.http
          .post(url, ePeriod)
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  getAllDepartmans(): Promise<ExaminationPeriod[]>{
    return this.http
          .get<ExaminationPeriod[]>("/api/examinationPeriod")
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error("Error... ", error);
    return Promise.reject(error.message || error);
  }

}
