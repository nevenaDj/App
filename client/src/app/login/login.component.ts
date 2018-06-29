import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Router } from '@angular/router';
import { ToastsManager } from 'ng2-toastr/ng2-toastr';

import { AuthService } from './auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: CredentialsInterface;

  constructor(private auth: AuthService,
    private router: Router,
    private toastr: ToastsManager, 
    private vcr: ViewContainerRef) {
      this.toastr.setRootViewContainerRef(vcr);
      this.user = {
        username: '',
        password: ''
      }
  }


  ngOnInit() {
  }

  login(){
    localStorage.removeItem('token');
    this.auth.login(this.user.username, this.user.password)
        .then(res => this.auth.me().then(me => 
          {
            if (me.roles.includes('ROLE_ADMIN')){
              this.router.navigate(['/admin']);
              console.log("admin");

            }
            else if (me.roles.includes('ROLE_USER')){
              this.router.navigate(['/prof']);
            }
            else if (me.roles.includes('ROLE_STUDENT')){
              this.router.navigate(['/student']);
            }
          })
         )
        .catch(res => this.toastr.error('Neispravno korisničko ime ili lozinka.'));
  }

}
