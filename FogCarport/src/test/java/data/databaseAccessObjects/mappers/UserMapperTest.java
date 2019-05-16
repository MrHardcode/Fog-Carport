/*
 *  
 */
package data.databaseAccessObjects.mappers;

import data.models.CustomerModel;
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
public class UserMapperTest
{

    private static UserMapper userMapper;

    private static ResultSet resultSet;

    @BeforeClass
    public static void beforeClass() throws Exception
    {
        System.out.println("Mockito Tests for User Mapper");

        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);

        when(dataSource.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(connection.prepareStatement(anyString(), anyInt())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);

        userMapper = new UserMapper();
        userMapper.setDataSource(dataSource);
    }

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoginCreateCustomer() throws Exception
    {
        System.out.println("Test of login and createCustomer in UserMapper");

        int id = 1;
        String name = "testuser";
        int phone = 112;
        String email = "testuser@email.com";
        String password = "testpassword";

        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id_customer")).thenReturn(id);
        when(resultSet.getInt("phone")).thenReturn(phone);
        when(resultSet.getString("customer_name")).thenReturn(name);

        CustomerModel customer = new CustomerModel();
        customer.setId(id);
        customer.setName(name);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setPassword(password);

        userMapper.createCustomer(customer);

        CustomerModel validatedCustomer = userMapper.login(email, password);

        assertEquals(id, validatedCustomer.getId());
        assertEquals(name, validatedCustomer.getName());
        assertEquals(phone, validatedCustomer.getPhone());
        assertEquals(email, validatedCustomer.getEmail());
        assertEquals(password, validatedCustomer.getPassword());
    }
}
