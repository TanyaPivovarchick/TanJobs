package by.bsuir.dao.impl;

import by.bsuir.dao.DAO;
import by.bsuir.entity.JobVacancy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class JobVacancyDaoFake implements DAO<JobVacancy> {

    private static ArrayList<JobVacancy> entities;

    public JobVacancyDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<JobVacancy> getAll() throws Exception {
        return entities;
    }

    @Override
    public JobVacancy getBy(Predicate<JobVacancy> predicate) throws Exception {

        for (JobVacancy entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(JobVacancy entity) throws Exception {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws Exception {

        int i = -1, j = 0;
        for (JobVacancy entity : entities) {

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
    public void create(JobVacancy entity) throws Exception {
        entities.add(entity);
    }

}
