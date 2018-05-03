import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { AlertService } from '../../services/alert.service';
import { UserService } from '../../services/user.service';

@Component({
    selector: 'app-registr',
    templateUrl: 'registration.component.html'
})

export class RegistrationComponent {
    model: any = {};
    loading = false;

    constructor(
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) { }

    register() {
        this.loading = true;
        this.userService.create(this.model)
            .subscribe(
                data => {
                    this.alertService.success('Поздравляем, Вы зарегестрированы!', true);
                    this.router.navigate(['login']);
                },
                error => {
                    this.alertService.error('Пользователь с таким email уже существует.');
                    this.loading = false;
                });
    }
}
