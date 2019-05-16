/*
 *  
 */
package data.databaseAccessObjects.mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
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
    public void testCreateGetOrder() throws Exception {
        
    }
    
}
