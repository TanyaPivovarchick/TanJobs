package by.bsuir.dao.impl;


import by.bsuir.dao.DAO;
import by.bsuir.entity.AspirantAccount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class AspirantAccountDaoFake implements DAO<AspirantAccount> {

    private static ArrayList<AspirantAccount> entities;

    public AspirantAccountDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<AspirantAccount> getAll() throws Exception {
        return entities;
    }

    @Override
    public AspirantAccount getBy(Predicate<AspirantAccount> predicate) throws Exception {

        for (AspirantAccount entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(AspirantAccount entity) throws Exception {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws Exception {

        int i = -1, j = 0;
        for (AspirantAccount entity : entities) {

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
    public void create(AspirantAccount entity) throws Exception {
        entities.add(entity);
    }
}
