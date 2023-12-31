
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
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
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
public class DeleteGuideGUI extends javax.swing.JFrame implements ClientInterface{
    private AppInterface app;
    final DefaultListModel<String> l1 = new DefaultListModel<>(); 
    final JList<String> list1 = new JList<>(l1);
    ArrayList<TourGuidesInterface> guieds;
    int gu_id = -1;
     JLabel fNameLabel ;
     JLabel sNameLabel ;
     JLabel accountValLabel ;
     JLabel percentValLabel ;
    int selectedIndex;
    /**
     * Creates new form DeleteGuideGUI
     */
    public DeleteGuideGUI() throws RemoteException, NotBoundException {
        initComponents();
        this.setLocation(450,200);
        this.setTitle("Delete Guide");
        getTheService();
        UnicastRemoteObject.exportObject(this, 0);
        fNameLabel = new JLabel("first name        :    ----");
        sNameLabel = new JLabel("last name  :    ----");
        accountValLabel = new JLabel("account             :    0.0");
        percentValLabel = new JLabel("percentage             :    0.0");
        fNameLabel.setBounds(50,142,200,15);
        sNameLabel.setBounds(50,172,200,15);
        accountValLabel.setBounds(50,199,200,15);
        percentValLabel.setBounds(50,229,200,15);
        this.add(fNameLabel);
        this.add(sNameLabel);
        this.add(accountValLabel);
        this.add(percentValLabel);
        
        guieds =  app.sendAllGuides();
        for(TourGuidesInterface gu:guieds){
            l1.addElement(gu.getFirstName()+" "+gu.getSecondName());
        }
        app.addClient(this); 
         list1.setBounds(105,60,300,80);
        this.add(list1);
          JScrollPane scrollPane = new JScrollPane(list1);
          this.add(scrollPane);
          scrollPane.setBounds(50,40, 300, 80);
          list1.addListSelectionListener(new ListSelectionListener() {
          private boolean isEventHandled = false;
          public void valueChanged(ListSelectionEvent e) {
              if (!e.getValueIsAdjusting() && !isEventHandled ) { 
                  
                  try {
                      showInformation();
                  } catch (RemoteException ex) {
                      Logger.getLogger(DeleteGuideGUI.class.getName()).log(Level.SEVERE, null, ex);
                  }
                   
              }

          }
         });
         
          this.addWindowListener(new WindowAdapter()  {
            public void windowClosing(WindowEvent e)  {
               
                try {
                    f();
                } catch (RemoteException ex) {
                    Logger.getLogger(DeleteGuideGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    public void f() throws RemoteException{
        app.logout(this);
        System.exit(0);
    }
    private void getTheService() throws RemoteException, NotBoundException{
        PropertiesDevice pd = PropertiesDevice.getDevice();
        Registry reg = LocateRegistry.getRegistry(pd.getIp(),1099);
        app = (AppInterface) reg.lookup(AppInterface.APP_NAME);
    }
    private void showInformation() throws RemoteException{
                   selectedIndex = list1.getSelectedIndex();
                   if(selectedIndex != -1){
                   fNameLabel.setText("first name        :    "+guieds.get(selectedIndex).getFirstName());
                   sNameLabel.setText("last name  :    "+guieds.get(selectedIndex).getSecondName());
                   accountValLabel.setText("account             :    "+guieds.get(selectedIndex).getAccount()+"");
                   percentValLabel.setText("percentage             :    "+guieds.get(selectedIndex).getPercent()+"");
                   gu_id = guieds.get(selectedIndex).getId();
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

        jLabel1 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("guides:");

        deleteButton.setBackground(new java.awt.Color(0, 153, 204));
        deleteButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(0, 153, 204));
        backButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("back");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(deleteButton)
                .addGap(20, 20, 20)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        boolean result = false;
        if(gu_id == -1){
            JOptionPane.showMessageDialog(this,"selected directory not found");
        }else{
            if(selectedIndex !=-1){
                try {
                     result = app.deleteTourGuide(guieds.get(selectedIndex));//
                } catch (RemoteException ex) {
                    Logger.getLogger(DeleteGuideGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(result){
//                   l1.remove(selectedIndex);
                    try {
                        System.out.println(list1.getSelectedValue());
                        String name = list1.getSelectedValue();
                        app.refreshGuides(app.sendAllGuides());
//                        app.sendPhotographerId(photographers.get(selectedIndex),selectedIndex);
                        app.sendMessageToAll("Management deletes tour guide "+name);
                    } catch (RemoteException ex) {
                        Logger.getLogger(DeleteGuideGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                   fNameLabel.setText("---");
//                   sNameLabel.setText("---");
//                   accountValLabel.setText("0.0");
//                   percentValLabel.setText("0.0");
//                   ph_id = -1;
                }else{
                    JOptionPane.showMessageDialog(this,"Tour guide could not be deleted");
                }
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            new GuideManagementGUI().setVisible(true);
            app.logout(this);
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(DeleteGuideGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(DeleteGuideGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(DeleteGuideGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteGuideGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteGuideGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteGuideGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DeleteGuideGUI().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(DeleteGuideGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(DeleteGuideGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reciveGuides(ArrayList<TourGuidesInterface> gus) throws RemoteException {
         guieds = gus;
         l1.removeAllElements();
        for(TourGuidesInterface gu:guieds){
            l1.addElement(gu.getFirstName()+" "+gu.getSecondName());
        }
        fNameLabel.setText("first name        :    ----");
        sNameLabel.setText("last name  :    ----");
        accountValLabel.setText("account             :    0.0");
        percentValLabel.setText("percentage             :    0.0");
        gu_id = -1;
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
