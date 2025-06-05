package models.data;

import java.io.Serializable;

public class User implements Serializable{
    private int userID;
    private String userName;
    private String password;
    private String email;
    private String phone;

    // No args constructor
    public User(){
        
    }
    
    // All arguments constructor
    public User(int userID,String userName,String password,String email,String phone){
        this.userID=userID;
        this.userName=userName;
        this.password=password;
        this.email=email;
        this.phone=phone;
    }
    
    // Getters and Setters
    public int getId() {
        return userID;
    }

    public void setId(int id) {
        this.userID = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
