package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.OrderDetailsDAO;
import dto.OrderDetailDTO;
import entity.Orderdetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public ArrayList<Orderdetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Orderdetails entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",entity.getOid(),entity.getItemCode(),entity.getUnitPrice(),entity.getQty());
    }

    @Override
    public boolean update(Orderdetails entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Orderdetails search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
