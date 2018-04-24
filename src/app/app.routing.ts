import { Routes, RouterModule } from '@angular/router';

import { StartPageComponent } from './components/start-page/start-page.component';
import { LoginComponent } from './components/login/login.component';

const appRoutes: Routes = [
	{ path: '', component: StartPageComponent },
    { path: 'login', component: LoginComponent },
	{ path: '**', redirectTo: '' }
];

export const Routing = RouterModule.forRoot(appRoutes);