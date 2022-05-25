package dao.custom;

import dao.CrudDAO;
import dto.ItemDTO;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item,String> {
    ArrayList<Item> searchByPriceRange(double min, double max) throws SQLException, ClassNotFoundException;
}
