/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Database;
import java.sql.ResultSet;

/**
 *
 * @author Ken Jaya
 */
public class model_petugas extends Database{
    
    public void fetchAllUsers(){
    
        try{
            
            String query = "SELECT * FROM petugas";
            ResultSet resultSet = executeQuery(query);
            
        }catch(Exception e){
            
            e.printStackTrace();
            
        }finally{
            try{
                
                disconnect();
                
            }catch(Exception ex){
                
                ex.printStackTrace();
                
            }
        }
        
    }
}
