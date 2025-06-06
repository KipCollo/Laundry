package models.data;

/**
 *
 * @author collins
*/

import java.io.Serializable;

public class Order implements Serializable{
    private int orderID;
    private String pickUp;
    private String time;

    //No arg constructor
    public Order(){
        
    }
    
    // All arg constructor
     public Order(int orderID,String pickUp,String time){
        this.orderID=orderID;
        this.pickUp=pickUp;
        this.time=time;
    }
    
    // Getters and setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
