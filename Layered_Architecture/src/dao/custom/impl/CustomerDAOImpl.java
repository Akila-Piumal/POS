package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.CustomerDAO;
import model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        while (rst.next()) {
            String id = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            allCustomers.add(new CustomerDTO(id, name, address));
        }
        return allCustomers;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO Customer VALUES (?,?,?)", dto.getId(), dto.getName(), dto.getAddress());
    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Customer SET name=?, address=? WHERE id=?", customerDTO.getName(), customerDTO.getAddress(), customerDTO.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.executeQuery("SELECT id FROM Customer WHERE id=?", id);
        return resultSet.next();
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");

        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer WHERE id=?", id);
        if (rst.next()){
            return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> searchByName(String name) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer WHERE name=?", name);
        ArrayList<CustomerDTO> customerList=new ArrayList<>();
        while (rst.next()){
            customerList.add(new CustomerDTO(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return customerList;
    }

    @Override
    public ArrayList<CustomerDTO> searchByAddress(String address) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.executeQuery("SELECT * FROM Customer WHERE address=?", address);
        ArrayList<CustomerDTO> customerList=new ArrayList<>();
        if (resultSet.next()){
            customerList.add(new CustomerDTO(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
        }
        return customerList;
    }
}
