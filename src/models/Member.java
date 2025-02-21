
package models;

import models.Member;
import classes.DB;
import classes.GetData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Member {
  
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

      private String gender;
    private byte[] picture;
    
    
    public Member(){}
    
     public Member(int _id, String _fname, String _lname, String _phone, String _email, String _gender, byte[] _picture)
    {
        this.id = _id;
        this.firstName = _fname;
        this.lastName = _lname;
        this.phone = _phone;
        this.email = _email;
        this.gender= _gender;
        this.picture = _picture;
        
        
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public byte[] getPicture() {
        return picture;
    }
  
    
      public void addMember(String _fname,String _lname,String _phone,String _email, String _gender, byte [] _picture) throws SQLException{
    
        String insertQuery = "INSERT INTO `member`(`firstName`, `lastName`, `phone`, `email`, `gender`, `picture`) VALUES (?,?,?,?,?,?)";
        
        
        try{
            
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setString(3, _phone);
            ps.setString(4, _email);
            ps.setString(5, _gender);
            ps.setBytes(6, _picture);
           
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Member Added", "Add memberr", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Member Not Added", "Add member", 2);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, e);
        }
             
    }
      
  
   
      public void editMember(Integer _id, String _fname,String _lname,String _phone,String _email, String _gender, byte [] _picture) throws SQLException{
    
        String editQuery = "UPDATE `member` SET `firstName`=?,`lastName`=?,`phone`=?,`email`=?,`gender`=?,`picture`=? WHERE `id`=?"; 
       
        try{
            
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);
            
            ps.setString(1, _fname);
            ps.setString(2, _lname);
            ps.setString(3, _phone);
            ps.setString(4, _email);
            ps.setString(5, _gender);
            ps.setBytes(6, _picture);
            ps.setInt(7, _id);
            
           
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Member Updated", "Edit member", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Member Not Updated", "Edit member", 2);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, e);
        }
            
    }
      
       public void removeMember(int _id ) {
    
        String removeAuthor = "DELETE FROM `member` WHERE `id` = ?"; 
       
        try{
            
            PreparedStatement ps = DB.getConnection().prepareStatement(removeAuthor);
            
            ps.setInt(1, _id);
           
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Member Deleted", "remove", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Member Not Deleted", "remove", 2);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, e);
        }
            
    }
         
    //get member by id
    public Member getMemberById(Integer _id) throws SQLException {
        
        String query = "SELECT * FROM `member` WHERE `id` = " + _id;
        ResultSet rs;
        rs = new GetData().get(query);
        
        
        if (rs.next()) {
            return new Member(
                rs.getInt(1), 
                rs.getString(2), 
                rs.getString(3), 
                rs.getString(4), 
                rs.getString(5), 
                rs.getString(6), 
                rs.getBytes(7)
            );
          } else 
        {
            return null;
        }  

    }
    
    public ArrayList<Member> member() {
                ArrayList<Member> mList = new ArrayList<>();
                String selectQuery = "SELECT * FROM `member`";

                try (PreparedStatement ps = DB.getConnection().prepareStatement(selectQuery);
                 ResultSet rs = ps.executeQuery()) {

                while(rs.next()) {
                Member member = new Member(
                    rs.getInt("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"), 
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("gender"),
                    rs.getBytes("picture")
                );
                mList.add(member);
            }

       } catch (SQLException ex) {
           
           Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);

       }
        
       return mList;
    }

    public ArrayList<Member> membersList(String query) {
        ArrayList<Member> mList = new ArrayList<>();
        
        GetData data = new GetData();
        
        try{
            
            if(query.equals("")){
                
                query = "SELECT * FROM `member`";
                
            }
            
            ResultSet rs = data.get(query);
            
            Member member;
            
            while(rs.next()){
            
                member = new Member(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("phone"), rs.getString("email"), rs.getString("gender"), rs.getBytes("picture"));
                mList.add(member);
            }
        }catch(SQLException ex){
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mList;
    }

    public ArrayList<Member> memberList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
