
import java.rmi.Remote;
import java.rmi.RemoteException;
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
public interface SalesInterface extends Remote{
    public PhotogragherInterface getPhotographer() throws RemoteException;
    public TourGuidesInterface getTourGide() throws RemoteException;
    public double getPrice() throws RemoteException;
    public String getDate() throws RemoteException;
    public String getTime() throws RemoteException;
    public double getDollar() throws RemoteException;
    public double getEuro() throws RemoteException;
    
    public void setPhotographer(PhotogragherInterface photographer) throws RemoteException;
    public void setTourGuide(TourGuidesInterface tourGuide) throws RemoteException;
    public void setPrice(double price , int flag) throws RemoteException;
    public void setDate(String date) throws RemoteException;
    public void setTime(String time) throws RemoteException;
    public void setDollar(double dollar) throws RemoteException;
    public void setEuro(double euro) throws RemoteException;
    public int getId() throws RemoteException;
    public void setId(int id) throws RemoteException;
}