package service.impl;

import by.bsuir.dao.DAO;
import by.bsuir.dao.impl.*;
import by.bsuir.entity.*;
import by.bsuir.service.*;
import by.bsuir.service.impl.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MyJobVacancyServiceTests {

    private JobVacancyService jobVacancyService;

    @BeforeEach
    void setUp() {
        DAO<Company> companyDAO = new CompanyDaoFake();
        DAO<JobVacancy> jobVacancyDAO = new JobVacancyDaoFake();
        jobVacancyService = new MyJobVacancyService(jobVacancyDAO, companyDAO);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllAspirantJobVacancy_returnedAllAspirantJobVacancy() throws Exception {
        ArrayList<JobVacancy> result = this.jobVacancyService.getAllAspirantJobVacancy();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

}
