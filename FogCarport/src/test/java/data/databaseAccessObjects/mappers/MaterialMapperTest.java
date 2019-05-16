/*
 *  Malte Hviid-Magnussen
 */
package data.databaseAccessObjects.mappers;

import data.models.MaterialModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Malte
 */
public class MaterialMapperTest
{
 
    private static MaterialMapper materialMapper;

    private static ResultSet resultSet;

    @BeforeClass
    public static void beforeClass() throws Exception
    {
        System.out.println("Mockito Test for Material Mapper");

        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);

        when(dataSource.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(connection.prepareStatement(anyString(), anyInt())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);

        materialMapper = new MaterialMapper();
        materialMapper.setDataSource(dataSource);
    }

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateGetOrder() throws Exception
    {
        System.out.println("Test of getMaterial");

        int id = 1;
        String description = "trykimp. stolpe";
        int height = 540;
        int width = 320;
        int length = 12;
        double cost_price = 12.32;
        String unit = "Stk";
        String categoryname = "misc";
        
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getString("description")).thenReturn(description);
        when(resultSet.getInt("height")).thenReturn(height);
        when(resultSet.getInt("width")).thenReturn(width);
        when(resultSet.getInt("length")).thenReturn(length);
//        when(resultSet.getDouble("cost_price")).thenReturn(cost_price);
        when(resultSet.getString("unit")).thenReturn(unit);
        when(resultSet.getString("category_name")).thenReturn(categoryname);

        MaterialModel validatedMaterial = materialMapper.getMaterial(id);

        assertEquals(id, validatedMaterial.getID());
        assertEquals(description, validatedMaterial.getDescription());
        assertEquals(height, validatedMaterial.getHeight());
        assertEquals(width, validatedMaterial.getWidth());
        assertEquals(length, validatedMaterial.getLength());
//        assertEquals(cost_price, validatedMaterial.getPrice());
        assertEquals(unit, validatedMaterial.getUnit());
        assertEquals(categoryname, validatedMaterial.getCategory());
    }

}
