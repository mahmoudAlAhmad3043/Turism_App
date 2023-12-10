
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
public class PropertiesDevice {
    private String ip;
    private int id;
    private PhotogragherInterface photographer;
    private TourGuidesInterface guide;
    private double dollar;
    private double euro;
    private SalesInterface sale;
    private static class DeviseHelper{
        private static final PropertiesDevice device = new PropertiesDevice();
    }
    public  static PropertiesDevice getDevice(){
       
        return DeviseHelper.device;
        
    }
    private PropertiesDevice() {
    }
    public String getIp(){
        return this.ip;
    }
    public void setIp(String ip){
        this.ip = ip;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public PhotogragherInterface getPhotogragher(){
        return photographer;
    }
    public void setPhotogragher(PhotogragherInterface photographer){
        this.photographer = photographer;
    }
    
    public TourGuidesInterface getTourGuide(){
        return guide;
    }
    public void setTourGuide(TourGuidesInterface guide){
        this.guide = guide;
    }

    public double getDollar() {
        return dollar;
    }

    public double getEuro() {
        return euro;
    }

    public void setDollar(double dollar) {
        this.dollar = dollar;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    public SalesInterface getSale() {
        return sale;
    }

    public void setSale(SalesInterface sale) {
        this.sale = sale;
    }
    
}
