/*
 *  
 */
package data.databaseAccessObjects;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author
 */
public class DBCPDataSource
{

    private BasicDataSource dataSource = new BasicDataSource();

    private static final String IP = "207.154.233.238";
    private static final int PORT = 3306;
    public static final String DATABASE = "carportdb";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;

    public DBCPDataSource()
    {
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public BasicDataSource getDataSource()
    {
        return dataSource;
    }
}
