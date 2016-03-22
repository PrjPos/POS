/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.ui;

import com.st.beans.MasterUserBean;
import com.st.core.Main;
import com.st.process.MasterUserProcessor;
import com.st.utils.Constants;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Timothy_Fab
 */
public class MasterUserList extends javax.swing.JFrame 
{
   /** user Info column size. */
  private final int USERINFO_COLSIZE = 6;
  /** Default table model for the Item Lookup. */
  private DefaultTableModel tm = null;
  
  /** Column Title - User Login. */
  private final String COLTITLE_USER_LOGIN = "User Login";
  /** Column Title - Password. */
  private final String COLTITLE_PASSWORD = "Password";
  /** Column Title - Standard Name. */
  private final String COLTITLE_USER_NAME = "Name";
  /** Column Title - Standard Master Access. */
  private final String COLTITLE_MASTER_ACCESS = "Master Access";
  /** Column Title - Standard Record Access. */
  private final String COLTITLE_RECORD_ACCESS = "Record Access";
  /** Column Title - Standard Report Access. */
  private final String COLTITLE_REPORT_ACCESS = "Report Access";
  
  /** Column position for Item Info User Login. */
  private final int USER_COL_LOGIN = 0;
  /** Column position for Item Info Password. */
  private final int USER_COL_PASSOWRD = 1;
  /** Column position for Item Info Name. */
  private final int USER_COL_NAME = 2;
  /** Column position for Item Info Master Access. */
  private final int USER_COL_MASTER_ACCESS = 3;
  /** Column position for Item Info Master Access. */
  private final int USER_COL_RECORD_ACCESS = 4;
  /** Column position for Item Info Master Access. */
  private final int USER_COL_REPORT_ACCESS = 5;
  
  MasterUserBean[] dataUser = null;
  MasterUserEdit userEditUI = null;
  
  /** Processor. */
  private MasterUserProcessor p = new MasterUserProcessor();
     
    /**
     * Creates new form MasterUserListUI
     */
    public MasterUserList() 
    {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.SearchUser();
    }
    
    /**
     * Search all Data or search by type
     */
    private void SearchUser()
    {
       //Searching List Item type.
       int searchBy = cmbSearchCriteria.getSelectedIndex();
       MasterUserBean[] res = null;  
       
       if(null==p) {p = new MasterUserProcessor();}
       System.out.println("SEARCH BY: " + searchBy);
       
       switch(searchBy)
       {
        case 0 :
                res = p.getUserList(Constants.USER_SEARCHBY_USERLOGIN,
                                    txtSearchValue.getText(),
                                    null);
                break;
        case 1 :
                res = p.getUserList(Constants.USER_SEARCHBY_USERNAME,
                                    txtSearchValue.getText(),
                                    null);
                break;
       }  
       dataUser = res;
       
       //Repaint the user list
       this.repaintUserList(res);
    }     
    
    /** Used to edit info. */
    public void editInfo(boolean action)
    {
      MasterUserBean bn;
    
      if(action)
      {
        int SelectedRow = tblUser.getSelectedRow(); //get row number 
        bn = dataUser[SelectedRow]; //get row by selectedrow from bean dataUser put to variabel bn 
        
        if(null!=bn)
        {
         userEditUI = new MasterUserEdit(this, true, action, bn);
        }    
      }
      else
      {
         userEditUI = new MasterUserEdit(this, true, action, null);  
      }       
      userEditUI.setVisible(true);
      userEditUI.toFront();
      
      //after transaction is finish, reload
      userEditUI.finalizeMe();
      this.SearchUser();
    }        
    
    private void repaintUserList(MasterUserBean []res)
    {
      if(null==res || res.length<=0) return;  
      
       this.resetUserList(res.length);
       
       /* This is the row:
       * USER LOGIN | PASSWORD | USER NAME | MASTER ACCESS | MASTER RECORD | MASTER REPORT
       */
      //Set data user for show to table UI
        for(int i = 0; i < res.length; i++) 
        {
          tm.setValueAt(res[i].getUserLogin(), i, USER_COL_LOGIN);
          tm.setValueAt(res[i].getPassowrd(), i, USER_COL_PASSOWRD);
          tm.setValueAt(res[i].getName(), i, USER_COL_NAME);
          tm.setValueAt(res[i].getMasterAccess(), i, USER_COL_MASTER_ACCESS);
          tm.setValueAt(res[i].getRecordAccess(), i, USER_COL_RECORD_ACCESS);
          tm.setValueAt(res[i].getReportAccess(), i, USER_COL_REPORT_ACCESS);           
        }     
    }       
    
