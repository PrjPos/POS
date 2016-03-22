/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.ui;

import com.st.beans.MasterCustomerBean;
import com.st.core.Main;
import com.st.process.MasterCustomerProcessor;
import com.st.utils.Constants;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author Timothy_Fab
 */
public class MasterCustomerList extends javax.swing.JFrame {
 /** Customer Info column size. */
  private final int CUSTOMERINFO_COLSIZE = 4;
  /** Default table model for the Item Lookup. */
  private DefaultTableModel tm = null;
  
  /** Column Title - ID. */
  private final String COLTITLE_ID = "Kode Pelanggang#";
  /** Column Title - Name. */
  private final String COLTITLE_NAME = "Nama Pelanggang";
  /** Column Title - address. */
  private final String COLTITLE_ADDRESS = "Alamat";
  /** Column Title - phone number. */
  private final String COLTITLE_PHONE_NUMBER = "Nomor Telepon";
  
  /** Column position for Customer Info ID. */
  private final int CUSTOMER_COL_ID = 0;
  /** Column position for Customer Info Name. */
  private final int CUSTOMER_COL_NAME = 1;
  /** Column position for Customer Info Address. */
  private final int CUSTOMER_COL_ADDRESS = 2;
  /** Column position for Customer Info Phone Number. */
  private final int CUSTOMER_COL_PHONE_NUMBER = 3;
  
  MasterCustomerBean[] dataCustomer = null;
  MasterCustomerEdit CustomerEditUI = null;   
  
  /** Processor */
  private MasterCustomerProcessor proc = new MasterCustomerProcessor();
    
