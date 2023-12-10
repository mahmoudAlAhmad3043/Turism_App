
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahmoud
 */
public interface ClientInterface extends Remote{
        public void recieveManager(String firstName , String secondName , double account , double percent) throws RemoteException;
        public void reciveIdPhotographer(PhotogragherInterface ph,int selectedIndex) throws RemoteException;
        public void reciveMessage(String message) throws RemoteException;
        public void recivePhotographers(ArrayList<PhotogragherInterface> phs) throws RemoteException;
        public void reciveGuides(ArrayList<TourGuidesInterface> gus) throws RemoteException;
        public void reciveValueCoin(double value,String type) throws RemoteException;
        public void reciveSales(ArrayList<SalesInterface> sales) throws RemoteException;
        public void reciveOutlayList(ArrayList<Outlay> outlayList) throws RemoteException;
}
