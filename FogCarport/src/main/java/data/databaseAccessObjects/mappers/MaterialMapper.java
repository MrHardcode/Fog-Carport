/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.databaseAccessObjects.mappers;

import data.databaseAccessObjects.DBConnector;
import data.exceptions.LoginException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        try (Connection con = new DBConnector().connection();
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
            throw new LoginException(ex.getMessage());
        }
    }
}
