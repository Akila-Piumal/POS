package dao;

import java.sql.SQLException;

public interface placeOrderDAO {
    String generateNewId() throws SQLException, ClassNotFoundException;
}
