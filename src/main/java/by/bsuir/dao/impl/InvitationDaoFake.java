package by.bsuir.dao.impl;

import by.bsuir.dao.DAO;
import by.bsuir.entity.Invitation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class InvitationDaoFake implements DAO<Invitation> {

    private static ArrayList<Invitation> entities;

    public InvitationDaoFake() {
        entities = new ArrayList<>();
    }

    @Override
    public List<Invitation> getAll() throws Exception {
        return entities;
    }

    @Override
    public Invitation getBy(Predicate<Invitation> predicate) throws Exception {

        for (Invitation entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }

        return null;
    }

    @Override
    public void update(Invitation entity) throws Exception {
        entities.remove(entity);
        entities.add(entity);
    }

    @Override
    public void delete(int id) throws Exception {

        int i = -1, j = 0;
        for (Invitation entity : entities) {

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
    public void create(Invitation entity) throws Exception {
        entities.add(entity);
    }

}
