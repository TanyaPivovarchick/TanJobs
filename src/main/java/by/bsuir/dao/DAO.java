package by.bsuir.dao;

import java.util.List;
import java.util.function.Predicate;

public interface DAO<T> {

    List<T> getAll() throws Exception;

    T getBy(Predicate<T> predicate) throws Exception;

    void update(T entity) throws Exception;

    void delete(int id) throws Exception;

    void create(T entity) throws Exception;

}
