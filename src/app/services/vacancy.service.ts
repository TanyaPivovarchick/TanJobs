import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { Vacancy } from '../models/vacancy';

@Injectable()
export class VacancyService {
	
    //URLs for CRUD operations
    allVacanciesUrl = "http://localhost:8082/api/all-vacancies";
	vacancyUrl = "http://localhost:8082/api/vacancy";
	
	//Create constructor to get Http instance
	constructor(private http:Http) { 
	}
	
	//Fetch all vacancies
    getAllVacancies(): Observable<Vacancy[]> {
        return this.http.get(this.allVacanciesUrl)
		   		.map(this.extractData)
		        .catch(this.handleError);

    }
	
	//Create vacancy
    createVacancy(vacancy: Vacancy):Observable<number> {
	    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.post(this.vacancyUrl, vacancy, options)
               .map(success => success.status)
               .catch(this.handleError);
    }
	
	//Fetch vacancy by id
    getVacancyById(vacancyId: string): Observable<Vacancy> {
		let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
		let cpParams = new URLSearchParams();
		cpParams.set('id', vacancyId);			
		let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
		return this.http.get(this.vacancyUrl, options)
			   .map(this.extractData)
			   .catch(this.handleError);
    }	
	
	//Update vacancy
    updateVacancy(vacancy: Vacancy):Observable<number> {
	    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: cpHeaders });
        return this.http.put(this.vacancyUrl, vacancy, options)
               .map(success => success.status)
               .catch(this.handleError);
    }
	
    //Delete vacancy	
    deleteVacancyById(vacancyId: string): Observable<number> {
		let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
		let cpParams = new URLSearchParams();
		cpParams.set('id', vacancyId);			
		let options = new RequestOptions({ headers: cpHeaders, params: cpParams });
		return this.http.delete(this.vacancyUrl, options)
			   .map(success => success.status)
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