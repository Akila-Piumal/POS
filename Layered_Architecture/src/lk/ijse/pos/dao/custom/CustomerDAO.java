package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    ArrayList<Customer> searchByName(String name) throws SQLException, ClassNotFoundException;

    ArrayList<Customer> searchByAddress(String address) throws SQLException, ClassNotFoundException;
}
