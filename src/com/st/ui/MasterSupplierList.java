/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.ui;

/**
 *
 * @author Timothy_Fab
 */
import com.st.beans.MasterSupplierBean;
import com.st.core.Main;
import com.st.process.MasterSupplierProcessor;
import com.st.utils.Constants;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class MasterSupplierList extends javax.swing.JFrame {
    
      /** Item Type Info column size. */
  private final int SUPPLIER_COLSIZE = 6;
  /** Default table model for the Item Lookup. */
  private DefaultTableModel tm = null;
  
  /** Column Title - ID. */
  private final String COLTITLE_ID = "Kode #";
  /** Column Title - Name. */
  private final String COLTITLE_NAME = "Nama";
  /** Column Title - Address. */
  private final String COLTITLE_ADDRESS = "Alamat";
  /** Column Title - Address. */
  private final String COLTITLE_PHONE_NUMBER = "Phone Number";
  /** Column Title - Entry Date. */
  private final String COLTITLE_ENTRY_DATE = "Entry Date";
  /** Column Title - Entry User. */
  private final String COLTITLE_ENTRY_USER = "Entry User";
  
  /** Column position for Item Info ID. */
  private final int SUPPLIER_COL_ID = 0;
  /** Column position for Item Info Name. */
  private final int SUPPLIER_COL_NAME = 1;
  /** Column position for Item Info Address. */
  private final int SUPPLIER_COL_ADDRESS = 2;
  /** Column position for Item Info Phone Number. */
  private final int SUPPLIER_COL_PHONE_NUMBER = 3;
  /** Column position for Item Info Entry Date. */
  private final int SUPPLIER_COL_ENTRY_DATE = 4;
  /** Column position for Item Info Entry User. */
  private final int SUPPLIER_COL_ENTRY_USER = 5;
  
  MasterSupplierBean[] dataSupplier = null;
  MasterSupplierEdit supplierEditUI = null;

  /** Processor. */
  private MasterSupplierProcessor p =  new MasterSupplierProcessor();
  
  /**
   * Creates new form MasterSupplier
   */
   public MasterSupplierList() 
   {
        initComponents();
        SearchSupplier();
        setExtendedState(MAXIMIZED_BOTH);
   }
    
  private void SearchSupplier()
  {
    //Searching List Item type.
    int searchBy = cmbSearchCriteria.getSelectedIndex();
    MasterSupplierBean[] res;  
    
    if(null==p)
    {p=new MasterSupplierProcessor();}    
    System.out.println("SEARCH BY: " + searchBy);
    
    switch(searchBy)
    {
        case 0:  //Search by item id
              res = p.getSupplierList(Constants.SUPPLIER_SEARCHBY_SUPPID,
                                      txtSearchValue.getText(),
                                      null);
               System.out.println("masuk supp id");
              break;
        case 1: //Search by item name
               res = p.getSupplierList(Constants.SUPPLIER_SEARCHBY_SUPPNM,
                                      txtSearchValue.getText(),
                                      null);
              break;
        default: //Search by item Phone Number
               res =  p.getSupplierList(Constants.SUPPLIER_SEARCHBY_PHONE_NUMBER,
                                      txtSearchValue.getText(),
                                      null);
              
              break;              
      }
       dataSupplier = res;
       //Repaint the supplier list
       System.out.println("res : _____" + res[0].getName());
       this.repaintSupplierList(res);          
  }
  
  
  /** Used to edit info. */
  public void editInfo(boolean action)
  {
    MasterSupplierBean bn;  
    
    if(action)
    {
     int SelectRow = tableSupplier.getSelectedRow();
     bn = dataSupplier[SelectRow];
     
     if(null!=bn)
     {
       supplierEditUI = new MasterSupplierEdit(this, action, true, bn);
     }    
    }
    else 
    {supplierEditUI = new MasterSupplierEdit(this, true, action, null);}      
    
    //after transaction is finish, reload
    supplierEditUI.setVisible(true);
    this.SearchSupplier();
  }
  
  public void resetEngine(boolean renew)
  {
    if(null!=p)
    {
      p.finalize();
      p = null;
    }  
    
    if(null!=dataSupplier) 
    {dataSupplier=null;}
    
    if(renew)
    {
     //Renew the processor and the transaction bean  
     p = new MasterSupplierProcessor();
    }    
  }        
  
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
  
  
  /**
   * 
   * @param res 
   */
  private void repaintSupplierList(MasterSupplierBean[] res)
  {
    if(null==res || res.length<=0) return;  
    
    this.resetSupplierList(res.length);
    
     /* This is the row:
      * ID | NAME | ADDRESS | PHONE NUMBER | ENTRY DATE | ENTRY USER
      */
     //Set the supplier into the shopping list table.
    for(int i=0; i<res.length; i++)
    {
      tm.setValueAt(res[i].getID(), i, SUPPLIER_COL_ID);
      tm.setValueAt(res[i].getName(), i, SUPPLIER_COL_NAME);
      tm.setValueAt(res[i].getAddress(), i, SUPPLIER_COL_ADDRESS);
      tm.setValueAt(res[i].getPhoneNumber(), i, SUPPLIER_COL_PHONE_NUMBER);
      tm.setValueAt(res[i].getEntryDate(), i, SUPPLIER_COL_ENTRY_DATE);
      tm.setValueAt(res[i].getEntryUser(), i, SUPPLIER_COL_ENTRY_USER);
    }
  }
  
  /**
   * 
   * @param row 
   */  
  private void resetSupplierList(int row)
  {
    TableColumn t;

    int COLSIZE_ID = 100;
    int COLSIZE_NAME = 300;
    int COLSIZE_ADDRESS = 300;
    int COLSIZE_PHONE_NUMBER = 300;
    int COLSIZE_ENTRY_DATE = 300;    
    int COLSIZE_ENTRY_USER = 300;  
    
    tm = new DefaultTableModel(row, SUPPLIER_COLSIZE);
    tm.setColumnIdentifiers(
       new String[]
       {
         COLTITLE_ID,
         COLTITLE_NAME,
         COLTITLE_ADDRESS,
         COLTITLE_PHONE_NUMBER,
         COLTITLE_ENTRY_DATE,
         COLTITLE_ENTRY_USER
       }
       );
    
      tableSupplier.setModel(tm);
      tm.setValueAt(null, 0, SUPPLIER_COL_ID);
      tm.setValueAt(null, 0, SUPPLIER_COL_NAME);
      tm.setValueAt(null, 0, SUPPLIER_COL_ADDRESS);
      tm.setValueAt(null, 0, SUPPLIER_COL_PHONE_NUMBER);
      tm.setValueAt(null, 0, SUPPLIER_COL_ENTRY_DATE);
      tm.setValueAt(null, 0, SUPPLIER_COL_ENTRY_USER);
      
      t = tableSupplier.getColumn(COLTITLE_ID);
      t.setResizable(false);
      t.setMinWidth(COLSIZE_ID);
      t.setPreferredWidth(COLSIZE_ID);
      
      t = tableSupplier.getColumn(COLTITLE_NAME);
      t.setResizable(false);
      t.setMinWidth(COLSIZE_NAME);
      t.setPreferredWidth(COLSIZE_NAME);
      
      t = tableSupplier.getColumn(COLTITLE_ADDRESS);
      t.setResizable(false);
      t.setMinWidth(COLSIZE_ADDRESS);
      t.setPreferredWidth(COLSIZE_ADDRESS);
      
      t = tableSupplier.getColumn(COLTITLE_PHONE_NUMBER);
      t.setResizable(false);
      t.setMinWidth(COLSIZE_PHONE_NUMBER);
      t.setPreferredWidth(COLSIZE_ADDRESS);
      
      t = tableSupplier.getColumn(COLTITLE_ENTRY_DATE);
      t.setResizable(false);
      t.setMinWidth(COLSIZE_ENTRY_DATE);
      t.setPreferredWidth(COLSIZE_ENTRY_DATE);
      
      t = tableSupplier.getColumn(COLTITLE_ENTRY_USER);
      t.setResizable(false);
      t.setMinWidth(COLSIZE_ENTRY_USER);
      t.setPreferredWidth(COLSIZE_ENTRY_USER);     
  }
  
    public void RefreshTable()
    { this.SearchSupplier(); }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cmbSearchCriteria = new javax.swing.JComboBox();
        txtSearchValue = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Daftar Supplier:");

        tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Supplier", "Nama Supplier", "Alamat ", "Telepon", "Entry Date", "Entry User"
            }
        ));
        tableSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSupplier);

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Keluar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cmbSearchCriteria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbSearchCriteria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kode Supplier", "Nama Supplier", "Telepon", " " }));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setText("Cari");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Master Supplier");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(cmbSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(513, 513, 513))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnCancel))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        editInfo(false);
       // new MasterSupplierEdit().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.SearchSupplier();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        CloseMe();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tableSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSupplierMouseClicked
        // TODO add your handling code here:
        editInfo(true);
    }//GEN-LAST:event_tableSupplierMouseClicked

    public void finalize()
    {
    this.resetEngine(false);
    this.setVisible(false);
    }
    
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
            java.util.logging.Logger.getLogger(MasterSupplierList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterSupplierList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterSupplierList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterSupplierList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterSupplierList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbSearchCriteria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTextField txtSearchValue;
    // End of variables declaration//GEN-END:variables
}
