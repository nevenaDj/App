import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Departman } from '../../model/departman';
import { DepartmanService } from '../departman.service';
import { Router } from '@angular/router';
import { ToastsManager } from 'ng2-toastr';

@Component({
  selector: 'app-add-departman',
  templateUrl: './add-departman.component.html',
  styleUrls: ['./add-departman.component.css']
})
export class AddDepartmanComponent implements OnInit {

  departman: Departman;

  constructor(private departmanService: DepartmanService,
              private router: Router,
              private toastr: ToastsManager, 
              private vcr: ViewContainerRef) {
    this.toastr.setRootViewContainerRef(vcr); 
    this.departman = {
      id: null,
      name: ''
    }
   }

  ngOnInit() {
  }

  save(){
    this.departmanService.addDepartman(this.departman)
      .then(res => this.router.navigate(['admin']))
      .catch(res => this.toastr.error('Prilikom upisa departmana došlo je do greške.'));
  }
  

}
