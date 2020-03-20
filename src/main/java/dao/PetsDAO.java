package dao;

import entity.Address;
import entity.Pets;

import java.sql.SQLException;
import java.util.List;

public interface PetsDAO {

    void add(Pets pets) throws SQLException;

    List<Pets> getAll() throws SQLException;

    Pets getById(Long id) throws SQLException;

    void update(Pets pets) throws SQLException;

    void delete(Pets pets) throws SQLException;

}
