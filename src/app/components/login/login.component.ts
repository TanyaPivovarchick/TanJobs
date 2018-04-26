import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

import { AlertService } from '../../services/alert.service';
import { AuthenticationService } from '../../services/authentication.service';

import {User} from '../../models/user';

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
        this.authenticationService.login(this.model)
            .subscribe(
                data => {
                    this.router.navigate(['/']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
