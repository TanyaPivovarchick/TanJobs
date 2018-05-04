import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { ResponseService } from '../../services/response.service';
import { AuthenticationService } from '../../services/authentication.service';
import { UserResponse } from '../../models/response';
import { Vacancy } from '../../models/vacancy';

@Component({
   selector: 'app-response',
   templateUrl: './response.component.html'
})
export class ResponseComponent implements OnInit { 

   allVacancies: Vacancy[];
   
   constructor(
	private responseService: ResponseService, 
	private authService: AuthenticationService) {
   }
   
   ngOnInit(): void {
	   this.getAllResponseVacancies();
   }   
   
   getAllResponseVacancies() {
        this.responseService.getAllResponseVacancies(this.authService.getId())
			.subscribe(data => this.allVacancies = data);   
   }
   
   deleteResponce(responseId: string) {   
   }
}
    