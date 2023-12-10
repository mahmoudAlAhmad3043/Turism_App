
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
public interface AppInterface extends Remote{
    public  String APP_NAME = "Turizm";
    public int createPhotogragher(String firstName , String secondName  , double account , double percent,ClientInterface c) throws RemoteException;
    public int createTourGuide(TourGuidesInterface tourGuide) throws RemoteException;
    
    public int SignUp(String firstName , String secondName , String password , double account , double percent,String oldPassword,ClientInterface c) throws RemoteException;
    public int Login(String firstName , String password,ClientInterface c) throws RemoteException;
    public void logout(ClientInterface c) throws RemoteException;
    public void addClient(ClientInterface c) throws RemoteException;
    public boolean deletePhotographer(PhotogragherInterface ph) throws RemoteException;
    public boolean deleteTourGuide(TourGuidesInterface tourGuide) throws RemoteException;
    
    public void sendMessageToAll(String message) throws RemoteException;
    
    public void createSaleProcess(PhotogragherInterface photoghragher,TourGuidesInterface tourGuide,double price) throws RemoteException;
    public void deleteSaleProcess(int process_id,PhotogragherInterface photoghragher,TourGuidesInterface tourGuide,double price) throws RemoteException;
    public void editeSaleProcess(int process_id,PhotogragherInterface photoghragher,TourGuidesInterface tourGuide,double price) throws RemoteException;
    
    public void sendAllPhotograghers(ArrayList<PhotogragherInterface> photograghers) throws RemoteException;
    public void sendAllTourGuides(ArrayList<TourGuidesInterface> tourGuides) throws RemoteException;
    public void sendManager(String firstName , String secondName , double account , double percent) throws RemoteException;
    public ArrayList<PhotogragherInterface> sendAllPhotographers() throws RemoteException;
    public void sendPhotographerId(PhotogragherInterface ph,int selectedIndex) throws  RemoteException;
    public int updatePhotographer(PhotogragherInterface photographer) throws RemoteException;
    public int updateTourGuide(TourGuidesInterface tourGudie) throws RemoteException;
    public void refreshPhotographers(ArrayList<PhotogragherInterface> phs) throws  RemoteException;
    public void refreshGuides(ArrayList<TourGuidesInterface> gus) throws  RemoteException;
    public ArrayList<TourGuidesInterface> sendAllGuides() throws RemoteException;
    public int withDrowAccountPhotographer(PhotogragherInterface ph,double ammount) throws RemoteException;
    public int withDrowAccountTourGuide(TourGuidesInterface gu,double ammount) throws RemoteException;
    public int updateManager(ManagerInterface manager) throws RemoteException;
    public int addSale(SalesInterface sale) throws RemoteException;
    public int setDollar(double dollar) throws RemoteException;
    public double getDollar() throws RemoteException;
    public int setEuro(double euro) throws RemoteException;
    public double getEuro() throws RemoteException;
    public void sendValueCoin(double value,String type) throws RemoteException;
    public ArrayList<SalesInterface> sendAllSales() throws RemoteException;
    public int updateSale(SalesInterface sale)throws RemoteException;
    public void refreshSales(ArrayList<SalesInterface> sales) throws  RemoteException;
    public int createEditSale(int sale_id,double old_price , double new_price) throws RemoteException;
    public int DeleteAllSales() throws RemoteException;
    public int DeleteAllEditSales() throws RemoteException;
    public ArrayList<EditSale> getEditesSale(int id_sale) throws RemoteException;
    public ArrayList<Outlay> sendOutlay() throws RemoteException;
    public void refreshOutlay(ArrayList<Outlay> outlayList) throws RemoteException;
    public int addOutlay(Outlay outlay) throws RemoteException;
    public int updateOutlay(Outlay outlay) throws RemoteException;
    public int deleteOutlay() throws RemoteException;
    public void resetSeqSales() throws  RemoteException;
    public void resetSeqEditSales() throws RemoteException;
    public void resetSeqOutlay() throws RemoteException;
}
