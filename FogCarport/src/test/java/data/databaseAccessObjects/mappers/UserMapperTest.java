/*
 *  
 */
package data.databaseAccessObjects.mappers;

import data.databaseAccessObjects.TestDBConnector;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author
 */
public class UserMapperTest
{

    public UserMapperTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of getEmployee method, of class UserMapper.
     */
    @Test
    public void testGetEmployee() throws Exception
    {
        Connection con = TestDBConnector.connection();
        System.out.println("getEmployee");
        int id = 7;
        UserMapper instance = UserMapper.getInstance();
        instance.setConnection(con);
        String expResult = "test";
        String result = instance.getEmployee(id).getName();
        assertEquals(expResult, result);
    }

}
