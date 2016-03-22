/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.ui;

import com.st.beans.MasterUserBean;
import com.st.process.MasterUserProcessor;
import com.st.utils.Utilities;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Timothy_Fab
 */
public class MasterUserEdit extends javax.swing.JDialog {

  /** Flag used to determine action. update or create. */
  private boolean isUpdate = false;
  private boolean StatusTransaction;
  
  private MasterUserList mul = null;
  
  private MasterUserProcessor mup = null;
    
    /**
     * Creates new form MasterUserEdit2
     * @param parent
     */
    public MasterUserEdit(java.awt.Frame parent, boolean modal, boolean isUpdate, MasterUserBean bn) 
    {
        super(parent, modal);
        this.isUpdate =  isUpdate;
        
        initComponents();
        this.setLocationRelativeTo(null);     
        
        if(isUpdate)
        {
          txtUserLogin.setText(bn.getUserLogin());
          txtPassword.setText(bn.getPassowrd());
          txtName.setText(bn.getName());
        }    
    }

    private MasterUserEdit(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public void finalizeMe()
      {
      StatusTransaction = false;
      if(null!=mup) mup = null;
      }
      
      private MasterUserBean validateData()
      {
        String tmp = null;
        MasterUserBean bn = new MasterUserBean();
        
        /**validate user login*/
        tmp = txtUserLogin.getText();
        if(!Utilities.isEmpty(tmp))
        {bn.setUserLogin(tmp);}    
        else
        {
          JOptionPane.showMessageDialog(this, 
              "Error!", 
              "User Login Tidak boleh kosong", 
              JOptionPane.ERROR_MESSAGE);  
        }
        
        /** validate password */
        tmp="";
        tmp = txtPassword.getText();
        if(!Utilities.isEmpty(tmp))
        {bn.setPassowrd(tmp);}    
        else
        {
          JOptionPane.showMessageDialog(this, 
              "Error!", 
              "Password Tidak boleh kosong", 
              JOptionPane.ERROR_MESSAGE);  
        }
        
        /** validate Name */
        tmp="";
        tmp = txtName.getText();
        if(!Utilities.isEmpty(tmp))
        {bn.setName(tmp);}    
        else
        {
          JOptionPane.showMessageDialog(this, 
              "Error!", 
              "Name Tidak boleh kosong", 
              JOptionPane.ERROR_MESSAGE);  
        }
               
        return bn;
      }
 
      /** Create process. */
      private void create()
      {
        mup = new MasterUserProcessor();
        MasterUserBean bn = this.validateData();
         //s System.out.println("create__ : " + mup.create(bn));
        if(!mup.create(bn))
        {
          StatusTransaction = false;
          JOptionPane.showMessageDialog(this, "Error!", "Error create Master User. ", JOptionPane.ERROR_MESSAGE);
        }    
        else
        {
         StatusTransaction = true;
         JOptionPane.showMessageDialog(this, "Success!!", "Success create Master User Data. ", JOptionPane.PLAIN_MESSAGE);
        }
        
        //Finalising Proc
        mup.finalize();
        this.FinishingTransaction();
      }
      
      /** Update Process. */
      private void update()
      {
       mup = new MasterUserProcessor();
       MasterUserBean bn = this.validateData();
       
       if(!mup.update(bn))
       {
         StatusTransaction = false;
         JOptionPane.showMessageDialog(this, "Error!", "Error!!! update Master User. ", JOptionPane.ERROR_MESSAGE);  
       } 
       else
       {
         StatusTransaction = true;
         JOptionPane.showMessageDialog(this, "Success!", "Success update Master User. ", JOptionPane.ERROR_MESSAGE);   
       }    
       
        //Finalising Proc
        mup.finalize();
        System.out.println("AFTER FINALIZE");
        this.FinishingTransaction();
      }
      
      /** Delete process. */
      private void delete()
      {
       mup = new MasterUserProcessor();
       MasterUserBean bn = this.validateData();
       
       if(!mup.delete(bn.getName()))
       {
        StatusTransaction = false;
        JOptionPane.showMessageDialog(this, "Error!", "Error delete Master User. ", JOptionPane.ERROR_MESSAGE);   
       }    
       else
       {
        StatusTransaction = true;
        JOptionPane.showMessageDialog(this, "Success!!", "Success delete Master User. ", JOptionPane.ERROR_MESSAGE);     
       }
       
        mup.finalize();
        System.out.println("AFTER FINALIZE");
        this.FinishingTransaction();
      }
      
      
      /**finish transaction */
      public void FinishingTransaction()
      {
       //If transaction success
       if(StatusTransaction)
       {
        this.setVisible(false);
       //Refresh Table.
        mul = new MasterUserList();
        mul.RefreshTable();
       }        
     }
      
     public boolean getStatusTransaction()
     { return StatusTransaction; }
      
      
 
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
        LitemCode = new javax.swing.JLabel();
        LitemCode1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        LitemCode2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        LitemCode4 = new javax.swing.JLabel();
        checkboxMasterAccess = new javax.swing.JCheckBox();
        LitemCode5 = new javax.swing.JLabel();
        LitemCode6 = new javax.swing.JLabel();
        checkboxReportAccesss = new javax.swing.JCheckBox();
        checkboxRecordtAccess = new javax.swing.JCheckBox();
        txtUserLogin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Info User Login");

        LitemCode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode.setText("User Login :");

        LitemCode1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode1.setText("Password :");

        LitemCode2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode2.setText("Nama :");

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Keluar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        LitemCode4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode4.setText("Master Access :");

        checkboxMasterAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxMasterAccessActionPerformed(evt);
            }
        });

        LitemCode5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode5.setText("Record Access");

        LitemCode6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode6.setText("Report Access :");

        checkboxReportAccesss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxReportAccesssActionPerformed(evt);
            }
        });

        checkboxRecordtAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxRecordtAccessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtPassword)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSave)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LitemCode1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LitemCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LitemCode2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LitemCode4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LitemCode5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LitemCode6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserLogin)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkboxMasterAccess)
                                    .addComponent(checkboxReportAccesss)
                                    .addComponent(checkboxRecordtAccess)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnDelete)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)))
                                .addGap(0, 15, Short.MAX_VALUE)))))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LitemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LitemCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LitemCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(LitemCode4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkboxMasterAccess))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LitemCode5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxRecordtAccess))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LitemCode6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxReportAccesss))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void checkboxMasterAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxMasterAccessActionPerformed
        // TODO add your handling code here:
        if(checkboxMasterAccess.isSelected())
        {
          checkboxReportAccesss.setSelected(false);
          checkboxRecordtAccess.setSelected(false);
        }    
    }//GEN-LAST:event_checkboxMasterAccessActionPerformed

    private void checkboxRecordtAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxRecordtAccessActionPerformed
        // TODO add your handling code here:
        if(checkboxRecordtAccess.isSelected())
        {
          checkboxMasterAccess.setSelected(false);
          checkboxReportAccesss.setSelected(false);         
        }    
    }//GEN-LAST:event_checkboxRecordtAccessActionPerformed

    private void checkboxReportAccesssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxReportAccesssActionPerformed
        // TODO add your handling code here:
        if(checkboxReportAccesss.isSelected())
        {
          checkboxMasterAccess.setSelected(false);
          checkboxRecordtAccess.setSelected(false);         
        }    
    }//GEN-LAST:event_checkboxReportAccesssActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
     if(isUpdate)
     { update(); }
     else
     { create(); }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(MasterUserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterUserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterUserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterUserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MasterUserEdit dialog = new MasterUserEdit(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LitemCode;
    private javax.swing.JLabel LitemCode1;
    private javax.swing.JLabel LitemCode2;
    private javax.swing.JLabel LitemCode4;
    private javax.swing.JLabel LitemCode5;
    private javax.swing.JLabel LitemCode6;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox checkboxMasterAccess;
    private javax.swing.JCheckBox checkboxRecordtAccess;
    private javax.swing.JCheckBox checkboxReportAccesss;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserLogin;
    // End of variables declaration//GEN-END:variables
}
