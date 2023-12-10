
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahmoud
 */
public class EditSale implements Serializable{
    private int id;
    private double oldPrice,newPrice;
    private String date ;
    private String time;

    public EditSale(int id, double oldPrice, double newPrice, String date, String time) {
        this.id = id;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
