import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import 'rxjs/Rx';
import {Observable} from 'rxjs/Observable';

import { User } from '../models/user';

@Injectable()
export class AuthenticationService {
	
	constructor(public http: Http) {}
	
	private isAuthenticated = false;

	login() {
		this.isAuthenticated = true;
	}

	logout() {
		this.isAuthenticated = false;
		window.localStorage.clear();
	}

	isLoggedIn(): boolean {
		return this.isAuthenticated;
	}

	checkUser(email: string, password: string): Promise<any> {
		const data =  {email: email, password: password};
		return this.http.post('http://localhost:8082/api/login/', data).toPromise();
	}
}
