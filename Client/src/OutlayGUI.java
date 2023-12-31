
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mahmoud
 */
public class OutlayGUI extends javax.swing.JFrame implements ClientInterface {

    private AppInterface app;
    DefaultTableModel model = new DefaultTableModel();
    Manager manager = Manager.getManager();
    ArrayList<Outlay> arr = new ArrayList<>();
    int selectedId = -1;
    

    /**
     * Creates new form OutlayGUI
     */
    public OutlayGUI() throws RemoteException, NotBoundException {
        initComponents();
        this.setLocation(450,200);
        this.setTitle("Outlay");
        getTheService();
        UnicastRemoteObject.exportObject(this, 0);
        jTable1.setModel(model);
       model.addColumn("id");
        model.addColumn("Amount");
        model.addColumn("Definition");
        model.addColumn("Date");
        model.addColumn("Tıme");
        accountman.setText(manager.getAccount()+"");
        name.setText(manager.getFirstName()+" "+manager.getSecondName());
        app.addClient(this);
        arr = app.sendOutlay();
        for (Outlay outlay : arr) {
            model.addRow(new Object[]{outlay.getId(), outlay.getAmmount(), outlay.getDescription(), outlay.getDate(), outlay.getTime()});
        }
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    f();
                } catch (RemoteException ex) {
                    Logger.getLogger(EditSaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    public void f() throws RemoteException {
        app.logout(this);
        System.exit(0);
    }

    private void getTheService() throws RemoteException, NotBoundException {
        PropertiesDevice pd = PropertiesDevice.getDevice();
        Registry reg = LocateRegistry.getRegistry(pd.getIp(),1099);
        app = (AppInterface) reg.lookup(AppInterface.APP_NAME);
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
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        accountman = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setText("Amount:");

        jLabel2.setText("Description:");

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 204));
        jButton2.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Delete everything");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 204));
        jButton4.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 204));
        jButton5.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Manager:");

        name.setText("name");

        jLabel5.setText("Account :");

        accountman.setText("account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(jTextField2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(name))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(accountman)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(accountman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String ammountStr = jTextField2.getText();
        String descStr = jTextArea1.getText();
        boolean b = true;
        double ammount = 0;
        double accountManager = 0;
        try {
            accountManager = manager.getAccount();
        } catch (RemoteException ex) {
            Logger.getLogger(OutlayGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ammountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "please enter your value");
            b = false;
        } else {
            try {
                ammount = Double.parseDouble(ammountStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "your value incurrect");
                b = false;
            }
        }
        if (b) {
            if (ammount < 0) {
                JOptionPane.showMessageDialog(this, "your value incurrect");
            } else if (ammount > accountManager) {
                JOptionPane.showMessageDialog(this, "your account is smaller than your amount");
            } else {
                Outlay outlay = new Outlay(0, descStr, 0, null, ammount, null, null);
                try {
                    int res1 = app.addOutlay(outlay);
                    manager.withdraw1(ammount);
                    int res2 = app.updateManager(manager);
                    app.refreshOutlay(app.sendOutlay());
                    if (res1 * res2 > 0) {
                        app.sendMessageToAll("successfully");
                        jTextArea1.setText("");
                        jTextField2.setText("");
                    } else {
                        app.sendMessageToAll("Failed");
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(OutlayGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Outlay outlay = null;
        int selectId = jTable1.getSelectedRow();
        if (selectId < 0) {
            JOptionPane.showMessageDialog(this, "Selected item not found");
        } else {
            outlay = arr.get(selectId);
            String ammountStr = jTextField2.getText();
            String descStr = jTextArea1.getText();
            boolean b = true;
            double ammount = 0;
            double accountManager = 0;
            try {
                manager.setPercent(100);
                manager.deposit(outlay.getAmmount());
                accountManager = manager.getAccount();
            } catch (RemoteException ex) {
                Logger.getLogger(OutlayGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (ammountStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your value");
                b = false;
            } else {
                try {
                    ammount = Double.parseDouble(ammountStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "your value incurrect");
                    b = false;
                }
            }
            if (b) {
                if (ammount < 0) {
                    JOptionPane.showMessageDialog(this, "your value incurrect");
                } else if (ammount > accountManager) {
                    JOptionPane.showMessageDialog(this, "your account is smaller than your amount");
                } else {
                    outlay.setAmmount(ammount);
                    outlay.setDescription(descStr);
                    try {
                        int res1 = app.updateOutlay(outlay);
                        manager.withdraw1(ammount);
                        int res2 = app.updateManager(manager);
                        app.refreshOutlay(app.sendOutlay());
                        if (res1 * res2 > 0) {
                            app.sendMessageToAll("successfully");
                            jTextArea1.setText("");
                            jTextField2.setText("");
                        } else {
                            app.sendMessageToAll("Failed");
                        }
                    } catch (RemoteException ex) {
                        Logger.getLogger(OutlayGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Outlay outlay = null;
        int selectId = jTable1.getSelectedRow();
        outlay = arr.get(selectId);
        jTextField2.setText(outlay.getAmmount() + "");
        jTextArea1.setText(outlay.getDescription());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            int res = app.deleteOutlay();
            app.resetSeqOutlay();
            app.refreshOutlay(app.sendOutlay());
            if(res > 0){
                app.sendMessageToAll("Delete, Successfully");
            }else{
                app.sendMessageToAll("Delete , Failed");
            }
            
        } catch (RemoteException ex) {
            Logger.getLogger(OutlayGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            jTable1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(OutlayGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            new ManagementGUI().setVisible(true);
            app.logout(this);
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(OutlayGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(OutlayGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(OutlayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OutlayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OutlayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OutlayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new OutlayGUI().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(OutlayGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(OutlayGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountman;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables

    @Override
    public void recieveManager(String firstName, String secondName, double account, double percent) throws RemoteException {
        manager.setAccount(account);
        manager.setFirstName(firstName);
        manager.setPercent(percent);
        manager.setSecondName(secondName);
        accountman.setText(manager.getAccount()+"");
        name.setText(manager.getFirstName()+" "+manager.getSecondName());
    }

    @Override
    public void reciveIdPhotographer(PhotogragherInterface ph, int selectedIndex) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reciveMessage(String message) throws RemoteException {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this, message);
        });
    }

    @Override
    public void recivePhotographers(ArrayList<PhotogragherInterface> phs) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reciveGuides(ArrayList<TourGuidesInterface> gus) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        DefaultTableModel model = new DefaultTableModel();
        jTable1.setModel(model);
        model.addColumn("id");
        model.addColumn("Amount");
        model.addColumn("Definition");
        model.addColumn("Date");
        model.addColumn("Time");
        for (Outlay outlay : outlayList) {
            model.addRow(new Object[]{outlay.getId(), outlay.getAmmount(), outlay.getDescription(), outlay.getDate(), outlay.getTime()});
        }
        accountman.setText(manager.getAccount()+"");
        name.setText(manager.getFirstName()+" "+manager.getSecondName());
        arr = outlayList;
    }
}
