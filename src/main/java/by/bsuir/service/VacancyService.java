package by.bsuir.service;

import by.bsuir.entity.JobVacancy;

import java.util.List;

public interface VacancyService {

    List<JobVacancy> getAllVacancies();
    JobVacancy getVacancyById(Long id);
}
