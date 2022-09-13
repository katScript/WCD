package database.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DaoInterface<T> {
    Optional<T> get(long id) throws SQLException;
    List<T> getAll() throws SQLException;
    void save(T t);
    void delete(T t);
}
