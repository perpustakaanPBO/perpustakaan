
package classes;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;

public class DB {
    
    private static String url;
    private static String serverName = "localhost";
    private static String userName = "root";
    private static String password = "";
    private static String dbname = "perpustakaan";
    private static int portNumber = 8080;
    
    
    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        
//        MysqlDataSource dataSource = new MysqlDataSource();
//        
//        dataSource.setServerName(serverName);
//        dataSource.setUser(userName);
//        dataSource.setPassword(password);
//        dataSource.setDatabaseName(dbname);
//        dataSource.setPortNumber(portNumber);
        
        try{
        
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan", "root", "");
        }catch(Exception e){
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
        
    }
}
