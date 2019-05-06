/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.databaseAccessObjects.mappers;

import data.databaseAccessObjects.DBConnector;
import data.exceptions.LoginException;
import data.models.CustomerModel;
import data.models.EmployeeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Camilla
 */

public class UserMapper {
    private static UserMapper userMapper;
    
    private UserMapper() {

    }

    public static UserMapper getInstance() {
        if (userMapper == null) {
            userMapper = new UserMapper();
        }
        return userMapper;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Get a customer">
    /**
     * Get an Order.
     *
     * @param id of the Order.
     * @return OrderModel
     * @throws LoginException Should probably be something else later on.
     */
    public CustomerModel getCustomer(int id) throws LoginException {
        CustomerModel customer = new CustomerModel();

        String SQL = "SELECT * FROM carportdb.customers WHERE id_customer = ?;";

        try {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            customer.setId(id);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                customer.setName(rs.getString("customer_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getInt("phone"));
            }

        } catch (SQLException ex) {
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }

        return customer;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Get an employee">
    /**
     * Get an Order.
     *
     * @param id of the Order.
     * @return OrderModel
     * @throws LoginException Should probably be something else later on.
     */
    public EmployeeModel getEmployee(int id) throws LoginException {
        EmployeeModel employee = new EmployeeModel();

        String SQL = "SELECT `employees`.`emp_name`, `roles`.`role` "
                + "FROM `carportdb`.`employees` "
                + "INNER JOIN `carportdb`.`roles` "
                + "ON `employees`.`id_role` = `roles`.`id_role` "
                + "WHERE `employees`.`id_employee` = ?;";

        try {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            employee.setId(id);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employee.setName(rs.getString("emp_name"));
                employee.setRole(rs.getString("role"));
            }

        } catch (SQLException ex) {
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }

        return employee;
    }
    // </editor-fold>
    
}