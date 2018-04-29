package by.bsuir.dao.impl;


import by.bsuir.dao.DAO;
import by.bsuir.entity.Resume;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class AspirantResumeDaoFake implements DAO<Resume> {

    private static ArrayList<Resume> entities;

    public AspirantResumeDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<Resume> getAll() throws Exception {
        return entities;
    }

    @Override
    public Resume getBy(Predicate<Resume> predicate) throws Exception {

        for (Resume entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(Resume entity) throws Exception {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws Exception {

        int i = -1, j = 0;
        for (Resume entity : entities) {

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
    public void create(Resume entity) throws Exception {
        entities.add(entity);
    }

}
