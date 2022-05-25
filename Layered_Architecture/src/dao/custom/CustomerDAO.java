package dao.custom;

import dao.CrudDAO;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    ArrayList<Customer> searchByName(String name) throws SQLException, ClassNotFoundException;

    ArrayList<Customer> searchByAddress(String address) throws SQLException, ClassNotFoundException;
}
