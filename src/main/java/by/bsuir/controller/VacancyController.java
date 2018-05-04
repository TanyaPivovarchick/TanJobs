package by.bsuir.controller;

import by.bsuir.entity.JobVacancy;
import by.bsuir.service.VacancyService;
import by.bsuir.service.impl.VacancyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api")
public class VacancyController {

    private final VacancyService vacancyService;

    @Autowired
    public VacancyController(VacancyServiceImpl vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping("all-vacancies")
    public ResponseEntity<List<JobVacancy>> getAllVacancies() {
        List<JobVacancy> list = vacancyService.getAllVacancies();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
