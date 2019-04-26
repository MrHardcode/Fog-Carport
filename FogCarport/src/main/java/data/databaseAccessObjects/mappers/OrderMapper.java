/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.databaseAccessObjects.mappers;

import data.databaseAccessObjects.DBConnector;
import data.exceptions.LoginException;
import data.models.OrderModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Camilla
 */

public class OrderMapper {
    private static OrderMapper orderMapper;
    
    private OrderMapper() {

    }

    public static OrderMapper getInstance() {
        if (orderMapper == null) {
            orderMapper = new OrderMapper();
        }
        return orderMapper;
    }
 
     // <editor-fold defaultstate="collapsed" desc="Get an Order">
    /**
     * Get an Order.
     *
     * @param id of the Order.
     * @return OrderModel
     * @throws LoginException Should probably be something else later on.
     */
    public OrderModel getOrder(int id) throws LoginException
    {
        OrderModel order = new OrderModel();

        String SQL = "SELECT * FROM `carportdb`.`orders`"
                + " WHERE `orders`.`id_order` = ?";
        
        // Using try-with resources, so they automatically close afterwards.
        try (Connection con = DBConnector.connection();
                PreparedStatement ps = con.prepareStatement(SQL);)
        {
            order.setId(id);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                String status = rs.getString("status");
                order.setStatus(status);
                
                int width = rs.getInt("order_width");
                order.setWidth(width);
                
                int length = rs.getInt("order_length");
                order.setLength(length);
                
                int incline = rs.getInt("incline");
                order.setIncline(incline);
                
                String adress = rs.getString("build_adress");
                order.setBuild_adress(adress);
                
                int zipcode = rs.getInt("build_zipcode");
                order.setBuild_zipcode(zipcode);
                
                int id_customer = rs.getInt("id_customer");
                order.setId_customer(id_customer);
                
                int id_employee = rs.getInt("id_employee");
                order.setId_employee(id_employee);

            }

        } catch (SQLException ex)
        {
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }

        return order;
    }
    // </editor-fold>

    
}