/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ken Jaya
 */
public class GetData {
    
    public ResultSet get (String query) throws SQLException {
        PreparedStatement ps ;
        ResultSet rs = null;
        
        ps = DB.getConnection().prepareStatement(query);
        rs = ps.executeQuery();
        
        return rs;
    }
    
}
