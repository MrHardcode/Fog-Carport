

package data.databaseAccessObjects.mappers;

import data.databaseAccessObjects.DBConnector;
import data.exceptions.DataException;
import data.models.OrderModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
     * @throws DataException
     */
    public OrderModel getOrder(int id) throws DataException {
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
            throw new DataException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }

        return order;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Create an Order">
    /**
     * Create an order.
     * Inputs an order into the Database.
     * @param order you want to input into the SQL database.
     * @throws DataException 
     */
    public void createOrder(OrderModel order) throws DataException {
        // SQL STATEMENT
        String SQL = "INSERT INTO `carportdb`.`orders` "
                + " (`build_adress`, `build_zipcode`, `status`, `width`, `length`, "
                + "`incline`, `roof_tiles_id`, `shed_width`, `shed_length`, `shed_walls_id`, "
                + "`shed_floor_id`, `customer_id`, `employee_id`)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
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
            try (ResultSet ids = ps.getGeneratedKeys()) // Getting auto-generated key.
            {
                ids.next();
                int id = ids.getInt(1);
                order.setId(id);
            }
        } catch (SQLException ex) {
            throw new DataException(ex.getMessage());
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get all order ids">
    /**
     * Get all order ids.
     * Used by the .jsp that shows a list of all orders to the salesman.
     * @return
     * @throws DataException 
     */
    public List<Integer> getAllOrderIds() throws DataException {
        String SQL = "SELECT `orders`.`id_order` FROM `carportdb`.`orders`;";
        List<Integer> ids = new ArrayList<>();
        try {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id_order");
                ids.add(id);
            }
        }catch(SQLException ex){
            throw new DataException(ex.getMessage());
        }
        return ids;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Get all order ids for one customer">
    /**
     * Get all Order ids from one Customer.
     * @param id
     * @return
     * @throws DataException 
     */
    public List<Integer> getOrderIds(int id) throws DataException {
        String SQL = "SELECT id_order FROM carportdb.orders WHERE customer_id = ?;";
        List<Integer> ids = new ArrayList<>();
        try {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer tempid = rs.getInt("id_order");
                ids.add(tempid);
            }
        } catch(SQLException ex) {
            throw new DataException(ex.getMessage());
        }
        return ids;
    }
    // </editor-fold>

    public void payOrder(int id) throws DataException
    {
        String SQL = "UPDATE `carportdb`.`orders` SET `status` = 'Finalized' WHERE (`id_order` = ?);";
        try
        {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex)
        {
            throw new DataException(ex.getMessage());
        }

    }
}

