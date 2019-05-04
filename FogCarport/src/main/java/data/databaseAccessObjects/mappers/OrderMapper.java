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
 * @author
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
    public OrderModel getOrder(int id) throws LoginException {
        OrderModel order = new OrderModel();

        String SQL = "SELECT * FROM `carportdb`.`orders`"
                + " WHERE `orders`.`id_order` = ?";

        try {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            order.setId(id); // id_order

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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

        } catch (SQLException ex) {
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }

        return order;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Create an Order">
    public void createOrder(OrderModel order) throws LoginException {
        // SQL STATEMENT
        String SQL = "INSERT INTO `carportdb`.`orders` "
                + " (`build_adress`, `build_zipcode`, `status`, `width`, `length`, "
                + "`incline`, `roof_tiles_id`, `shed_width`, `shed_length`, `shed_walls_id`, "
                + "`shed_floor_id`, `customer_id`, `employee_id`)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, order.getBuild_adress());
            ps.setInt(2, order.getBuild_zipcode());
            ps.setString(3, order.getStatus());
            ps.setInt(4, order.getWidth());
            ps.setInt(5, order.getLength());
            ps.setInt(6, order.getIncline());
            ps.setInt(7, order.getRoof_tiles_id());
            ps.setInt(8, order.getShed_width());
            ps.setInt(9, order.getShed_length());
            ps.setInt(10, order.getShed_walls_id());
            ps.setInt(11, order.getShed_floor_id());
            ps.setInt(12, order.getId_customer());
            ps.setInt(13, order.getId_employee());
            ps.executeUpdate();
            ResultSet id = ps.getGeneratedKeys(); // Getting the auto-generated order_id.
            id.next();
            int order_id = id.getInt(1);
            order.setId(order_id);
        } catch (SQLException ex) {
            throw new LoginException(ex.getMessage());
        }
    }
    // </editor-fold>

}
