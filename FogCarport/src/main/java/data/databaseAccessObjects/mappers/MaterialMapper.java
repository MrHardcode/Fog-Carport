
package data.databaseAccessObjects.mappers;

import data.databaseAccessObjects.DBConnector;
import data.exceptions.DataException;
import data.models.MaterialModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class MaterialMapper {

    private static MaterialMapper materialMapper;

    private MaterialMapper() {
    }

    public static MaterialMapper getInstance() {
        if (materialMapper == null) {
            materialMapper = new MaterialMapper();
        }
        return materialMapper;
    }

    // <editor-fold defaultstate="collapsed" desc="Get Category of a Material">
    /**
     * Get Category.
     *
     * @param id of the category.
     * @return name of the category.
     * @throws DataException
     */
    public String getCategory(int id) throws DataException {
        String SQL = "SELECT `category`.`category_name`\n"
                + "FROM `carportdb`.`category`\n"
                + "WHERE `category`.`id_category` = ?;";

        try {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            String category = "";
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                category = rs.getString("category_name");
            }
            return category;
        } catch (SQLException ex) {
            // Should most likely be another exception.
            throw new DataException(ex.getMessage()); // ex.getMessage() Should not be in production.
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
    public MaterialModel getMaterial(int id, String helptext) throws LoginException {
        MaterialModel material = new MaterialModel();

        String SQL = "SELECT `description`, height, width, length, cost_price, unit, category_name, helptext_"+helptext+" \n"
                + "FROM materials \n"
                + "INNER JOIN `category` \n"
                + "ON `materials`.`id_category` = `category`.`id_category` \n"
                + "WHERE `materials`.`id_material` = ?;";

        try {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            material.setID(id);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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

                String help_text = rs.getString("helptext_"+helptext);
                material.setHelptext(help_text);
            }
        } catch (SQLException ex) {
            // Should most likely be another exception.
            throw new DataException(ex.getMessage()); // ex.getMessage() 
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
    public String getOrderDetailsCategory(int id) throws DataException {
        String SQL = "SELECT `order_details_category`.`details_category_name`\n"
                + "FROM `carportdb`.`order_details_category`\n"
                + "WHERE `order_details_category`.`id_order_details_category` = ?;";
        try {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            String category = "";
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                category = rs.getString("details_category_name");
            }
            return category;
        } catch (SQLException ex) {
            // Should most likely be another exception.
            throw new DataException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get all Materials for an Order Details">
    /**
     * Get a List of Materials.
     *
     * @param id of the Order Details.
     * @return List of MaterialModel.
     * @throws DataException
     */
    public PartslistModel getMaterials(int id) throws DataException {
        PartslistModel materials = new PartslistModel();
        String SQL = "SELECT `order_details`.`id_material`\n"
                + "FROM `carportdb`.`order_details`\n"
                + "WHERE `order_details`.`id_order_details` = ?;";

        try {
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MaterialModel material = getMaterial(rs.getInt("id_material"));
                materials.addMaterial(material);
            }
        } catch (SQLException ex) {
            // Should most likely be another exception.
            throw new DataException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }
        return materials;
    }
    // </editor-fold>
}
