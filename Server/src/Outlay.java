
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahmoud
 */
public class Outlay implements Serializable{
    private int id;
    private String description;
    private int emp_id;
    private String emp_type;
    private double ammount;
    private String date;
    private String time;

    public Outlay(int id, String description, int emp_id, String emp_type, double ammount, String date, String time) {
        this.id = id;
        this.description = description;
        this.emp_id = emp_id;
        this.emp_type = emp_type;
        this.ammount = ammount;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setEmp_type(String emp_type) {
        this.emp_type = emp_type;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getEmp_type() {
        return emp_type;
    }

    public double getAmmount() {
        return ammount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
    
}
