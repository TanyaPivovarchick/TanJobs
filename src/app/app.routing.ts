import { Routes, RouterModule } from '@angular/router';

import { StartPageComponent } from './components/start-page/start-page.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { VacanciesComponent } from './components/vacancies/vacancies.component';

const appRoutes: Routes = [
	{ path: '', component: StartPageComponent },
    	{ path: 'login', component: LoginComponent },
	{ path: 'registration', component: RegistrationComponent },
	{ path: 'vacancies', component: VacanciesComponent },
	{ path: '**', redirectTo: '' }
];

export const Routing = RouterModule.forRoot(appRoutes);