/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ken Jaya
 */
public class Database {
    
    private String url = "jdbc:mysql://localhost:8080/perpustakaan";;
    private String username = "root";
    private String password = "";
    
    protected Connection conn;
    
    public Database() throws Exception{
        
        if(conn == null || conn.isClosed()){
            
            conn = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Database connected");
        }
    
    }
    
    
    public void disconnect() throws Exception{
        
        if(conn != null && !conn.isClosed()){
            conn.close();
            System.out.println("Database disconnected");
        }
        
    }
    
    public ResultSet executeQuery(String query, Object... parameters) throws Exception {
        PreparedStatement statement = conn.prepareStatement(query);

        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }

        return statement.executeQuery();
    }
    
    
    public int executeUpdate(String query, Object... parameters) throws Exception {
        PreparedStatement statement = conn.prepareStatement(query);

        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i + 1, parameters[i]);
        }

        return statement.executeUpdate();
    }
}
