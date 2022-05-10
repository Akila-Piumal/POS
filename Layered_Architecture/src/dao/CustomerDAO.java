package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerDTO,String>{
    ArrayList<CustomerDTO> searchByName(String name) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> searchByAddress(String address) throws SQLException, ClassNotFoundException;
}
