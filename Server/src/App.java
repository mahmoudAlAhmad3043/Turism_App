
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mahmoud
 */
public class App extends UnicastRemoteObject implements AppInterface {

    ArrayList<ClientInterface> clients;
    Connection con;
    Statement st;

    public App() throws RemoteException, ClassNotFoundException, SQLException {
        super();
        clients = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:turizm_db.db");
        st = con.createStatement();
    }

    @Override
    public int createPhotogragher(String firstName, String secondName, double account, double percent, ClientInterface c) throws RemoteException {
        String sql = "INSERT INTO photographer (first_name, second_name, account, percent)\n"
                + "SELECT '" + firstName + "', '" + secondName + "'," + account + "," + percent + " WHERE NOT EXISTS (\n"
                + "  SELECT 1 FROM photographer \n"
                + "  WHERE first_name = '" + firstName + "' AND second_name = '" + secondName + "');";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result1 > 0) {
            System.out.println("Create Photographer Successfully");

        } else {
            System.out.println("Failed create photographer");
        }

        return result1;

    }

    @Override
    public int createTourGuide(TourGuidesInterface tourGuide) throws RemoteException {
        String sql = "INSERT INTO tour_guides (first_name, second_name, account, percent)\n"
                + "SELECT '" + tourGuide.getFirstName() + "', '" + tourGuide.getSecondName() + "'," + tourGuide.getAccount() + "," + tourGuide.getPercent() + " WHERE NOT EXISTS (\n"
                + "  SELECT 1 FROM tour_guides \n"
                + "  WHERE first_name = '" + tourGuide.getFirstName() + "' AND second_name = '" + tourGuide.getSecondName() + "');";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result1 > 0) {
            System.out.println("Tour guide created successfully");

        } else {
            System.out.println("Tour guide could not be created");
        }

        return result1;
    }

    @Override
    public int SignUp(String firstName, String secondName, String password, double account, double percent, String oldPassword, ClientInterface c) throws RemoteException {
        String sql1 = "UPDATE manager SET first_name = '" + firstName + "', second_name = '" + secondName + "', password = '" + password + "', percent = " + percent + " WHERE manager_id = 1 AND password = '" + oldPassword + "';";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result1 > 0) {
            addClient(c);
            System.out.println("Sign Up Successfully");

        } else {
            System.out.println("Registration failed");
        }

        return result1;

    }

    @Override
    public int Login(String firstName, String password, ClientInterface c) throws RemoteException {
        String sql = "select first_name,second_name,password,account,percent from manager where manager_id=1;";
        ResultSet res;
        boolean a1 = false, a2 = false;
        String secondName = "";
        double account = 0, percent = 0;
        try {
            res = st.executeQuery(sql);
            while (res.next()) {
                a1 = password.equals(res.getString("password"));
                a2 = firstName.equals(res.getString("first_name"));
                account = res.getDouble("account");
                percent = res.getDouble("percent");
                secondName = res.getString("second_name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (a1 && a2) {
            addClient(c);
            c.recieveManager(firstName, secondName, account, percent);
            return 1;
        } //firstName and password
        else if (a1 && !a2) {
            return 2;   //!firstName
        } else if (!a1 && a2) {
            return 3;   //!password
        } else {
            return 0;                 //!firstName and !passowrd  
        }
    }

    @Override
    public boolean deletePhotographer(PhotogragherInterface ph) throws RemoteException {
        String sql = "delete from photographer where ph_id = " + ph.getId() + " ;";
        int result = 0;
        try {
            result = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTourGuide(TourGuidesInterface tourGuide) throws RemoteException {
        String sql = "delete from tour_guides where tour_id = " + tourGuide.getId() + " ;";
        int result = 0;
        try {
            result = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void sendMessageToAll(String message) throws RemoteException {
        for (ClientInterface c : clients) {
            c.reciveMessage(message);
        }
    }

    @Override
    public void createSaleProcess(PhotogragherInterface photoghragher, TourGuidesInterface tourGuide, double price) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSaleProcess(int process_id, PhotogragherInterface photoghragher, TourGuidesInterface tourGuide, double price) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editeSaleProcess(int process_id, PhotogragherInterface photoghragher, TourGuidesInterface tourGuide, double price) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendAllPhotograghers(ArrayList<PhotogragherInterface> photograghers) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendAllTourGuides(ArrayList<TourGuidesInterface> tourGuides) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendManager(String firstName, String secondName, double account, double percent) throws RemoteException {
        for (ClientInterface c : clients) {
            c.recieveManager(firstName, secondName, account, percent);
        }
    }

    @Override
    public void logout(ClientInterface c) throws RemoteException {
        System.out.println("befor logout: " + clients.size());
        clients.remove(c);
        System.out.println("after logout: " + clients.size());
    }

    @Override
    public void addClient(ClientInterface c) throws RemoteException {
        System.out.println("befor add: " + clients.size());
        clients.add(c);
        System.out.println("after add: " + clients.size());
    }

    @Override
    public ArrayList<PhotogragherInterface> sendAllPhotographers() throws RemoteException {
        ResultSet res;
        String sql = "SELECT * from photographer";
        ArrayList<PhotogragherInterface> photographers = new ArrayList<>();
        try {
            res = st.executeQuery(sql);
            while (res.next()) {
                PhotogragherInterface ph = new Photogragher(res.getString("first_name"), res.getString("second_name"), res.getDouble("account"), res.getDouble("percent"), res.getInt("ph_id"));
                photographers.add(ph);
            }

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return photographers;
    }

    @Override
    public void sendPhotographerId(PhotogragherInterface ph, int selectedIndex) throws RemoteException {
        for (ClientInterface c : clients) {
//            c.reciveIdPhotographer(ph,selectedIndex);
            c.reciveMessage("Management deleted the photographer " + ph.getFirstName() + " " + ph.getSecondName());
        }
    }

    @Override
    public int updatePhotographer(PhotogragherInterface photographer) throws RemoteException {
        String sql1 = "UPDATE photographer SET first_name = '" + photographer.getFirstName() + "', second_name = '" + photographer.getSecondName() + "', percent = " + photographer.getPercent() + ",account =  " + photographer.getAccount() + " where ph_id = " + photographer.getId() + " ;";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
//            if(result1 > 0){
//                    this.sendMessageToAll("update photographer successfully");
//            }
//            else{
//                this.sendMessageToAll("update photographer failed");
//            } 

        return result1;
    }

    @Override
    public void refreshPhotographers(ArrayList<PhotogragherInterface> phs) throws RemoteException {
        for (ClientInterface c : clients) {
            c.recivePhotographers(phs);
        }
    }

    @Override
    public int withDrowAccountPhotographer(PhotogragherInterface ph, double ammount) throws RemoteException {
        String sql = "update photographer set account = " + ph.getAccount() + " where ph_id = " + ph.getId() + ";";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result1 > 0) {
            this.sendMessageToAll("withdraw ammount " + ammount + " from " + ph.getFirstName() + " account successfully.");
        } else {
            this.sendMessageToAll("withdraw ammount " + ammount + " from " + ph.getFirstName() + " account failed.");
        }

        return result1;
    }

    @Override
    public void refreshGuides(ArrayList<TourGuidesInterface> gus) throws RemoteException {
        for (ClientInterface c : clients) {
            c.reciveGuides(gus);
        }
    }

    @Override
    public ArrayList<TourGuidesInterface> sendAllGuides() throws RemoteException {
        ResultSet res;
        String sql = "SELECT * from tour_guides";
        ArrayList<TourGuidesInterface> guides = new ArrayList<>();
        try {
            res = st.executeQuery(sql);
            while (res.next()) {
                TourGuidesInterface guide = new TourGuides(res.getString("first_name"), res.getString("second_name"), res.getDouble("account"), res.getDouble("percent"), res.getInt("tour_id"));
                guides.add(guide);
            }

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return guides;
    }

    @Override
    public int withDrowAccountTourGuide(TourGuidesInterface gu, double ammount) throws RemoteException {
        String sql = "update tour_guides set account = " + gu.getAccount() + " where tour_id = " + gu.getId() + ";";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result1 > 0) {
            this.sendMessageToAll("withdraw ammount " + ammount + " from " + gu.getFirstName() + " account successfully.");
        } else {
            this.sendMessageToAll("withdraw ammount " + ammount + " from " + gu.getFirstName() + " account failed.");
        }

        return result1;
    }

    @Override
    public int updateTourGuide(TourGuidesInterface tourGudie) throws RemoteException {
        String sql1 = "UPDATE tour_guides SET first_name = '" + tourGudie.getFirstName() + "', second_name = '" + tourGudie.getSecondName() + "', percent = " + tourGudie.getPercent() + ",account =  " + tourGudie.getAccount() + " where tour_id = " + tourGudie.getId() + " ;";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
//            if(result1 > 0){
//                    this.sendMessageToAll("update tour guide successfully");
//            }
//            else{
//                this.sendMessageToAll("update tour guide failed");
//            } 

        return result1;
    }

    @Override
    public int updateManager(ManagerInterface manager) throws RemoteException {
        String sql = "UPDATE manager SET account = " + manager.getAccount() + " where first_name = '" + manager.getFirstName() + "' ;";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result1;
    }

    public int addSale(SalesInterface sale) throws RemoteException {
        String sql;
        if (sale.getTourGide() == null) {
            sql = "insert into photographer_tour (tour_id,ph_id,ammount,sale_date,tour_percent,photographer_percent,sale_time) values (" + null + "," + sale.getPhotographer().getId() + "," + sale.getPrice() + ",'" + Date.valueOf(LocalDate.now()).toString() + "'," + null + "," + sale.getPhotographer().getPercent() + ",'" + Time.valueOf(LocalTime.now()).toString() + "');";
        } else {
            sql = "insert into photographer_tour (tour_id,ph_id,ammount,sale_date,tour_percent,photographer_percent,sale_time) values (" + sale.getTourGide().getId() + "," + sale.getPhotographer().getId() + "," + sale.getPrice() + ",'" + Date.valueOf(LocalDate.now()).toString() + "'," + sale.getTourGide().getPercent() + "," + sale.getPhotographer().getPercent() + ",'" + Time.valueOf(LocalTime.now()).toString() + "');";

        }
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result1;
    }

    @Override
    public int setDollar(double dollar) throws RemoteException {
        String sql = "update coins set value = " + dollar + " where type = 'dollar';";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result1;
    }

    @Override
    public double getDollar() throws RemoteException {
        String sql = "select value from coins where type = 'dollar';";
        double dollar = 0;
        ResultSet res;
        try {
            res = st.executeQuery(sql);
            while (res.next()) {
                dollar = res.getDouble("value");
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dollar;
    }

    @Override
    public int setEuro(double euro) throws RemoteException {
        String sql = "update coins set value = " + euro + " where type = 'euro';";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result1;
    }

    @Override
    public double getEuro() throws RemoteException {
        String sql = "select value from coins where type = 'euro';";
        double euro = 0;
        ResultSet res;
        try {
            res = st.executeQuery(sql);
            while (res.next()) {
                euro = res.getDouble("value");
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return euro;
    }

    @Override
    public void sendValueCoin(double value, String type) throws RemoteException {
        for (ClientInterface c : clients) {
            c.reciveValueCoin(value, type);
        }
    }

    @Override
    public ArrayList<SalesInterface> sendAllSales() throws RemoteException {
        ResultSet res;
        String sql = "SELECT transfer_id,tour_guides.*,photographer.*,ammount,sale_date,sale_time from photographer, photographer_tour LEFT OUTER JOIN tour_guides\n"
                + "on tour_guides.tour_id = photographer_tour.tour_id  \n"
                + "where photographer.ph_id = photographer_tour.ph_id";
        ArrayList<SalesInterface> sales = new ArrayList<>();
        try {
            res = st.executeQuery(sql);
            while (res.next()) {
//                System.err.println(res.getTime("sale_date"));
                TourGuidesInterface tour = new TourGuides(res.getString(3), res.getString(4), res.getDouble(5), res.getDouble(6), res.getInt(2));
                PhotogragherInterface ph = new Photogragher(res.getString(8), res.getString(9), res.getDouble(10), res.getDouble(11), res.getInt(7));
                SalesInterface sale = new Sales(ph, tour, res.getDouble("ammount"), res.getString("sale_date"), res.getString("sale_time"), 0, 0, res.getInt("transfer_id"));
                sales.add(sale);
            }

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sales;
    }

    @Override
    public int updateSale(SalesInterface sale) throws RemoteException {
        String sql = "UPDATE photographer_tour SET ammount = " + sale.getPrice() + " ,sale_date = '" + Date.valueOf(LocalDate.now()).toString() + "' ,sale_time = '" + Time.valueOf(LocalTime.now()).toString() + "' where transfer_id = '" + sale.getId() + "' ;";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result1;
    }

    @Override
    public void refreshSales(ArrayList<SalesInterface> sales) throws RemoteException {
        for (ClientInterface c : clients) {
            c.reciveSales(sales);
        }
    }

    @Override
    public int createEditSale(int sale_id, double old_price, double new_price) throws RemoteException {
        String sql = "insert into photographer_tour_edites (transfer_id,old_ammount,new_ammount,edit_date,edit_time) values (" + sale_id + "," + old_price + "," + new_price + ",'" + Date.valueOf(LocalDate.now()).toString() + "','" + Time.valueOf(LocalTime.now()).toString() + "');";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result1;
    }

    @Override
    public int DeleteAllSales() throws RemoteException {
        String sql = "Delete from photographer_tour;";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result1;
    }

    @Override
    public int DeleteAllEditSales() throws RemoteException {
        String sql = "Delete from photographer_tour_edites;";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result1;
    }

    @Override
    public ArrayList<EditSale> getEditesSale(int id_sale) throws RemoteException {
        ArrayList<EditSale> arr = new ArrayList<>();
        try {
            ResultSet res;
            String sql = "select edit_transfer_id,old_ammount,new_ammount,edit_date,edit_time from photographer_tour_edites where transfer_id = " + id_sale + ";";
            res = st.executeQuery(sql);
            while (res.next()) {
//                System.out.println(res.getTime("edit_date"));
                EditSale edits = new EditSale(id_sale, res.getDouble("old_ammount"), res.getDouble("new_ammount"), res.getString("edit_date"), res.getString("edit_time"));
                arr.add(edits);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    @Override
    public ArrayList<Outlay> sendOutlay() throws RemoteException {
        ResultSet res;
        ArrayList<Outlay> arr = new ArrayList<>();
        String sql = "select outlay_id,outlay_desc,ammount,outlay_date,outlay_time from outlay;";
        try {
            res = st.executeQuery(sql);
            while (res.next()) {
                Outlay outlay = new Outlay(res.getInt("outlay_id"), res.getString("outlay_desc"), 0, null, res.getDouble("ammount"), res.getString("outlay_date"), res.getString("outlay_time"));
                arr.add(outlay);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    @Override
    public void refreshOutlay(ArrayList<Outlay> outlayList) throws RemoteException {
        for (ClientInterface c : clients) {
            c.reciveOutlayList(outlayList);
        }
    }

    @Override
    public int addOutlay(Outlay outlay) throws RemoteException {
        String sql = "insert into outlay (ammount,outlay_desc,outlay_date,outlay_time) values ("+outlay.getAmmount()+",'"+outlay.getDescription()+"','"+Date.valueOf(LocalDate.now()).toString()+"','"+Time.valueOf(LocalTime.now()).toString()+"');";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result1;
    }

    @Override
    public int updateOutlay(Outlay outlay) throws RemoteException {
       String sql = "UPDATE outlay SET ammount = "+outlay.getAmmount()+",outlay_desc = '"+outlay.getDescription()+"',outlay_date = '"+Date.valueOf(LocalDate.now()).toString()+"',outlay_time = '"+Time.valueOf(LocalTime.now()).toString()+"' where outlay_id = "+outlay.getId()+";";
       int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result1;
    }

    @Override
    public int deleteOutlay() throws RemoteException {
        String sql = "delete from outlay ;";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result1;
    }

    @Override
    public void resetSeqSales() throws RemoteException {
        String sql = "UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='photographer_tour';";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void resetSeqEditSales() throws RemoteException {
        String sql = "UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='photographer_tour_edites';";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void resetSeqOutlay() throws RemoteException {
        String sql = "UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='outlay';";
        int result1 = 0;
        try {
            result1 = st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
