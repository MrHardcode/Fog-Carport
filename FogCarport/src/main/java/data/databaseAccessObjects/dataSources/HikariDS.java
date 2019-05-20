/*
 *  
 */
package data.databaseAccessObjects.dataSources;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 *
 * @author 
 */
public class HikariDS
{
    private static final String IP = "207.154.233.238"; // 207.154.233.238
    private static final int PORT = 3306; // 3306
    private static final String DATABASE = "carportdb"; // carportdb
    private static final String USERNAME = "admin"; // admin
    private static final String PASSWORD = "1234"; // 1234
    private static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?autoReconnect=true&useSSL=false";

    private static HikariDataSource dataSource;
    static{

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);  
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        dataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource()
    {
        return dataSource;
    }
}
