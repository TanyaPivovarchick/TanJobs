import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from '../../services/authentication.service';

import { User } from '../../models/user';

@Component({
  selector   : 'header',
  templateUrl: './header.component.html'
})

export class HeaderComponent {

  user: User;
  email = '';

  constructor(
    private authService: AuthenticationService, 
    private router: Router
  ) { }

  isAuth() : boolean {
	if (this.authService.isLoggedIn()) {
      this.user = JSON.parse(window.localStorage.getItem('user'));
      this.email = this.user.email;
    }
	return this.authService.isLoggedIn();
  }
}