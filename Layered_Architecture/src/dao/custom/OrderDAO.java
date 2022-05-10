package dao.custom;

import dao.CrudDAO;
import model.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<OrderDTO,String> {
    ArrayList<OrderDTO> searchByDate(LocalDate date) throws SQLException, ClassNotFoundException;
}
