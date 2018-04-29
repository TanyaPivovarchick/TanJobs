package by.bsuir.dao.impl;


import by.bsuir.dao.DAO;
import by.bsuir.entity.ResumeView;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class AspirantResumeViewDaoFake implements DAO<ResumeView> {

    private static ArrayList<ResumeView> entities;

    public AspirantResumeViewDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<ResumeView> getAll() throws Exception {
        return entities;
    }

    @Override
    public ResumeView getBy(Predicate<ResumeView> predicate) throws Exception {

        for (ResumeView entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(ResumeView entity) throws Exception {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws Exception {

        int i = -1, j = 0;
        for (ResumeView entity : entities) {

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
    public void create(ResumeView entity) throws Exception {
        entities.add(entity);
    }

}
