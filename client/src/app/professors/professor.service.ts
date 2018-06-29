import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Professor } from '../model/professor';

@Injectable()
export class ProfessorService {

  constructor(private http: HttpClient) { }

  addProfessor(professor: Professor, id: number): Promise<Professor>{
    const url = `/api/departman/${id}/professor`;
    return this.http
          .post(url, professor)
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  getAllProfessors(): Promise<Professor[]>{
    return this.http
          .get<Professor[]>("/api/professor")
          .toPromise()
          .then(res => res)
          .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error("Error... ", error);
    return Promise.reject(error.message || error);
  }


}
