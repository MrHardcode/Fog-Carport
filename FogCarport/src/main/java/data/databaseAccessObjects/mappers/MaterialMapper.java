package data.databaseAccessObjects.mappers;

import data.exceptions.DataException;
import data.models.MaterialModel;
import data.models.PartslistModel;
import java.sql.Connection;
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

//    private DatabaseConnector dbc = new DatabaseConnector(); Old way we did it.
    private DataSource ds;

    public void setDataSource(DataSource ds)
    {
//        dbc.setDataSource(ds); Old way we did it.
        this.ds = ds;
    }

    // <editor-fold defaultstate="collapsed" desc="Get Category of a Material">
    /**
     * Get Category.
     *
     * @param id of the category.
     * @return name of the category.
     * @throws DataException
     */
    public String getCategory(int id) throws DataException
    {
        String SQL = "SELECT `category`.`category_name`\n"
                + "FROM `carportdb`.`category`\n"
                + "WHERE `category`.`id_category` = ?;";

        try (Connection connection = ds.getConnection();
                PreparedStatement ps = connection.prepareStatement(SQL))
        {

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
            throw new DataException("Kunne ikke skaffe materialet med id: "+id+"'s kategori fra databasen.");
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get a Material">
    /**
     * Get a Material.
     *
     * @param id of the Material.
     * @param helptext
     * @return MaterialModel
     * @throws DataException
     */
    public MaterialModel getMaterial(int id, String helptext) throws DataException
    {
        MaterialModel material = new MaterialModel();

        String SQL = "SELECT `description`, height, width, length, cost_price, unit, category_name, helptext_" + helptext + " \n"
                + "FROM materials \n"
                + "INNER JOIN `category` \n"
                + "ON `materials`.`id_category` = `category`.`id_category` \n"
                + "WHERE `materials`.`id_material` = ?;";

        try (Connection connection = ds.getConnection();
                PreparedStatement ps = connection.prepareStatement(SQL))
        {
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

                String help_text = rs.getString("helptext_" + helptext);
                material.setHelptext(help_text);
            }
        } catch (SQLException ex)
        {
            throw new DataException("Kunne ikke skaffe materialet med id: "+id+" fra databasen."); 
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
     * @throws DataException
     */
    public String getOrderDetailsCategory(int id) throws DataException
    {
        String SQL = "SELECT `order_details_category`.`details_category_name`\n"
                + "FROM `carportdb`.`order_details_category`\n"
                + "WHERE `order_details_category`.`id_order_details_category` = ?;";
        try (Connection connection = ds.getConnection();
                PreparedStatement ps = connection.prepareStatement(SQL))
        {

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
            throw new DataException("Kunne ikke skaffe ordren med id: "+id+"'s kategori fra databasen.");
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get all Materials for an Order Details">
    /**
     * Get a List of Materials.
     *
     * @param id of the Order Details.
     * @param helptext
     * @return List of MaterialModel.
     * @throws DataException
     */
    public PartslistModel getMaterials(int id, String helptext) throws DataException
    {
        PartslistModel materials = new PartslistModel();
        String SQL = "SELECT `order_details`.`id_material`\n"
                + "FROM `carportdb`.`order_details`\n"
                + "WHERE `order_details`.`id_order_details` = ?;";

        try (Connection connection = ds.getConnection();
                PreparedStatement ps = connection.prepareStatement(SQL))
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                MaterialModel material = getMaterial(rs.getInt("id_material"), helptext);
                materials.addMaterial(material);
            }
        } catch (SQLException ex)
        {
            throw new DataException("Kunne ikke skaffe materialerne med order id: "+id+" fra databasen.");
        }
        return materials;
    }
    // </editor-fold>
}
