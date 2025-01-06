/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ken Jaya
 */
public class CountData {
    
    public int count(String tableName) throws SQLException{
    
        int total = 0
                ;
        ResultSet rs;
        
        Statement st;
        
        st = DB.getConnection().createStatement();
        rs = st.executeQuery("SELECT COUNT(*) as total FROM `"+tableName+"`");
        
        if(rs.next()){
        
            total = rs.getInt("total");
        }
        
        return total;
    }
    
    
}
