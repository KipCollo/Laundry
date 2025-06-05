/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.data;

/**
 *
 * @author collins
 */
public class Admin {
    
    private int adminID;
    private String userName;
    private String password;
    private String email;

    // No arg constructor
    public Admin(){
        
    }
    
    // All arguments constructor
    public Admin(int adminID,String userName,String password,String email){
        this.adminID=adminID;
        this.userName=userName;
        this.password=password;
        this.email=email;
    }
    
     // Getters and Setters
    public int getId() {
        return adminID;
    }

    public void setId(int id) {
        this.adminID = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
