package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.SQLUtil;
import lk.ijse.pos.dao.custom.QueryDAO;
import lk.ijse.pos.entity.CustomEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomEntity> searchOrderByOrderID(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.executeQuery("select orders.oid,orders.date,orders.customerID,orderdetails.itemcode,orderdetails.qty,orderdetails.unitprice from orders inner join orderdetails on orders.oid=orderdetails.oid where orders.oid= ?",id);
        ArrayList<CustomEntity> orderRecords=new ArrayList();
        while (resultSet.next()) {
            orderRecords.add(new CustomEntity(resultSet.getString(1), LocalDate.parse(resultSet.getString(2)),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getBigDecimal(6)));
        }
        return orderRecords;
    }
}
