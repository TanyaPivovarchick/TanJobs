import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { VacancyService } from '../../services/vacancy.service';
import { Vacancy} from '../../models/vacancy';

@Component({
   selector: 'app-vacancies',
   templateUrl: './vacancies.component.html'
})
export class VacanciesComponent implements OnInit { 

   allVacancies: Vacancy[];
   
   constructor(private vacancyService: VacancyService) {
   }
   
   ngOnInit(): void {
	   this.getAllVacancies();
   }   
   
   getAllVacancies() {
        this.vacancyService.getAllVacancies()
		  .subscribe(
                data => this.allVacancies = data,
                errorCode =>  this.statusCode = errorCode);   
   }
   
   leaveResponce(vacancyId: string) {   
   }
}
    