    /**
     * Creates new form MasterCustomerList
     */
    public MasterCustomerList() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.SearchCustomer();
    }
    
    /**
     * search data 
     */
    private void SearchCustomer()
    {     
    //Searching List Item type.
    int searchBy = cmbSearchCriteria.getSelectedIndex();
    MasterCustomerBean[] res;

    //SvrUtilities.isDebug = true;
    if(null==proc) proc = new MasterCustomerProcessor();
    System.out.println("SEARCH BY: " + searchBy);
    switch(searchBy)
    {
      case 0://Search by item id
        res = proc.getCustomerList(Constants.CUSTOMER_SEARCHBY_ID,
                            txtSearchValue.getText(),
                            null);
        break;      
      case 1://Search by item name
        res = proc.getCustomerList(Constants.CUSTOMER_SEARCHBY_NAME,
                                   txtSearchValue.getText(),
                                   null);
          
        break;
      default: 
          res = proc.getCustomerList(Constants.CUSTOMER_SEARCHBY_PHONE_NUMBER,
                                     txtSearchValue.getText(),
                                     null);
    }
        System.out.println("search");
       // System.out.println("search__res "+res[0].getId());
    dataCustomer = res;
    //Repaint the item list
     this.repaintItemTypeList(res);   
    }
    
    private void repaintItemTypeList(MasterCustomerBean[] res)
    {
        System.out.println("masuk repain");
      if(null==res || res.length<=0) return;  
       System.out.println("melewati if  repain" + res.length);
      this.resetCustomerList(res.length);
       System.out.println("melewati reset  repain");
      
     /* This is the row:
     * ID | NAME | ADDRESS | PHONE NUMBER
     */
    //Set the items into the shopping list table.
     for(int i=0; i<res.length; i++)
     {
         System.out.println("masuk for");
       tm.setValueAt(res[i].getId(), i, CUSTOMER_COL_ID);
        System.out.println("masuk for 2");
       tm.setValueAt(res[i].getName(), i, CUSTOMER_COL_NAME);
       tm.setValueAt(res[i].getAddress(), i, CUSTOMER_COL_ADDRESS);
       tm.setValueAt(res[i].getPhoneNumber(), i, CUSTOMER_COL_PHONE_NUMBER);
     }
        System.out.println("repain__");
    }
    
    /* reset Customer list  */
    private void resetCustomerList(int row)
    {
      TableColumn t;

      int COLSIZE_ID = 100;
      int COLSIZE_NAME = 300;
      int COLSIZE_ADDRESS = 400;  
      int COLSIZE_PHONE_NUMBER = 300;  
      
      tm = new DefaultTableModel(row, CUSTOMERINFO_COLSIZE);
      tm.setColumnIdentifiers(
         new String[]{
           COLTITLE_ID,
           COLTITLE_NAME,
           COLTITLE_ADDRESS,
           COLTITLE_PHONE_NUMBER
         }        
         );
         
        //Reset table to default 
        tbCustomer.setModel(tm);
        tm.setValueAt(null, 0, CUSTOMER_COL_ID);
        tm.setValueAt(null, 0, CUSTOMER_COL_NAME);
        tm.setValueAt(null, 0, CUSTOMER_COL_ADDRESS);
        tm.setValueAt(null, 0, CUSTOMER_COL_PHONE_NUMBER);
        
        t = tbCustomer.getColumn(COLTITLE_ID);
        t.setResizable(false);
        t.setMinWidth(COLSIZE_ID);
        t.setPreferredWidth(COLSIZE_ID);
        
        t = tbCustomer.getColumn(COLTITLE_NAME);
        t.setResizable(false);
        t.setMinWidth(COLSIZE_NAME);
        t.setPreferredWidth(COLSIZE_NAME);
        
        t = tbCustomer.getColumn(COLTITLE_ADDRESS);
        t.setResizable(false);
        t.setMinWidth(COLSIZE_ADDRESS);
        t.setPreferredWidth(COLSIZE_ADDRESS);
        
        t = tbCustomer.getColumn(COLTITLE_PHONE_NUMBER);
        t.setResizable(false);
        t.setMinWidth(COLSIZE_PHONE_NUMBER);
        t.setPreferredWidth(COLSIZE_PHONE_NUMBER);
        
        System.out.println("masuk reset__");
    }        
    
    /*warning Close from window*/
    private void CloseMe()
    {
     int logoutResult = JOptionPane.showConfirmDialog(
                        this,
                        "Anda yakin untuk keluar?",
                        "LogoutConfirmation",
                        JOptionPane.YES_NO_OPTION);
     if(logoutResult==JOptionPane.YES_OPTION)
     {
      //Main.callModule(Constants.MOD_HOME);
      this.finalize();
     }    
    }
    
    public void RefreshTable()
    { this.SearchCustomer(); }
    
    public void finalize()
    {
     this.resetEngine(false);
     this.setVisible(false);
    }
    
    
   public void resetEngine(boolean renew)
   {
    if(null!=proc)
    {
      proc.finalize();
      proc = null;
    }

    if(null!=dataCustomer) dataCustomer = null;

    if(renew)
    {
      //Renew the processor and the transaction bean
      proc = new MasterCustomerProcessor();
    }
  }
    
  /** Used to edit info. */
  public void editInfo(boolean action)
  {
    MasterCustomerBean bn;
    if(action)
    {
      int SelectedRow =  tbCustomer.getSelectedRow();
      bn = dataCustomer[SelectedRow];
      
      if(null!=bn)
      {
       CustomerEditUI = new MasterCustomerEdit(this, true, action, bn);
      }    
    }  
    else
    {CustomerEditUI = new MasterCustomerEdit(this, true, action, null);}    
    
    CustomerEditUI.setVisible(true);
    CustomerEditUI.toFront();
    CustomerEditUI.finalizeMe();
    this.SearchCustomer();
  }
   
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbSearchCriteria = new javax.swing.JComboBox();
        txtSearchValue = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCustomer = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Master Pelanggang");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Daftar Tipe Barang:");

        cmbSearchCriteria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbSearchCriteria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kode Pelanggang", "Nama Pelanggang", "No Telepon" }));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setText("Cari");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tbCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Pelanggang", "Nama Pelanggang", "Alamat", "No Telepon"
            }
        ));
        tbCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCustomer);

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnQuit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQuit.setText("Keluar");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(582, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(556, 556, 556))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cmbSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 513, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(98, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.SearchCustomer();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCustomerMouseClicked
        this.editInfo(true);
    }//GEN-LAST:event_tbCustomerMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
      editInfo(false); 
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
       this.CloseMe();
    }//GEN-LAST:event_btnQuitActionPerformed

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
            java.util.logging.Logger.getLogger(MasterCustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterCustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterCustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterCustomerList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterCustomerList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbSearchCriteria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCustomer;
    private javax.swing.JTextField txtSearchValue;
    // End of variables declaration//GEN-END:variables
}
