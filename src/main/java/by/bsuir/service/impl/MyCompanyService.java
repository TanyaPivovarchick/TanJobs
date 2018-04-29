package by.bsuir.service.impl;

import by.bsuir.dao.DAO;
import by.bsuir.entity.*;
import by.bsuir.service.*;
import by.bsuir.service.exception.*;
import by.bsuir.service.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CompanyService")
public class MyCompanyService implements CompanyService {

    private DAO<Company> companyDAO;
    private DAO<Invitation> invitationDAO;

    @Autowired
    public MyCompanyService(DAO<Company> companyDAO, DAO<Invitation> invitationDAO) {

        ArgumentVerificationService.verifyNull(companyDAO, "companyDAO");
        ArgumentVerificationService.verifyNull(invitationDAO, "invitationDAO");

        this.companyDAO = companyDAO;
        this.invitationDAO = invitationDAO;
    }

    @Override
    public ArrayList<Company> getAllCompanies() throws ServiceException {
        try {

            List<Company> companies = this.companyDAO.getAll();
            return new ArrayList<>(companies);

        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Company getCompanyById(int id) throws ServiceException {
        try {
            return this.companyDAO.getBy(company -> company.getId() == id);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Company getCompanyByName(String name) throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(name, "name");

        try {
            return this.companyDAO.getBy(company -> company.getName().equals(name));
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void addCompany(Company company) throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyNull(company, "company");

        try {
            this.companyDAO.create(company);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<Invitation> getAllInvitation(String companyName) throws IllegalArgumentException, ServiceException {

        ArgumentVerificationService.verifyString(companyName, "companyName");

        try {
            List<Invitation> invitations = this.invitationDAO.getAll();
            return new ArrayList<>(invitations);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
