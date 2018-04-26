import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import 'rxjs/Rx';
import {Observable} from 'rxjs/Observable';

import { User } from '../models/user';

@Injectable()
export class AuthenticationService {
	
	constructor(private http: HttpClient) { }

    login(user: User) {
        return this.http.post<any>('/api/login', user)
            .map(currentUser => {
                // login successful if there's a jwt token in the response
                if (currentUser && currentUser.token) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('user', JSON.stringify(currentUser));
                }

                return currentUser;
            });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('user');
    }
}