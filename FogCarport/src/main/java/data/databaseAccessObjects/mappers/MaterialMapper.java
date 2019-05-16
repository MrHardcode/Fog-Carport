package data.databaseAccessObjects.mappers;

import data.databaseAccessObjects.DatabaseConnector;
import data.exceptions.LoginException;
import data.models.MaterialModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author
 */
public class MaterialMapper
{

    private DatabaseConnector dbc = new DatabaseConnector();

    public void setDataSource(DataSource ds)
    {
        dbc.setDataSource(ds);
    }

    // <editor-fold defaultstate="collapsed" desc="Get Category of a Material">
    /**
     * Get Category.
     *
     * @param id of the category.
     * @return name of the category.
     * @throws LoginException Should most likely throw something else.
     */
    public String getCategory(int id) throws LoginException
    {
        String SQL = "SELECT `category`.`category_name`\n"
                + "FROM `carportdb`.`category`\n"
                + "WHERE `category`.`id_category` = ?;";

        try (DatabaseConnector open_dbc = dbc.open())
        {
            PreparedStatement ps = open_dbc.preparedStatement(SQL);
            String category = "";
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                category = rs.getString("category_name");
            }
            return category;
        } catch (SQLException ex)
        {
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get a Material">
    /**
     * Get a Material.
     *
     * @param id of the Material.
     * @return MaterialModel
     * @throws LoginException Should probably be something else later on.
     */
    public MaterialModel getMaterial(int id) throws LoginException
    {
        MaterialModel material = new MaterialModel();

        String SQL = "SELECT `description`, height, width, length, cost_price, unit, category_name \n"
                + "FROM materials \n"
                + "INNER JOIN `category` \n"
                + "ON `materials`.`id_category` = `category`.`id_category` \n"
                + "WHERE `materials`.`id_material` = ?;";

        try (DatabaseConnector open_dbc = dbc.open())
        {
            PreparedStatement ps = open_dbc.preparedStatement(SQL);
            material.setID(id);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                String description = rs.getString("description");
                material.setDescription(description);

                int height = rs.getInt("height");
                material.setHeight(height);

                int width = rs.getInt("width");
                material.setWidth(width);

                int length = rs.getInt("length");
                material.setLength(length);

                double price = rs.getDouble("cost_price");
                material.setPrice(price);

                String unit = rs.getString("unit");
                material.setUnit(unit);

                String categoryname = rs.getString("category_name");
                material.setCategory(categoryname);

            }
        } catch (SQLException ex)
        {
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }

        return material;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get Order Details Category">
    /**
     * Get Order Details Category.
     *
     * @param id of the category.
     * @return name of the category.
     * @throws LoginException Should most likely throw something else.
     */
    public String getOrderDetailsCategory(int id) throws LoginException
    {
        String SQL = "SELECT `order_details_category`.`details_category_name`\n"
                + "FROM `carportdb`.`order_details_category`\n"
                + "WHERE `order_details_category`.`id_order_details_category` = ?;";
        try (DatabaseConnector open_dbc = dbc.open())
        {
            PreparedStatement ps = open_dbc.preparedStatement(SQL);
            String category = "";
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                category = rs.getString("details_category_name");
            }
            return category;
        } catch (SQLException ex)
        {
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }
    }
    // </editor-fold>

}
