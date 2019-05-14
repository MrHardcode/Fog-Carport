/*
 *  
 */
package data.databaseAccessObjects.mappers;

import data.exceptions.LoginException;
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
    public static void beforeClass()
    {   
        System.out.println("Mockito Tests...");
        
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        
        try
        {
            when(dataSource.getConnection()).thenReturn(connection);
            when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
            when(connection.prepareStatement(anyString(), anyInt())).thenReturn(preparedStatement);
            when(preparedStatement.executeQuery()).thenReturn(resultSet);
            when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        userMapper = new UserMapper();        
        userMapper.setDataSource(dataSource);
    }

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }
            
    @Test
    public void testRegisterValidateUser() throws LoginException
    {
        System.out.println("testRegisterValidateUser...");
        
        int id = 1;
        String name = "testuser";
        int phone = 112;
        String email = "testuser@email.com";
        String password = "testpassword";
        
        try
        {
            when(resultSet.next()).thenReturn(true);
            when(resultSet.getInt("id_customer")).thenReturn(id); 
            when(resultSet.getInt("phone")).thenReturn(phone);
            when(resultSet.getString("customer_name")).thenReturn(name);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        CustomerModel customer = new CustomerModel();
        customer.setId(id);
        customer.setName(name);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setPassword(password);
        
        userMapper.createCustomer(customer);
        
        CustomerModel validatedUser = userMapper.login(email, password);
                
        assertEquals(id, validatedUser.getId());
        assertEquals(name, validatedUser.getName());
        assertEquals(phone, validatedUser.getPhone());
        assertEquals(email, validatedUser.getEmail());
        assertEquals(password, validatedUser.getPassword());
    }
}
