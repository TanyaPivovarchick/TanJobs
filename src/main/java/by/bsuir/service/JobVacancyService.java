package by.bsuir.service;

import by.bsuir.entity.*;
import by.bsuir.service.exception.*;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Represents a JobVacancyService responsible for working with a job vacancy.
 */
public interface JobVacancyService {

    /**
     * Returns all job vacancies.
     * @return job vacancies.
     * @throws ServiceException when an error occurred in service.
     */
    ArrayList<JobVacancy> getAllAspirantJobVacancy()
            throws ServiceException;

    /**
     * Add job vacancy.
     * @param jobVacancy job vacancy.
     * @throws IllegalArgumentException when jobVacancy is null.
     * @throws ServiceException when an error occurred in service.
     */
    void addJobVacancy(JobVacancy jobVacancy) throws IllegalArgumentException, ServiceException;

    /**
     * Returns job vacancy.
     * @param vacancyName job vacancy name.
     * @param companyName name of the company to which the vacancy refers.
     * @return job vacancy.
     * @throws IllegalArgumentException when vacancyName or careerObjective is null, empty or whitespace.
     * @throws ServiceException when an error occurred in service.
     */
    JobVacancy getJobVacancy(String vacancyName, String companyName) throws IllegalArgumentException, ServiceException;

    JobVacancy getJobVacancyById(int id) throws ServiceException;
}
