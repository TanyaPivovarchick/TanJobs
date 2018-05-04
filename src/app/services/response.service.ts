import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { UserResponse } from '../models/response';
import { Vacancy} from '../models/vacancy';

@Injectable()
export class ResponseService {
	
    allResponsiesUrl = "http://localhost:8082/api/all-responsies";
	responseUrl = "http://localhost:8082/api/response";
	
	constructor(private http:Http) { 
	}
	
	getAllResponseVacancies(userId: string): Observable<Vacancy[]> {
            return this.http.get(`http://localhost:8082/api/all-responsies/${userId}`)
		.map(this.extractData)
		.catch(this.handleError);
    }
	
	private extractData(res: Response) {
	    let body = res.json();
        return body;
    }
	
    private handleError (error: Response | any) {
		console.error(error.message || error);
		return Observable.throw(error.status);
    }
}