package dao.custom;

import dao.CrudDAO;
import dto.OrderDTO;
import entity.Orders;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<Orders,String> {
    ArrayList<Orders> searchByDate(LocalDate date) throws SQLException, ClassNotFoundException;
}
