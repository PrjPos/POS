/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.ui;

import com.st.beans.MasterSupplierBean;
import com.st.process.MasterSupplierProcessor;
import com.st.utils.Utilities;
import javax.swing.JOptionPane;
/**
 *
 * @author Timothy_Fab
 */
public class MasterSupplierEdit extends javax.swing.JDialog {
    
  /** Flag used to determine action. update or create. */
  private boolean isUpdate = false;
  private boolean StatusTransaction;
  
  private MasterSupplierList msl = null;
  
  private MasterSupplierProcessor msp = null;
  
    /**
     * Creates new form MasterSupplierEdit
     */
    public MasterSupplierEdit(java.awt.Frame parent, boolean modal, boolean isUpdate, MasterSupplierBean bn ) {
        super(parent, modal);
        this.isUpdate = isUpdate;
               
        initComponents();
        this.setLocationRelativeTo(null);
        
        if(isUpdate)
        {
          txtSupplierID.setText(bn.getID());
          txtSupplierName.setText(bn.getName());
          txtSupplierAddress.setText(bn.getAddress());
          txtPhoneNumber.setText(bn.getPhoneNumber());         
        }    
    }
    
    /**validate data get from UI */
    private MasterSupplierBean validateData()
    {
      String tmp = null;
      MasterSupplierBean bn = new MasterSupplierBean(); 
      
      /** validate Supplier ID. */
      tmp = txtSupplierID.getText();
      if(!Utilities.isEmpty(tmp))
      {bn.setID(tmp);}    
      else
      {
        JOptionPane.showMessageDialog(this, 
              "Error!", 
              "ID Tidak boleh kosong", 
              JOptionPane.ERROR_MESSAGE);  
      }  
      
      /** validate Supplier Name. */
      tmp = txtSupplierName.getText();
      if(!Utilities.isEmpty(tmp))
      {bn.setName(tmp);}    
      else
      {
        JOptionPane.showMessageDialog(this, 
              "Error!", 
              "Nama Tidak boleh kosong", 
              JOptionPane.ERROR_MESSAGE);  
      } 
      
      /** validate Address. */    
      bn.setAddress(txtSupplierAddress.getText());
      
      /** validate Phone Number. */ 
      tmp = txtPhoneNumber.getText();
      if(!Utilities.isEmpty(tmp))
      {bn.setPhoneNumber(tmp);}    
      else
      {
        JOptionPane.showMessageDialog(this, 
              "Error!", 
              "Phone Number Tidak boleh kosong", 
              JOptionPane.ERROR_MESSAGE);  
      }      
      return bn;
    }     
    
    /**
     * Insert Data Master Supplier
     */
    private void create()
    {
      msp = new MasterSupplierProcessor();
      MasterSupplierBean bn = this.validateData();
      
      if(!msp.create(bn))
      {    
        StatusTransaction = false;
        JOptionPane.showMessageDialog(this, "Error!", "Error create master Supplier. ", JOptionPane.ERROR_MESSAGE);
      }
      else
      {
       StatusTransaction = true;   
       JOptionPane.showMessageDialog(this, "Success!!", "Success create master Supplier. ", JOptionPane.ERROR_MESSAGE);
      }    
      msp.finalize();
      this.FinishingTransaction();
    }      
    
    /**
     * Delete data where ID
     */
    private void delete()
    {
      msp = new MasterSupplierProcessor();
      MasterSupplierBean bn = this.validateData();
      
      if(!msp.delete(bn.getID()))
      {
        StatusTransaction = false;  
        JOptionPane.showMessageDialog(this, "Error!", "Error delete Master Supplier. ", JOptionPane.ERROR_MESSAGE);
      }    
      else
      {
        StatusTransaction = true;  
        JOptionPane.showMessageDialog(this, "Success!!", "Success delete master Supplier. ", JOptionPane.PLAIN_MESSAGE);
      }    
      
      //Finalising Proc
      msp.finalize();
      this.FinishingTransaction();
    }        
    
    /**
     * update data master supplier
     */
    private void update()
    {
       msp = new MasterSupplierProcessor();
       MasterSupplierBean bn = this.validateData();
       if(!msp.update(bn))
       {
         StatusTransaction = false;  
         JOptionPane.showMessageDialog(this, "Error!", "Error!!! update master supplier. ", JOptionPane.ERROR_MESSAGE);
       }    
       else
       {
         StatusTransaction = true;
         JOptionPane.showMessageDialog(this, "Success!!", "Success update master supplier. ", JOptionPane.PLAIN_MESSAGE);             
       }   
       
      //Finalising Proc
      msp.finalize();
      System.out.println("AFTER FINALIZE");
      this.FinishingTransaction();       
    }        
    
  /**
   * finish transaction
   */  
  public void FinishingTransaction()
  {
    //If transaction success
    if(StatusTransaction)
    {
      this.setVisible(false);
      //Refresh Table.
      msl = new MasterSupplierList();
      msl.RefreshTable();
    }
  }
  
  public void finalizeMe()
  {
    StatusTransaction = false;
    if(null!=msl) msl = null;
  }
    
  /** Get status transaction is success or filed!!*/
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
        txtSupplierName = new javax.swing.JTextField();
        LitemCode2 = new javax.swing.JLabel();
        txtSupplierAddress = new javax.swing.JTextField();
        LitemCode3 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtSupplierID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Entry Data Supplier");

        LitemCode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode.setText("Kode Supplier");

        LitemCode1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode1.setText("Nama Supplier");

        LitemCode2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode2.setText("Alamat Supplier");

        LitemCode3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode3.setText("Telp");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LitemCode1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LitemCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LitemCode2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LitemCode3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSupplierAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtSupplierName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneNumber)
                            .addComponent(txtSupplierID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LitemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LitemCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LitemCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LitemCode3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(isUpdate)
        {update();}    
        else
        {create();}          
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
            java.util.logging.Logger.getLogger(MasterSupplierEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterSupplierEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterSupplierEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterSupplierEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MasterSupplierEdit dialog = new MasterSupplierEdit(new javax.swing.JFrame(), true, false, null);
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
    private javax.swing.JLabel LitemCode3;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSupplierAddress;
    private javax.swing.JTextField txtSupplierID;
    private javax.swing.JTextField txtSupplierName;
    // End of variables declaration//GEN-END:variables
}
