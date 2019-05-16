/*
 *  
 */
package data.databaseAccessObjects.mappers;

import data.models.OrderModel;
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
 * @author
 */
public class OrderMapperTest
{

    private static OrderMapper orderMapper;

    private static ResultSet resultSet;

    @BeforeClass
    public static void beforeClass() throws Exception
    {
        System.out.println("Mockito Test for Order Mapper");

        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);

        when(dataSource.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(connection.prepareStatement(anyString(), anyInt())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);

        orderMapper = new OrderMapper();
        orderMapper.setDataSource(dataSource);
    }

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateGetOrder() throws Exception
    {
        System.out.println("Test of getOrder and createOrder in OrderMapper");

        int id = 1;
        String status = "Accepted";
        int width = 3300;
        int length = 5400;
        int incline = 45;
        int roof_tiles_id = 33;
        String build_adress = "agnetevej";
        int build_zipcode = 2800;
        int customer_id = 10;
        int employee_id = 12;
        int shed_floor_id = 11;
        int shed_walls_id = 15;
        int shed_length = 3300;
        int shed_width = 3600;

        when(resultSet.next()).thenReturn(true);
        when(resultSet.getString("status")).thenReturn(status);
        when(resultSet.getInt("width")).thenReturn(width);
        when(resultSet.getInt("length")).thenReturn(length);
        when(resultSet.getInt("incline")).thenReturn(incline);
        when(resultSet.getInt("roof_tiles_id")).thenReturn(roof_tiles_id);
        when(resultSet.getString("build_adress")).thenReturn(build_adress);
        when(resultSet.getInt("build_zipcode")).thenReturn(build_zipcode);
        when(resultSet.getInt("customer_id")).thenReturn(customer_id);
        when(resultSet.getInt("employee_id")).thenReturn(employee_id);
        when(resultSet.getInt("shed_floor_id")).thenReturn(shed_floor_id);
        when(resultSet.getInt("shed_walls_id")).thenReturn(shed_walls_id);
        when(resultSet.getInt("shed_length")).thenReturn(shed_length);
        when(resultSet.getInt("shed_width")).thenReturn(shed_width);

        OrderModel order = new OrderModel();
        order.setStatus(status);
        order.setWidth(width);
        order.setLength(length);
        order.setIncline(incline);
        order.setRoof_tiles_id(roof_tiles_id);
        order.setBuild_adress(build_adress);
        order.setBuild_zipcode(build_zipcode);
        order.setId_customer(customer_id);
        order.setId_employee(employee_id);
        order.setShed_floor_id(shed_floor_id);
        order.setShed_walls_id(shed_walls_id);
        order.setShed_length(shed_length);
        order.setShed_width(shed_width);

        orderMapper.createOrder(order);

        OrderModel validatedOrder = orderMapper.getOrder(id);

        assertEquals(id, validatedOrder.getId());
        assertEquals(status, validatedOrder.getStatus());
        assertEquals(width, validatedOrder.getWidth());
        assertEquals(length, validatedOrder.getLength());
        assertEquals(incline, validatedOrder.getIncline());
        assertEquals(roof_tiles_id, validatedOrder.getRoof_tiles_id());
        assertEquals(build_adress, validatedOrder.getBuild_adress());
        assertEquals(build_zipcode, validatedOrder.getBuild_zipcode());
        assertEquals(customer_id, validatedOrder.getId_customer());
        assertEquals(employee_id, validatedOrder.getId_employee());
        assertEquals(shed_floor_id, validatedOrder.getShed_floor_id());
        assertEquals(shed_walls_id, validatedOrder.getShed_walls_id());
        assertEquals(shed_length, validatedOrder.getShed_length());
        assertEquals(shed_width, validatedOrder.getShed_width());

    }

}
