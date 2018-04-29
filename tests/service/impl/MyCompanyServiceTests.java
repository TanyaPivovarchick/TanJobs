package service.impl;

import by.bsuir.dao.DAO;
import by.bsuir.dao.impl.*;
import by.bsuir.entity.*;
import by.bsuir.service.impl.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyCompanyServiceTests {

    private MyCompanyService companyService;

    @BeforeEach
    void setUp() {
        DAO<Company> companyDAO = new CompanyDaoFake();
        DAO<Invitation> invitationDAO = new InvitationDaoFake();
        companyService = new MyCompanyService(companyDAO, invitationDAO);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllCompanies_returnedAllCompanies() throws Exception {
        ArrayList<Company> result = this.companyService.getAllCompanies();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void addJobVacancy_jobVacancy_addedJobVacancy() throws Exception {
        Company company = new Company();
        company.setName("name");
        company.setId(10);

        this.companyService.addCompany(company);
        company = this.companyService.getCompanyById(10);
        assertTrue(company.getId() == 10);

        company = this.companyService.getCompanyByName("name");
        assertTrue(company.getName().equals("name"));
    }

}
