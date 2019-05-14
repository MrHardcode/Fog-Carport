
package data.databaseAccessObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

/**
 *
 * @author 
 */
public class DBConnector
{

    private static final String IP = "207.154.233.238";
    private static final String PORT = "3306";
    public static final String DATABASE = "carportdb"; 
    private static final String USERNAME = "admin"; 
    private static final String PASSWORD = "1234"; 

    private static DataSource datasource;
    private static Connection singleton; 
    
    public static Connection connection() throws SQLException
    {
        if (singleton == null || singleton.isClosed())
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

                String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;

                Properties props = new Properties();
                props.put("user", USERNAME);
                props.put("password", PASSWORD);
                props.put("allowMultiQueries", true);
                props.put("useUnicode", true);
                props.put("useJDBCCompliantTimezoneShift", true);
                props.put("useLegacyDatetimeCode", false);
                props.put("serverTimezone", "CET");
                singleton = DriverManager.getConnection(url, props);
                System.out.println("Connection correctly established to the database: " + DATABASE);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
            {
                ex.printStackTrace();
                throw new SQLException(ex.getMessage());
            } 
        }
        return singleton;
    }
}
