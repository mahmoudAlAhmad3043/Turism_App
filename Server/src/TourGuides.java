
import java.io.Serializable;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahmoud
 */
public class TourGuides implements TourGuidesInterface,Serializable{
    private String firstName ;
    private String secondName ;
    private int id;
    private double account ;
    private double percent;

    public TourGuides(String firstName, String secondName, double account,double percent , int id) throws RemoteException{
        this.firstName = firstName;
        this.secondName = secondName;
        this.account = account;
        this.percent = percent;
        this.id = id;
    }

    @Override
    public int getId() throws RemoteException{
        return this.id;
    }

    @Override
    public String getFirstName() throws RemoteException{
        return this.firstName;
    }

    @Override
    public String getSecondName() throws RemoteException{
        return this.secondName;
    }

    @Override
    public double getAccount() throws RemoteException{
        return this.account;
    }

    @Override
    public double getPercent() throws RemoteException{
        return this.percent;
    }

    @Override
    public void setFirstName(String firstName) throws RemoteException{
        this.firstName = firstName;
    }

    @Override
    public void setSecondName(String secondName) throws RemoteException{
        this.secondName = secondName;
    }

    @Override
    public void setAccount(double account) throws RemoteException{
        this.account = account;
    }
    @Override
    public void setPercent(double percent) throws RemoteException{
        this.percent = percent;
    }

    @Override
    public double deposit(double ammount) throws RemoteException{
        this.account = this.account + (ammount*this.percent/100.0);
        return (ammount*this.percent/100.0);
    }

    @Override
    public void withdraw(double ammount) throws RemoteException{
        this.account = this.account - (ammount*this.percent/100.0);
    }
    
}
