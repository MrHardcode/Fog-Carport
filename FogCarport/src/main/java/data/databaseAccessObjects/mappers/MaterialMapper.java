/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.databaseAccessObjects.mappers;

import data.databaseAccessObjects.DBConnector;
import data.exceptions.LoginException;
import data.models.MaterialModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Camilla
 */
public class MaterialMapper
{

    private static MaterialMapper materialMapper;

    private MaterialMapper()
    {

    }

    public static MaterialMapper getInstance()
    {
        if (materialMapper == null)
        {
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
     * @throws LoginException Should most likely throw something else.
     */
    String getCategory(int id) throws LoginException
    {
        String SQL = "SELECT `category`.`category_name`\n"
                + "FROM `carportdb`.`category`\n"
                + "WHERE `category`.`id_category` = ?;";
        // Using try-with resources, so they automatically close afterwards.
        try (Connection con = DBConnector.connection();
                PreparedStatement ps = con.prepareStatement(SQL);)
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
    MaterialModel getMaterial(int id) throws LoginException
    {
        MaterialModel material = new MaterialModel();

        String SQL = "SELECT * FROM `carportdb`.`materials`"
                + " WHERE `materials`.`id_material` = ?";
        // Using try-with resources, so they automatically close afterwards.
        try (Connection con = DBConnector.connection();
                PreparedStatement ps = con.prepareStatement(SQL);)
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

                double price = rs.getDouble("cost price");
                material.setPrice(price);

                String unit = rs.getString("unit");
                material.setUnit(unit);

                int categoryid = rs.getInt("id_category");
                material.setCategory(getCategory(categoryid)); // Using another Method

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
    String getOrderDetailsCategory(int id) throws LoginException
    {
        String SQL = "SELECT `order_details_category`.`details_category_name`\n"
                + "FROM `carportdb`.`order_details_category`\n"
                + "WHERE `order_details_category`.`id_order_details_category` = ?;";
        // Using try-with resources, so they automatically close afterwards.
        try (Connection con = DBConnector.connection();
                PreparedStatement ps = con.prepareStatement(SQL);)
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
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get all Materials for an order">
    /**
     * Get a List of Materials.
     * @param id of the Order Details.
     * @return List of MaterialModel.
     * @throws LoginException Should most likely throw something else.
     */
    List<MaterialModel> getMaterials(int id) throws LoginException
    { 
        List<MaterialModel> materials = new ArrayList<>();
        String SQL = "SELECT `order_details`.`id_material`\n"
                + "FROM `carportdb`.`order_details`\n"
                + "WHERE `order_details`.`id_order_details` = ?;";

        // Using try-with resources, so they automatically close afterwards.
        try (Connection con = DBConnector.connection();
                PreparedStatement ps = con.prepareStatement(SQL);)
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                MaterialModel material = getMaterial(rs.getInt("id_material"));
                materials.add(material);
            }
        } catch (SQLException ex)
        {
            // Should most likely be another exception.
            throw new LoginException(ex.getMessage()); // ex.getMessage() Should not be in production.
        }
        return materials;
    }
    // </editor-fold>
}