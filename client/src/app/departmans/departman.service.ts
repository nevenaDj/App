import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Departman } from '../model/departman';


@Injectable()
export class DepartmanService {

  constructor(private http: HttpClient) { }

  addDepartman(departman: Departman): Promise<Departman>{
    const url = '/api/departman';
    return this.http
          .post(url, departman)
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  getAllDepartmans(): Promise<Departman[]>{
    return this.http
          .get<Departman[]>("/api/departman")
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  getDepartmansCount(): Promise<number>{
    const url = '/api/departmans/count';
    return this.http
          .get(url)
          .toPromise()
          .then(res => {return res})
          .catch(this.handleError);
  }

  getDepartmans(page: number, size: number = 5): Promise<Departman[]>{
    const httpParams = new HttpParams().set('page', page.toString()).set('size', size.toString());
    return this.http
          .get<Departman[]>("/api/departmans", { params: httpParams})
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error("Error... ", error);
    return Promise.reject(error.message || error);
  }

}
