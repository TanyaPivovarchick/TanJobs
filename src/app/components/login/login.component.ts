import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import { AlertService } from '../../services/alert.service';
import { AuthenticationService } from '../../services/authentication.service';

import { User } from '../../models/user';

@Component({
    selector: 'app-login',
    templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
	
    model: User;
    loading = false;

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService) { }

    ngOnInit() {
        this.model = new User();
    }

    login() {
        this.loading = true;
				
		this.authenticationService.checkUser(this.model.email, this.model.password)
			.then( (data: User) => {
				const user: User = JSON.parse(data['_body']);
				this.authenticationService.logout();
				this.authenticationService.login();
				window.localStorage.setItem('user', JSON.stringify(user));
				this.router.navigate(['/']);
			})
			.catch(error => {
				this.alertService.error('Неправильный email или пароль.');
				this.loading = false;
			});
    }
}
