import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { UserService } from '../users/user.service';
import { Router } from '@angular/router';
import { ToastsManager } from 'ng2-toastr';
import { Location } from '@angular/common';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  user: UserPassInterface;

  constructor(private userService: UserService,
              private location: Location,
              private router: Router,
              private toastr: ToastsManager, 
              private vcr: ViewContainerRef) {
    this.toastr.setRootViewContainerRef(vcr);
    this.user = {
      currentPassword: '',
      newPassword: '',
      checkPassword: ''
    }
   }

  ngOnInit() {
   // if (localStorage.getItem('token') == null){
   //   this.router.navigate(['login']);
   // }
  }

  save(model: UserPassInterface, isValid: boolean){
    console.log(this.user);
    console.log(model);
    if (isValid){
      this.userService.changePassword(this.user)
        .then(res => this.location.back())
        .catch(res => this.toastr.error('Greška prilikom promene lozinke. Molimo pokušajte ponovo.'));
    }
  }

  cancel(){
    this.location.back();
  }


}
