/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.DB;
import classes.GetData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ken Jaya
 */
public class Book {
    
    private Integer id;
    private String isbn;
    private String name;
    private Integer author_id;
    private Integer genre_id;
    private Integer quantity;
    private String publisher;
    private double price;
    private String date_received;
    private String description;
    private byte[] cover;
    
    public Book(){}
    
    public Book(Integer _id, String _isbn, String _name, Integer _author_id, Integer _genre_id, Integer _quantity, String _publisher, double _price, String _date_received, String _description, byte[] _cover){
        
        this.id = _id;
        this.isbn = _isbn;
        this.name = _name;
        this.author_id = _author_id;
        this.genre_id = _genre_id;
        this.quantity = _quantity;
        this.publisher = _publisher;
        this.price = _price;
        this.date_received = _date_received;
        this.description = _description;
        this.cover = _cover;
    }

    public Integer getId() {
        return id;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }

    public String getDate_received() {
        return date_received;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate_received(String date_received) {
        this.date_received = date_received;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
    
    public void addBook(String _isbn, String _name, Integer _author_id, Integer _genre_id, Integer _quantity, String _publisher, double _price, String _date_received, String _description, byte[] _cover){
        String insertQuery = "INSERT INTO `books`(`isbn`, `name`, `author_id`, `genre_id`, `quantity`, `publisher`, `price`, `date_received`, `description`, `cover`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        
        try{
            
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);
            
            ps.setString(1, _isbn);
            ps.setString(2, _name);
            ps.setInt(3, _author_id);
            ps.setInt(4, _genre_id);
            ps.setInt(5, _quantity);
            ps.setString(6, _publisher);
            ps.setDouble(7, _price);
            ps.setString(8, _date_received);
            ps.setString(9, _description);
            ps.setBytes(10, _cover);
           
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Book Added", "Add Book", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Book Not Added", "Add Book", 2);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }
    
    public void editBook(Integer _id, String _name, Integer _author_id, Integer _genre_id, Integer _quantity, String _publisher, double _price, String _date_received, String _description, byte[] _cover){
        
        String updateQuery = "";
        PreparedStatement ps;
        
        try{
            if(_cover != null){
        
                updateQuery = "UPDATE `books` SET `name` = ?, `author_id` = ?, `genre_id` = ?, `quantity` = ?, `publisher` = ?, `price` = ?, `date_received` = ?, `description` = ?, `cover` = ? WHERE `id` = ?";

                ps = DB.getConnection().prepareStatement(updateQuery);

                //ps.setString(1, _isbn);
                ps.setString(1, _name);
                ps.setInt(2, _author_id);
                ps.setInt(3, _genre_id);
                ps.setInt(4, _quantity);
                ps.setString(5, _publisher);
                ps.setDouble(6, _price);
                ps.setString(7, _date_received);
                ps.setString(8, _description);
                ps.setBytes(9, _cover);
                ps.setInt(10, _id);

                if(ps.executeUpdate() != 0){
                    JOptionPane.showMessageDialog(null, "Book Edited", "Edit Book", 1);
                }else{
                    JOptionPane.showMessageDialog(null, "Book Not Edited", "Edit Book", 2);
                }
            
        
            }else{

                updateQuery = "UPDATE `books` SET `name` = ?, `author_id` = ?, `genre_id` = ?, `quantity` = ?, `publisher` = ?, `price` = ?, `date_received` = ?, `description` = ? WHERE `id` = ?";
                ps = DB.getConnection().prepareStatement(updateQuery);

                //ps.setString(1, _isbn);
                ps.setString(1, _name);
                ps.setInt(2, _author_id);
                ps.setInt(3, _genre_id);
                ps.setInt(4, _quantity);
                ps.setString(5, _publisher);
                ps.setDouble(6, _price);
                ps.setString(7, _date_received);
                ps.setString(8, _description);
                //ps.setBytes(9, _cover);
                ps.setInt(9, _id);
            }        
 
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Book Edited", "Edit Book", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Book Not Edited", "Edit Book", 2);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }
    
    public void removeBook(Integer _id){
    
        String removeBook = "DELETE FROM `books` WHERE `id` = ?"; 
       
        try{
            
            PreparedStatement ps = DB.getConnection().prepareStatement(removeBook);
            
            ps.setInt(1, _id);
           
            
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Book Deleted", "remove", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Book Not Deleted", "remove", 2);
            }
        }catch(SQLException e){
            
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }
    
    
    public boolean isISBNExists(String _isbn) throws SQLException{
        
        GetData getData = new GetData();
        String query = "SELECT * FROM `books` WHERE `isbn` = '" + _isbn +"'";
        
        ResultSet rs = getData.get(query);
        
        return rs.next();
    }
    
    
    public Book searchBookByID_ISBN(int id, String _isbn) throws SQLException{
    
        String query = "SELECT * FROM `books` WHERE `isbn` = '" + _isbn +"' OR `id` = '" + id + "'";
          
        GetData getData = new GetData();
        
        ResultSet rs = getData.get(query);
        
        Book book = null;
        
        
        try{
            
            if(rs.next()){
                
                book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getString(9), rs.getString(10), rs.getBytes(11));
            
            }else{
                
                return null;
            
            }
        
        }catch(SQLException ex){
            
        }
        
        return book;
    }
    
    //funcion to populate an arraylist whit books
    
     public ArrayList<Book> BooksList(){
        
        ArrayList<Book> bList = new ArrayList<>();
        
        String selectQuery = "SELECT * FROM `books`";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = DB.getConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            Book book;
            
            while(rs.next()){
                
              
                book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getString(9), rs.getString(10), rs.getBytes(11));
                bList.add(book);
            }
     
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bList;
     }
    
     //get book by id
    public Book getBookById(Integer _id) throws SQLException {
        
        
        String query = "SELECT * FROM `books` WHERE `id` = " + _id;
        ResultSet rs;
        rs = new GetData().get(query);
        
        
        if (rs.next())
          {
            return new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getDouble(8), rs.getString(9), rs.getString(10), rs.getBytes(11));
          } 
        
        else 
         {
            return null;
         }  

    }
     
     
}
