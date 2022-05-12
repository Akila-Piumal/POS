package bo;

import dao.custom.*;
import dao.custom.impl.*;
import db.DBConnection;
import model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBOImpl {
    CustomerDAO customerDAO = new CustomerDAOImpl();
    ItemDAO itemDAO = new ItemDAOImpl();
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    QueryDAO queryDAO = new QueryDAOImpl();

    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        // Transaction

        Connection connection = DBConnection.getDbConnection().getConnection();
        // if order id already exist
        if (orderDAO.exist(orderId)) {

        }

        connection.setAutoCommit(false);

        if (!orderDAO.save(new OrderDTO(orderId, orderDate, customerId))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        for (OrderDetailDTO detail : orderDetails) {
            boolean save = orderDetailsDAO.save(detail);

            if (!save) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            //Search & Update Item
            ItemDTO item = itemDAO.search(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            if (!itemDAO.update(item)) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }

        connection.commit();
        connection.setAutoCommit(true);
        return true;

    }

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.search(code);
    }

    public boolean checkItemIsAvailable(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    public boolean checkCustomerIsAvailable(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    public String generateNewOrderID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewId();
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
}