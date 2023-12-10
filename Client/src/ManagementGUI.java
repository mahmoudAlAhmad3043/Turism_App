
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahmoud
 */
public class ManagementGUI extends javax.swing.JFrame implements ClientInterface{
    private AppInterface app;
    /**
     * Creates new form ManagementGUI
     */
    public ManagementGUI() throws RemoteException, NotBoundException {
        initComponents();
        this.setLocation(450,200);
        this.setTitle("Management");
        getTheService();
        UnicastRemoteObject.exportObject(this, 0);
        app.addClient(this);
//        ManagerInterface manager = Manager.getManager();
//        System.out.println(manager.getFirstName());
        this.addWindowListener(new WindowAdapter()  {
            public void windowClosing(WindowEvent e)  {
                
                try {
                    f();
                } catch (RemoteException ex) {
                    Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photogragherDeptButton = new javax.swing.JButton();
        guideManagementButton = new javax.swing.JButton();
        slaesButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        photogragherDeptButton.setBackground(new java.awt.Color(0, 153, 204));
        photogragherDeptButton.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        photogragherDeptButton.setForeground(new java.awt.Color(255, 255, 255));
        photogragherDeptButton.setText("Photographers section");
        photogragherDeptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photogragherDeptButtonActionPerformed(evt);
            }
        });

        guideManagementButton.setBackground(new java.awt.Color(0, 153, 204));
        guideManagementButton.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        guideManagementButton.setForeground(new java.awt.Color(255, 255, 255));
        guideManagementButton.setText("Tour guide section");
        guideManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guideManagementButtonActionPerformed(evt);
            }
        });

        slaesButton.setBackground(new java.awt.Color(0, 153, 204));
        slaesButton.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        slaesButton.setForeground(new java.awt.Color(255, 255, 255));
        slaesButton.setText("Sales department");
        slaesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slaesButtonActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 204));
        jButton4.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Workers section");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 204));
        jButton5.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Settings");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(255, 0, 0));
        logoutButton.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Log out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Expenses department");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(photogragherDeptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guideManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(slaesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(logoutButton)
                        .addGap(69, 69, 69)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(photogragherDeptButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guideManagementButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(slaesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutButton)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        try {
            // TODO add your handling code here:
            new HomeGUI().setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            app.logout(this);
        } catch (RemoteException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void photogragherDeptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photogragherDeptButtonActionPerformed
        try {
            // TODO add your handling code here:
            new PhotogragherManagementGUI().setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            app.logout(this);
        } catch (RemoteException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_photogragherDeptButtonActionPerformed

    private void guideManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guideManagementButtonActionPerformed
        try {
            new GuideManagementGUI().setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            app.logout(this);
        } catch (RemoteException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
                      
    }//GEN-LAST:event_guideManagementButtonActionPerformed

    private void slaesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slaesButtonActionPerformed
        try {
            // TODO add your handling code here:
            new SalesManagementGUI().setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            app.logout(this);
        } catch (RemoteException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_slaesButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            new SettingsGUI().setVisible(true);
            app.logout(this);
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            new OutlayGUI().setVisible(true);
            app.logout(this);
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])  {
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
            java.util.logging.Logger.getLogger(ManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManagementGUI().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guideManagementButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton photogragherDeptButton;
    private javax.swing.JButton slaesButton;
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
   public void reciveIdPhotographer(PhotogragherInterface ph,int selectedIndex) throws RemoteException {        
        SwingUtilities.invokeLater(() -> {
           
            try {
                JOptionPane.showMessageDialog(this, "The management delete the photographer "+ph.getFirstName()+" "+ph.getSecondName());
            } catch (RemoteException ex) {
                Logger.getLogger(ManagementGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }
   
   @Override
    public void reciveMessage(String message) throws RemoteException {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this,message);
        });
    }

    @Override
    public void recivePhotographers(ArrayList<PhotogragherInterface> phs) throws RemoteException {
    }

    @Override
    public void reciveGuides(ArrayList<TourGuidesInterface> gus) throws RemoteException {
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