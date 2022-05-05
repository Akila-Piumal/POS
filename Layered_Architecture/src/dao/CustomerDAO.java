package dao;

import model.CustomerDTO;

import java.sql.SQLException;

public interface CustomerDAO {
    CustomerDTO searchByName(String name) throws SQLException, ClassNotFoundException;
}
