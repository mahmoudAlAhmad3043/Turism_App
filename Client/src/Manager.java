
import java.io.Serializable;
import java.rmi.RemoteException;

public class Manager implements ManagerInterface,Serializable{
    private String firstName ;
    private String secondName ;
    private String password ;
    private double account;
    private double percent;

    @Override
    public void withdraw1(double ammount) throws RemoteException {
        this.account = this.account - ammount;
    }
    private static class ManagerHelper{
        private static final Manager mydegree = new Manager();
    }

    private Manager(){
        
    }
    public  static Manager getManager(){
       
        return ManagerHelper.mydegree;
        
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
    public String getPassword() throws RemoteException{
        return this.password;
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
    public void setAccount(double account) throws RemoteException{
        this.account = account;
    }
    @Override
    public void setPercent(double percent) throws RemoteException{
        this.percent = percent;
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
    public void setPassword(String password) throws RemoteException{
        this.password = password;
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
