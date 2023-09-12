package repository;

import java.util.List;

public interface Repository<T> {

    T findOne(int id);
    List<T> findAll();
    T create(T object);
    T update(T object);
}
