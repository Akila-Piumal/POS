package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.entity.Orders;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<Orders,String> {
    ArrayList<Orders> searchByDate(LocalDate date) throws SQLException, ClassNotFoundException;
}