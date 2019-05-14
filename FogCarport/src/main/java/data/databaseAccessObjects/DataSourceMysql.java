/*
 *  
 */
package data.databaseAccessObjects;

import com.mysql.cj.jdbc.MysqlDataSource;

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

    public DataSourceMysql()
    {
        dataSource.setServerName(IP);
        dataSource.setPort(PORT);
        dataSource.setDatabaseName(DATABASE);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
//        dataSource.setUseSSL(false);
    }

    // Should maybe be a singleton like in DBConnector?
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
    
}
