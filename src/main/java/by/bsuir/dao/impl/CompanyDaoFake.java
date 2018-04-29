package by.bsuir.dao.impl;


import by.bsuir.dao.DAO;
import by.bsuir.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class CompanyDaoFake implements DAO<Company> {

    private static ArrayList<Company> entities;

    public CompanyDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<Company> getAll() throws Exception {
        return entities;
    }

    @Override
    public Company getBy(Predicate<Company> predicate) throws Exception {

        for (Company entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(Company entity) throws Exception {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws Exception {

        int i = -1, j = 0;
        for (Company entity : entities) {

            if (entity.getId() == id) {
                i = j;
            }

            j++;
        }

        if (i != -1) {
            entities.remove(i);
        }

    }

    @Override
    public void create(Company entity) throws Exception {
        entities.add(entity);
    }

}
