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
public class OrderMapper
{

    private static OrderMapper orderMapper;

    private OrderMapper()
    {

    }

    public static OrderMapper getInstance()
    {
        if (orderMapper == null)
        {
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
            order.setId(id); // id_order

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                order.setStatus(rs.getString("status"));
                order.setWidth(rs.getInt("width"));
                order.setLength(rs.getInt("length"));
                order.setIncline(rs.getInt("incline"));
                order.setRoof_tiles_id(rs.getInt("roof_tiles_id"));
                order.setBuild_adress(rs.getString("build_adress"));
                order.setBuild_zipcode(rs.getInt("build_zipcode"));
                order.setId_customer(rs.getInt("customer_id"));
                order.setId_employee(rs.getInt("employee_id"));
                order.setShed_floor_id(rs.getInt("shed_floor_id"));
                order.setShed_walls_id(rs.getInt("shed_walls_id"));
                order.setShed_length(rs.getInt("shed_length"));
                order.setShed_width(rs.getInt("shed_width"));
            }

        } catch (SQLException ex)
        {
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }

        return order;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Create an Order">
    public void createOrder(OrderModel order) throws LoginException
    {
        // SQL STATEMENT
        String SQL = "INSERT INTO `carportdb`.`orders` "
                + " (`status`, `order_width`, `order_length`, `incline`, `build_adress`, `build_zipcode`, `id_customer`, `id_employee`)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Using try-with resources, so they automatically close afterwards.
        try (Connection con = DBConnector.connection();
                PreparedStatement ps = con.prepareStatement(SQL);)
        {
            ps.setString(1, order.getStatus());
            ps.setInt(2, order.getWidth());
            ps.setInt(3, order.getLength());
            ps.setInt(4, order.getIncline());
            ps.setString(5, order.getBuild_adress());
            ps.setInt(6, order.getBuild_zipcode());
            ps.setInt(7, order.getId_customer());
            ps.setInt(8, order.getId_employee());
            ps.executeUpdate();
            ResultSet id = ps.getGeneratedKeys(); // Getting the auto-generated order_id.
            id.next();
            int order_id = id.getInt(1);
            order.setId(order_id);
        } catch (SQLException ex)
        {
            throw new LoginException(ex.getMessage());
        }
    }
    // </editor-fold>
    
}
