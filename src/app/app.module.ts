import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent }  from './app.component';
import { Routing }        from './app.routing';

import { StartPageComponent } from './components/start-page/start-page.component';
import { HeaderComponent } from './components/header/header.component';
import { LoginComponent } from './components/login/login.component';
import { AlertComponent } from './components/alert/alert.component';

import { AlertService } from './services/alert.service';
import { AuthenticationService } from './services/authentication.service';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
HttpModule,
		HttpClientModule,
        Routing
    ],
    declarations: [
        AppComponent,
		StartPageComponent,
		HeaderComponent,
		LoginComponent,
		AlertComponent
    ],
    providers: [
        AlertService,
        AuthenticationService,
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }