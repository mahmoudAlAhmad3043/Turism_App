
import java.rmi.Remote;
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
public interface ManagerInterface extends Remote{
    public String getFirstName() throws RemoteException;
    public String getSecondName() throws RemoteException;
    public String getPassword() throws RemoteException;
    public double getAccount() throws RemoteException;
    public double getPercent() throws RemoteException;
    public void setFirstName(String firstName)throws RemoteException;
    public void setSecondName(String secondName) throws RemoteException;
    public void setPassword(String password) throws RemoteException;
    public void setAccount(double account) throws RemoteException;
    public void setPercent(double percent) throws RemoteException;
    public double deposit(double ammount) throws RemoteException;
    public void withdraw(double ammount) throws RemoteException;
    public void withdraw1(double ammount) throws RemoteException;
}
