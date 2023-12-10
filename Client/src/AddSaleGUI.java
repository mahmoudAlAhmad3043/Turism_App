
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahmoud
 */
public class AddSaleGUI extends javax.swing.JFrame implements ClientInterface{
    private AppInterface app;
    final DefaultListModel<String> l1 = new DefaultListModel<>(); 
    final JList<String> list1 = new JList<>(l1);
    ArrayList<PhotogragherInterface> photographers;
    final DefaultListModel<String> l2 = new DefaultListModel<>(); 
    final JList<String> list2 = new JList<>(l2);
    ArrayList<TourGuidesInterface> tourGuides;
    int selectedIndex1 = -1;
    int ph_id = -1;
    int selectedIndex2 = -1;
    int gu_id = -1;
    boolean notTour = false;
    
    /**
     * Creates new form AddSaleGUI
     */
    public AddSaleGUI() throws RemoteException, NotBoundException {
        initComponents();  
        this.setLocation(350,20);
        this.setTitle("Adding Sale");
        getTheService();
        UnicastRemoteObject.exportObject(this, 0);
        photographers =  app.sendAllPhotographers();
        for(PhotogragherInterface ph:photographers){
            l1.addElement(ph.getFirstName()+" "+ph.getSecondName());
        }
        app.addClient(this);    
        this.add(list1);
          JScrollPane scrollPane = new JScrollPane(list1);
          this.add(scrollPane);
          scrollPane.setBounds(20,40, 300, 100);
          list1.addListSelectionListener(new ListSelectionListener() {
          private boolean isEventHandled = false;
          public void valueChanged(ListSelectionEvent e) {
              if (!e.getValueIsAdjusting() && !isEventHandled ) { 
                 
                  try {
                      showInformationPhotographers();
                  } catch (RemoteException ex) {
                      Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
              }

          }
         });
          
        tourGuides =  app.sendAllGuides();
        for(TourGuidesInterface gu:tourGuides){
            l2.addElement(gu.getFirstName()+" "+gu.getSecondName());
        }
        this.add(list2);
          JScrollPane scrollPane2 = new JScrollPane(list2);
          this.add(scrollPane2);
          scrollPane2.setBounds(330,40, 300, 100);
          list2.addListSelectionListener(new ListSelectionListener() {
          private boolean isEventHandled = false;
          public void valueChanged(ListSelectionEvent e) {
              if (!e.getValueIsAdjusting() && !isEventHandled ) { 
                  
                  try {
                      showInformationGides();
                  } catch (RemoteException ex) {
                      Logger.getLogger(GuidesGUI.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
              }

          }
         });
          
          this.addWindowListener(new WindowAdapter()  {
            public void windowClosing(WindowEvent e)  {
                
                try {
                    f();
                } catch (RemoteException ex) {
                    Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
          
          ph_name_label.setText("-");
          ph_salary_label.setText("-");
          tour_name_label.setText("-");
          tour_salary_label.setText("-");
          manager_name_label.setText("-");
          manager_salary_label.setText("-");
          date_label.setText("-");
          ph_acc_input.setText("0.0");
          tour_acc_input.setText("0.0");
    }
    private void getTheService() throws RemoteException, NotBoundException{
        PropertiesDevice pd = PropertiesDevice.getDevice();
        Registry reg = LocateRegistry.getRegistry(pd.getIp(),1099);
        app = (AppInterface) reg.lookup(AppInterface.APP_NAME);
    }
    public void f() throws RemoteException{
        app.logout(this);
        System.exit(0);
    }
    
    private void showInformationPhotographers() throws RemoteException{
                   selectedIndex1 = list1.getSelectedIndex();
                   if(selectedIndex1 != -1){
                   ph_fname_input.setText(photographers.get(selectedIndex1).getFirstName());
                   ph_sname_input.setText(photographers.get(selectedIndex1).getSecondName());
                   ph_acc_input.setText(photographers.get(selectedIndex1).getAccount()+"");
                   ph_percent_input.setText(photographers.get(selectedIndex1).getPercent()+"");
                   ph_id = photographers.get(selectedIndex1).getId();
                   }
    }
    
     private void showInformationGides() throws RemoteException{
                   selectedIndex2 = list2.getSelectedIndex();
                   if(selectedIndex2 != -1){
                   tour_fname_input.setText(tourGuides.get(selectedIndex2).getFirstName());
                   tour_sname_input.setText(tourGuides.get(selectedIndex2).getSecondName());
                   tour_acc_input.setText(tourGuides.get(selectedIndex2).getAccount()+"");
                   tour_percent_input.setText(tourGuides.get(selectedIndex2).getPercent()+"");
                   gu_id = tourGuides.get(selectedIndex2).getId();
                   }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ph_fname_input = new javax.swing.JTextField();
        ph_sname_input = new javax.swing.JTextField();
        ph_percent_input = new javax.swing.JTextField();
        ph_acc_input = new javax.swing.JTextField();
        tour_fname_input = new javax.swing.JTextField();
        tour_sname_input = new javax.swing.JTextField();
        tour_percent_input = new javax.swing.JTextField();
        tour_acc_input = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        price_input = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        unitPrice = new javax.swing.JComboBox();
        applyButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ph_name_label = new javax.swing.JLabel();
        tour_name_label = new javax.swing.JLabel();
        manager_name_label = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();
        ph_salary_label = new javax.swing.JLabel();
        tour_salary_label = new javax.swing.JLabel();
        manager_salary_label = new javax.swing.JLabel();
        notTourGuide = new javax.swing.JCheckBox();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("first name:");

        jLabel2.setText("last name:");

        jLabel3.setText("percentage:");

        jLabel4.setText("account :");

        jLabel5.setText("first name:");

        jLabel6.setText("last name:");

        jLabel7.setText("percentage:");

        jLabel8.setText("account :");

        ph_acc_input.setEnabled(false);

        tour_acc_input.setEnabled(false);

        jLabel9.setText("photographers:");

        jLabel10.setText("tour guides :");

        jLabel11.setText("price :");

        unitPrice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Turky", "$", "€" }));
        unitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitPriceActionPerformed(evt);
            }
        });

        applyButton.setBackground(new java.awt.Color(0, 153, 204));
        applyButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        applyButton.setForeground(new java.awt.Color(255, 255, 255));
        applyButton.setText("apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        jLabel13.setText("Photographer");

        jLabel14.setText("A tour guide");

        jLabel15.setText("manager");

        backButton.setBackground(new java.awt.Color(0, 153, 204));
        backButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel16.setText("tarih");

        jLabel17.setText("name");

        jLabel18.setText("salary");

        ph_name_label.setText("ph_name_label");

        tour_name_label.setText("tour_name_label");

        manager_name_label.setText("manager_name_label");

        date_label.setText("date");

        ph_salary_label.setText("ph_salary_label");

        tour_salary_label.setText("tour_salary_label");

        manager_salary_label.setText("manager_salary_label");

        notTourGuide.setText("not found tour guide");
        notTourGuide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notTourGuideActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ph_fname_input, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                            .addComponent(ph_sname_input)
                                            .addComponent(ph_percent_input)
                                            .addComponent(ph_acc_input)))
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(49, 49, 49)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tour_fname_input)
                                            .addComponent(tour_sname_input)
                                            .addComponent(tour_percent_input)
                                            .addComponent(tour_acc_input, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel10)
                                    .addComponent(notTourGuide)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(price_input, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(unitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(date_label)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ph_name_label)
                                            .addComponent(tour_name_label)
                                            .addComponent(manager_name_label)
                                            .addComponent(jLabel17))
                                        .addGap(116, 116, 116)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(manager_salary_label)
                                            .addComponent(tour_salary_label)
                                            .addComponent(ph_salary_label)
                                            .addComponent(jLabel18))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ph_fname_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ph_sname_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ph_percent_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ph_acc_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tour_fname_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tour_sname_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tour_percent_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tour_acc_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addComponent(notTourGuide)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(unitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(applyButton)
                .addGap(13, 13, 13)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(ph_name_label)
                    .addComponent(ph_salary_label))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tour_name_label)
                    .addComponent(tour_salary_label))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(manager_name_label)
                    .addComponent(manager_salary_label))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(jLabel16)
                    .addComponent(date_label))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        // TODO add your handling code here:
        Double priceNum  = 0.0 ;
        Double tuPercentNum  =0.0 ;
        Double phPercentNum = 0.0;
        double salaryTour = 0;
        double salaryPhoto = 0;
        double salaryManager = 0;
        PhotogragherInterface newPhotographer = null;
        TourGuidesInterface newTourGuide = null;
        boolean s = false;
        if(tour_percent_input.getText().isEmpty() && !notTour) {
            JOptionPane.showMessageDialog(this,"Percent tour guide empty");
            s=true;
        }
        else if(!notTour){
            try{
                tuPercentNum = Double.parseDouble(tour_percent_input.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"The tour guide percentage is wrong");
            s = true;
        }
        }
        
        if(price_input.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"price is empty");
            s = true;
        }
        else{
            try{
                priceNum = Double.parseDouble(price_input.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"your price incorrect");
            s = true;
        }
        }
        
        if(ph_percent_input.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"your price incorrect");
            s = true;
        }
        else{
            try{
                phPercentNum = Double.parseDouble(ph_percent_input.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"photographer's percentage incurrect");
            s = true;
        }
        }
        if(!s){
        if(priceNum <=0 || priceNum.isNaN()){
            JOptionPane.showMessageDialog(this,"your price incurrect");
        }else if(ph_fname_input.getText().isEmpty() || ph_sname_input.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Photographer name is empty");
        }else if((tour_fname_input.getText().isEmpty() || tour_sname_input.getText().isEmpty() || tour_percent_input.getText().isEmpty()) && !notTour){
            JOptionPane.showMessageDialog(this,"Tour guide specifications incurrect");
        }else if((tuPercentNum <0 || tuPercentNum >100 || tuPercentNum.isNaN()) && !notTour){
            JOptionPane.showMessageDialog(this,"tour guide percentage incurrect");
        }else if(phPercentNum <0 || phPercentNum >100 || phPercentNum.isNaN()){
            JOptionPane.showMessageDialog(this,"photographer's percentage incurrect");
        }else if((tuPercentNum + phPercentNum) >=100){
            JOptionPane.showMessageDialog(this,"sum total is incurrect");
        }
        else{
            
            int unitType = unitPrice.getSelectedIndex();
            String ph_fname = ph_fname_input.getText();
            String ph_sname = ph_sname_input.getText();
            SalesInterface sale;
            double dollar = 0;
            double euro = 0 ;
            try {
                dollar = app.getDollar();
            } catch (RemoteException ex) {
                Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                euro = app.getEuro();
            } catch (RemoteException ex) {
                Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            sale = new Sales(null, null,0, null, null, dollar, euro,0);
            try {
                sale.setPrice(priceNum,unitType);
            } catch (RemoteException ex) {
                Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!notTour){
                String tg_fname = tour_fname_input.getText();
                String tg_sname = tour_sname_input.getText();
                
                if(gu_id == -1){
                    try {
                        newTourGuide = new TourGuides(tg_fname, tg_sname,0.0,tuPercentNum,0);
                        salaryTour = newTourGuide.deposit(sale.getPrice());
                        int res = app.createTourGuide(newTourGuide);
                        if(res > 0) {
                            app.refreshGuides(app.sendAllGuides());
                            tour_acc_input.setText(newTourGuide.getAccount()+"");
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    newTourGuide = tourGuides.get(selectedIndex2);
                    try {
                         salaryTour = newTourGuide.deposit(sale.getPrice());
                         int rest = app.updateTourGuide(newTourGuide);
                        tour_acc_input.setText(newTourGuide.getAccount()+"");
                    } catch (RemoteException ex) {
                        Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
                if(ph_id == -1){
                    try {
                        newPhotographer = new Photogragher(ph_fname, ph_sname,0.0,phPercentNum,0);
                         salaryPhoto = newPhotographer.deposit(sale.getPrice());
                        int res =  app.createPhotogragher(newPhotographer.getFirstName(),newPhotographer.getSecondName(),newPhotographer.getAccount(),newPhotographer.getPercent(), this);
                        if(res > 0){
                             app.sendMessageToAll("Create photographer "+ph_fname+" "+ph_sname+" successfully");
                             app.refreshPhotographers(app.sendAllPhotographers());
                             ph_acc_input.setText(newPhotographer.getAccount()+"");
                        }else{
                            app.sendMessageToAll("photographer "+ph_fname+" "+ph_sname+" Existing");
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else{
                    newPhotographer = photographers.get(selectedIndex1);
                try {
                   salaryPhoto = newPhotographer.deposit(sale.getPrice());
                   ph_acc_input.setText(newPhotographer.getAccount()+"");
                } catch (RemoteException ex) {
                    Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                    try {
                        int res2 = app.updatePhotographer(newPhotographer);
                        
                    } catch (RemoteException ex) {
                        Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            try {
                //here update manager
               Manager.getManager().setPercent(100 - phPercentNum - tuPercentNum);
               salaryManager =  Manager.getManager().deposit(sale.getPrice());
                System.out.println(salaryManager);
                int res = app.updateManager(Manager.getManager());
                if(res > 0){
                    sale.setPhotographer(newPhotographer);
                    sale.setTourGuide(newTourGuide);
                    String date = Date.valueOf(LocalDate.now()).toString();
                    String time  = Time.valueOf(LocalTime.now()).toString();
                    sale.setDate(date);
                    sale.setTime(time);
                    ph_name_label.setText(newPhotographer.getFirstName()+" "+newPhotographer.getSecondName());
                    ph_salary_label.setText(salaryPhoto+"");
                    if(!notTour){
                        tour_name_label.setText(newTourGuide.getFirstName()+" "+newTourGuide.getSecondName());
                        tour_salary_label.setText(salaryTour+"");
                    }else{
                        tour_name_label.setText("--");
                        tour_salary_label.setText("--");
                    }
                    manager_name_label.setText(Manager.getManager().getFirstName()+" "+Manager.getManager().getSecondName());
                    manager_salary_label.setText(salaryManager+"");
                    date_label.setText(date+"         "+time);
//                    if(sale.getTourGide() == null)
//                        sale.setTourGuide(new TourGuides(null,null,0,0,-1));
                    int res1 = app.addSale(sale);
                    if(res1>0){
                        app.sendMessageToAll("successfully");
                    }else{
                        app.sendMessageToAll("Failed");
                    }
                }else{
                    app.sendMessageToAll("sale failed");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }//GEN-LAST:event_applyButtonActionPerformed

    private void notTourGuideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notTourGuideActionPerformed
        // TODO add your handling code here:
        if(notTourGuide.isSelected()){
          notTour = true;
          tour_fname_input.setText("");
          tour_sname_input.setText("");
          tour_percent_input.setText("");
          tour_acc_input.setText("0.0");
        }else{
            notTour = false;
        }
    }//GEN-LAST:event_notTourGuideActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try {
            // TODO add your handling code here:
            new SalesManagementGUI().setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            app.logout(this);
        } catch (RemoteException ex) {
            Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddSaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddSaleGUI().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(AddSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel date_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel manager_name_label;
    private javax.swing.JLabel manager_salary_label;
    private javax.swing.JCheckBox notTourGuide;
    private javax.swing.JTextField ph_acc_input;
    private javax.swing.JTextField ph_fname_input;
    private javax.swing.JLabel ph_name_label;
    private javax.swing.JTextField ph_percent_input;
    private javax.swing.JLabel ph_salary_label;
    private javax.swing.JTextField ph_sname_input;
    private javax.swing.JTextField price_input;
    private javax.swing.JTextField tour_acc_input;
    private javax.swing.JTextField tour_fname_input;
    private javax.swing.JLabel tour_name_label;
    private javax.swing.JTextField tour_percent_input;
    private javax.swing.JLabel tour_salary_label;
    private javax.swing.JTextField tour_sname_input;
    private javax.swing.JComboBox unitPrice;
    // End of variables declaration//GEN-END:variables

    @Override
    public void recieveManager(String firstName, String secondName, double account, double percent) throws RemoteException {
        Manager manager = Manager.getManager();
        manager.setAccount(account);
        manager.setPercent(percent);
        manager.setFirstName(firstName);
        manager.setSecondName(secondName);
    }

    @Override
    public void reciveIdPhotographer(PhotogragherInterface ph, int selectedIndex) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reciveMessage(String message) throws RemoteException {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this,message);
        });
    }

    @Override
    public void recivePhotographers(ArrayList<PhotogragherInterface> phs) throws RemoteException {
        photographers = phs;
         l1.removeAllElements();
        for(PhotogragherInterface ph:photographers){
            l1.addElement(ph.getFirstName()+" "+ph.getSecondName());
        }
        selectedIndex1 = -1;
    }

    @Override
    public void reciveGuides(ArrayList<TourGuidesInterface> gus) throws RemoteException {
        tourGuides = gus;
        l2.removeAllElements();
        for(TourGuidesInterface tu:tourGuides){
            l1.addElement(tu.getFirstName()+" "+tu.getSecondName());
        }
        selectedIndex2 = -1;
    }

    @Override
    public void reciveValueCoin(double value, String type) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reciveSales(ArrayList<SalesInterface> sales) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reciveOutlayList(ArrayList<Outlay> outlayList) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
