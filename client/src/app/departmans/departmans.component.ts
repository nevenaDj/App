import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Departman } from '../model/departman';
import { DepartmanService } from './departman.service';
import { PagerService } from '../pager.service';
import { Router } from '@angular/router';
import { ToastsManager } from 'ng2-toastr';

@Component({
  selector: 'app-departmans',
  templateUrl: './departmans.component.html',
  styleUrls: ['./departmans.component.css']
})
export class DepartmansComponent implements OnInit {

  departmans: Departman[];
  departmanCount: number;

  pager: any = {};

  constructor(private departmanService: DepartmanService,
              private pagerService: PagerService,
              private router: Router,
              private toastr: ToastsManager, 
              private vcr: ViewContainerRef) {
    this.toastr.setRootViewContainerRef(vcr); 
   }

  ngOnInit() {
    this.departmanService.getDepartmansCount()
    .then(count => {
      this.departmanCount = count;
      this.setPage(1);
    });    
  }

  getDepartmans(page: number, size: number){
    this.departmanService.getDepartmans(page, size).then(
        res => this.departmans = res
    );
  }

  setPage(page: number){
    if (page < 1 || page > this.pager.totalPages){
      return;
    }

    this.pager = this.pagerService.getPager(this.departmanCount, page, 5);
    this.getDepartmans(this.pager.currentPage - 1, this.pager.pageSize);
  }

}
