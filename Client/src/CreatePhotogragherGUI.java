
import java.awt.JobAttributes;
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
public class CreatePhotogragherGUI extends javax.swing.JFrame implements ClientInterface{
    private AppInterface app;
    /**
     * Creates new form CreatePhotogragherGUI
     */
    public CreatePhotogragherGUI() throws RemoteException, NotBoundException {
        initComponents();
        this.setLocation(450,200);
        this.setTitle("Creating Photographer");
        getTheService();
        UnicastRemoteObject.exportObject(this, 0);
        app.addClient(this);
        percentInput.setText("0.0");
        this.addWindowListener(new WindowAdapter()  {
            public void windowClosing(WindowEvent e)  {
                try {
                    f();
                } catch (RemoteException ex) {
                    Logger.getLogger(CreatePhotogragherGUI.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        secondNameLabel = new javax.swing.JLabel();
        percentLabel = new javax.swing.JLabel();
        firstNameInput = new javax.swing.JTextField();
        secondNameInput = new javax.swing.JTextField();
        percentInput = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

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

        jLabel1.setText("create photographer");

        firstNameLabel.setText("first name");

        secondNameLabel.setText("last name:");

        percentLabel.setText("percentage :");

        createButton.setBackground(new java.awt.Color(0, 153, 204));
        createButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        createButton.setForeground(new java.awt.Color(255, 255, 255));
        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(0, 153, 204));
        backButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(secondNameLabel)
                            .addComponent(percentLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(secondNameInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(firstNameInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(percentInput, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(createButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(secondNameLabel)
                    .addComponent(secondNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percentLabel)
                    .addComponent(percentInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(createButton)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try {
            // TODO add your handling code here:
            new PhotogragherManagementGUI().setVisible(true);
            app.logout(this);
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(CreatePhotogragherGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(CreatePhotogragherGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_backButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        String firstName;
        String secondName;
        double account = 0.0;
        double percent = 0.0;
        if(firstNameInput.getText().isEmpty() || secondNameInput.getText().isEmpty() || percentInput.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"One of the fields cannot be empty");
        }else{
            firstName = firstNameInput.getText();
            secondName = secondNameInput.getText();
            percent = Double.parseDouble(percentInput.getText());
            try {
                int result = app.createPhotogragher(firstName, secondName, account, percent, this);
                PhotogragherInterface ph = new Photogragher(firstName, secondName, account, percent,0);
                if(result > 0){
                    app.sendMessageToAll("Create photographer "+ph.getFirstName()+" "+ph.getSecondName()+" successfully");
                    app.refreshPhotographers(app.sendAllPhotographers());
//                    JOptionPane.showMessageDialog(this,"Create photographer Successfully");
                }else{
                    app.sendMessageToAll("Photographer "+ph.getFirstName()+" "+ph.getSecondName()+" Existing");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(CreatePhotogragherGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_createButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CreatePhotogragherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatePhotogragherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatePhotogragherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatePhotogragherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CreatePhotogragherGUI().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(CreatePhotogragherGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(CreatePhotogragherGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton createButton;
    private javax.swing.JTextField firstNameInput;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField percentInput;
    private javax.swing.JLabel percentLabel;
    private javax.swing.JTextField secondNameInput;
    private javax.swing.JLabel secondNameLabel;
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
                JOptionPane.showMessageDialog(this, "Management deleted the photographer "+ph.getFirstName()+" "+ph.getSecondName());
            } catch (RemoteException ex) {
                Logger.getLogger(CreatePhotogragherGUI.class.getName()).log(Level.SEVERE, null, ex);
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