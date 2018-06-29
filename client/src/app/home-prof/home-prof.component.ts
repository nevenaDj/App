import { Component, OnInit } from '@angular/core';
import { AuthService } from '../login/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-prof',
  templateUrl: './home-prof.component.html',
  styleUrls: ['./home-prof.component.css']
})
export class HomeProfComponent implements OnInit {

  constructor(private auth: AuthService,
              private router: Router) { }

ngOnInit() {
}

logout(){
  this.auth.logout();
}

}