    private void resetUserList(int row)
    {
      TableColumn t;  
      
      int COLSIZE_USER_LOGIN = 200;     
      int COLSIZE_USER_PASSWORD = 200;
      int COLSIZE_USER_NAME = 200;
      int COLSIZE_USER_MASTER_ACCESS = 200;
      int COLSIZE_USER_RECORD_ACCESS = 200;
      int COLSIZE_USER_REPORT_ACCESS = 200;
      
      tm = new DefaultTableModel(row, USERINFO_COLSIZE);
      tm.setColumnIdentifiers(
         new String[]
         {
           COLTITLE_USER_LOGIN, 
           COLTITLE_PASSWORD, 
           COLTITLE_USER_NAME, 
           COLTITLE_MASTER_ACCESS, 
           COLTITLE_RECORD_ACCESS, 
           COLTITLE_REPORT_ACCESS                      
         }         
         );
      
        tblUser.setModel(tm);
        tm.setValueAt(null, 0, USER_COL_LOGIN);
        tm.setValueAt(null, 0, USER_COL_PASSOWRD);
        tm.setValueAt(null, 0, USER_COL_NAME);
        tm.setValueAt(null, 0, USER_COL_MASTER_ACCESS);
        tm.setValueAt(null, 0, USER_COL_RECORD_ACCESS);
        tm.setValueAt(null, 0, USER_COL_REPORT_ACCESS);
        
        t  = tblUser.getColumn(COLTITLE_USER_LOGIN);
        t.setResizable(false);
        t.setMinWidth(COLSIZE_USER_LOGIN);
        t.setPreferredWidth(COLSIZE_USER_LOGIN);
        
        t  = tblUser.getColumn(COLTITLE_PASSWORD);
        t.setResizable(false);
        t.setMinWidth(COLSIZE_USER_PASSWORD);
        t.setPreferredWidth(COLSIZE_USER_PASSWORD);
        
        t  = tblUser.getColumn(COLTITLE_USER_NAME);
        t.setResizable(false);
        t.setMinWidth(COLSIZE_USER_NAME);
        t.setPreferredWidth(COLSIZE_USER_NAME);
        
        t  = tblUser.getColumn(COLTITLE_MASTER_ACCESS);
        t.setResizable(false);
        t.setMinWidth(COLSIZE_USER_MASTER_ACCESS);
        t.setPreferredWidth(COLSIZE_USER_MASTER_ACCESS);
        
        t  = tblUser.getColumn(COLTITLE_RECORD_ACCESS);
        t.setResizable(false);
        t.setMinWidth(COLSIZE_USER_RECORD_ACCESS);
        t.setPreferredWidth(COLSIZE_USER_RECORD_ACCESS);
        
        t  = tblUser.getColumn(COLTITLE_REPORT_ACCESS);
        t.setResizable(false);
        t.setMinWidth(COLSIZE_USER_REPORT_ACCESS);
        t.setPreferredWidth(COLSIZE_USER_REPORT_ACCESS);
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
    
    public void RefreshTable()
    { this.SearchUser(); }
    
   
  
    public void finalize()
    {
     this.resetEngine(false);
     this.setVisible(false);
    }
    
    /**reset engine data in user bean*/
    public void resetEngine(boolean renew)
    {
     if(null!=p)
     {
      p.finalize();
      p = null;
     }
     
     if(null!=dataUser) dataUser = null;
     
     if(renew)
     {
      //Renew the processor and the transaction bean
      p = new MasterUserProcessor();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        cmbSearchCriteria = new javax.swing.JComboBox();
        txtSearchValue = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Daftar User:");

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "User Login", "Password", "Nama ", "Master Acces", "Record Acces", "Entry User", "Report Access"
            }
        ));
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

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

        cmbSearchCriteria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbSearchCriteria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "User Login", "Nama" }));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setText("Cari");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Master User");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(cmbSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(513, 513, 513))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSearchCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnQuit))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        editInfo(false);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.SearchUser();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        this.CloseMe();
    }//GEN-LAST:event_btnQuitActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        editInfo(true);
    }//GEN-LAST:event_tblUserMouseClicked

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
            java.util.logging.Logger.getLogger(MasterUserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterUserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterUserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterUserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterUserList().setVisible(true);
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtSearchValue;
    // End of variables declaration//GEN-END:variables
}
