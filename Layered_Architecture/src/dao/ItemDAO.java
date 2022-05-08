package dao;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<ItemDTO> searchByPriceRange(double min, double max) throws SQLException, ClassNotFoundException;
}
