package by.bsuir.controller;

import by.bsuir.entity.JobVacancy;
import by.bsuir.entity.Response;
import by.bsuir.service.ResponseService;
import by.bsuir.service.VacancyService;
import by.bsuir.service.impl.ResponseServiceImpl;
import by.bsuir.service.impl.VacancyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api")
public class ResponseController {

    private final ResponseService responseService;
    private final VacancyService vacancyService;

    @Autowired
    public ResponseController(ResponseServiceImpl responseService, VacancyServiceImpl vacancyService) {
        this.responseService = responseService;
        this.vacancyService = vacancyService;
    }

    @GetMapping("all-responsies/{id}")
    public ResponseEntity<List<JobVacancy>> getAllResponseVacancy(@PathVariable Long id) {
        List<Response> list = responseService.getAllResponcies(id);
        List<JobVacancy> vacancies = new ArrayList<>();
        for (Response response: list) {
            vacancies.add(vacancyService.getVacancyById(response.getVacancyId()));
        }
        return new ResponseEntity<>(vacancies, HttpStatus.OK);
    }
}
