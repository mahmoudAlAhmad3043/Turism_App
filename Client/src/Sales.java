import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.Time;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahmoud
 */
public class Sales implements SalesInterface,Serializable{
    private int id;
    private PhotogragherInterface photographer ;
    private TourGuidesInterface tourGuide ;
    private double price;
    private String date ;
    private String time;
    private double dollar;
    private double euro;

    public Sales(PhotogragherInterface photographer, TourGuidesInterface tourGuide, double price, String date,String time, double dollar, double euro,int id) {
        this.id = id;
        this.photographer = photographer;
        this.tourGuide = tourGuide;
        this.price = price;
        this.date = date;
        this.dollar = dollar;
        this.euro = euro;
        this.time = time;
    }

    @Override
    public PhotogragherInterface getPhotographer() throws RemoteException {
        return this.photographer;
    }

    @Override
    public TourGuidesInterface getTourGide() throws RemoteException {
        return this.tourGuide;
    }

    @Override
    public double getPrice() throws RemoteException {
        return this.price;
    }

    @Override
    public String getDate() throws RemoteException {
        return this.date;
    }

    @Override
    public String getTime() throws RemoteException {
        return this.time;
    }

    @Override
    public double getDollar() throws RemoteException {
        return this.dollar;
    }

    @Override
    public double getEuro() throws RemoteException {
        return this.euro;
    }

    @Override
    public void setPhotographer(PhotogragherInterface photographer) throws RemoteException {
        this.photographer = photographer;
    }

    @Override
    public void setTourGuide(TourGuidesInterface tourGuide) throws RemoteException {
        this.tourGuide = tourGuide;
    }

    @Override
    public void setPrice(double price, int flag) throws RemoteException {
        if(flag == 0){
            this.price = price;
        }else if(flag == 1){
            this.price = price*this.dollar;
        }else{
            this.price = price*this.euro;
        }
    }

    @Override
    public void setDate(String date) throws RemoteException {
        this.date = date;
    }

    @Override
    public void setTime(String time) throws RemoteException {
        this.time = time;
    }

    @Override
    public void setDollar(double dollar) throws RemoteException {
        this.dollar = dollar;
    }

    @Override
    public void setEuro(double euro) throws RemoteException {
        this.euro = euro;
    }
    @Override
    public int getId() throws RemoteException{
        return id;
    }
    @Override
    public void setId(int id) throws RemoteException{
        this.id = id;
    }
    
}
