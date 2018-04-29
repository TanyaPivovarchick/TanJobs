package by.bsuir.dao.impl;

import by.bsuir.dao.DAO;
import by.bsuir.entity.AspirantProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class AspirantProfileDaoFake implements DAO<AspirantProfile> {

    private static ArrayList<AspirantProfile> entities;

    public AspirantProfileDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<AspirantProfile> getAll() throws Exception {
        return entities;
    }

    @Override
    public AspirantProfile getBy(Predicate<AspirantProfile> predicate) throws Exception {

        for (AspirantProfile entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(AspirantProfile entity) throws Exception {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws Exception {

        int i = -1, j = 0;
        for (AspirantProfile entity : entities) {

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
    public void create(AspirantProfile entity) throws Exception {
        entities.add(entity);
    }

}
