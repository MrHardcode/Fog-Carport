/*
 *  
 */
package data.databaseAccessObjects;

import com.mysql.cj.jdbc.MysqlDataSource;
import data.exceptions.LoginException;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class DataSourceMysql
{

    private static final String IP = "207.154.233.238";
    private static final int PORT = 3306;
    public static final String DATABASE = "carportdb";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    private MysqlDataSource dataSource = new MysqlDataSource();

    public DataSourceMysql() throws LoginException
    {
        dataSource.setServerName(IP);
        dataSource.setPort(PORT);
        dataSource.setDatabaseName(DATABASE);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
        try
        {
            dataSource.setUseSSL(false);
            dataSource.setAutoReconnect(true);
        } catch (SQLException ex)
        {
            throw new LoginException("Data Source issue.");
        }
    }

    // Should maybe be a singleton like in DBConnector?
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }

}
