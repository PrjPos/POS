/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.ui;

import com.st.beans.MasterCustomerBean;
import com.st.process.MasterCustomerProcessor;
import com.st.utils.Utilities;
import javax.swing.JOptionPane;
/**
 *
 * @author Timothy_Fab
 */
public class MasterCustomerEdit extends javax.swing.JDialog {
    
      /** Flag used to determine action. update or create. */
  private boolean isUpdate = false;
  private boolean StatusTransaction;
  
  private MasterCustomerList mcl = null;
  
  private MasterCustomerProcessor mcp = null;
  
  
  public void finalizeMe()
  {
    StatusTransaction = false;
    if(null!=mcp) mcp = null;
  }
  
  /** Get status transaction is success or filed!!*/
  public boolean getStatusTransaction()
  { return StatusTransaction; }

    /**
     * Creates new form MasterCustomerEdiit
     */
    public MasterCustomerEdit(java.awt.Frame parent, boolean modal, boolean isUpdate,  MasterCustomerBean bn) {
        super(parent, modal);    
        this.isUpdate = isUpdate;
        initComponents();
        this.setLocationRelativeTo(null);
        
        if(isUpdate)
        {
          txtCustomerCode.setText(bn.getId());
          txtCustomerName.setText(bn.getName());
          txtAddress.setText(bn.getAddress());
          txtPhoneNumber.setText(bn.getPhoneNumber());
        }    
    }
    
    private MasterCustomerBean validateData()
  {
    String tmp = null;
    MasterCustomerBean bn = new MasterCustomerBean();
    
    /** validate ID*/
    tmp = txtCustomerCode.getText();
    if(!Utilities.isEmpty(tmp))
    {bn.setId(tmp);}    
    else
    {
      JOptionPane.showMessageDialog(this, 
              "Error!", 
              "ID Tidak boleh kosong", 
              JOptionPane.ERROR_MESSAGE);  
    }   
    
     /** Validate Nama. */
    tmp = txtCustomerName.getText();
    if(!Utilities.isEmpty(tmp))
    { bn.setName(tmp); }
    else
    {
      JOptionPane.showMessageDialog(this, 
              "Error!", 
              "Nama Tidak boleh kosong", 
              JOptionPane.ERROR_MESSAGE);
    }
    
    /** Validate Address. */
    tmp = txtAddress.getText();
    if(!Utilities.isEmpty(tmp))
    { bn.setAddress(tmp); }
    else
    {
      JOptionPane.showMessageDialog(this, 
              "Error!", 
              "Alamat Tidak boleh kosong", 
              JOptionPane.ERROR_MESSAGE);
    }
    
    /** Validate Phone Number. */
    tmp = txtPhoneNumber.getText();
    if(!Utilities.isEmpty(tmp))
    { bn.setPhoneNumber(tmp); }
    else
    {
      JOptionPane.showMessageDialog(this, 
              "Error!", 
              "Nomor Telepon Tidak boleh kosong", 
              JOptionPane.ERROR_MESSAGE);
    }
    
    return bn;
  }     

    /** Update Process. */
  private void update()
  {
    mcp = new MasterCustomerProcessor();
    MasterCustomerBean bn = this.validateData();
    if(!mcp.update(bn))
    {
      StatusTransaction = false;
      JOptionPane.showMessageDialog(this, "Error!", "Error!!! update Master Customer. ", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
      StatusTransaction = true;
      JOptionPane.showMessageDialog(this, "Success!!", "Success update Master Customer. ", JOptionPane.PLAIN_MESSAGE);
    }
    
    //Finalising Proc
    mcp.finalize();
    System.out.println("AFTER FINALIZE");
    this.FinishingTransaction();
  } 
  
    /** Create process. */
  private void create()
  {
    mcp = new MasterCustomerProcessor();
    MasterCustomerBean bn = this.validateData();
    if(!mcp.create(bn))
    {
      StatusTransaction = false;
      JOptionPane.showMessageDialog(this, "Error!", "Error create Master Customer. ", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
      StatusTransaction = true;
      JOptionPane.showMessageDialog(this, "Success!!", "Success create Master Customer. ", JOptionPane.PLAIN_MESSAGE);
    } 
    //Finalising Proc
    mcp.finalize();
    this.FinishingTransaction();
  }
  /** process delete master customer*/
  private void delete()
  {
    mcp = new MasterCustomerProcessor();
    MasterCustomerBean bn = this.validateData();
    if(!mcp.delete(bn.getId()))
    {
      StatusTransaction = false;
      JOptionPane.showMessageDialog(this, "Error!", "Error delete Master Customer. ", JOptionPane.ERROR_MESSAGE);
    }
    else
    {
      StatusTransaction = true;
      JOptionPane.showMessageDialog(this, "Success!!", "Success delete Master Customer. ", JOptionPane.PLAIN_MESSAGE);
    }
    
    //Finalising Proc
    mcp.finalize();
    this.FinishingTransaction();
  }

  public void FinishingTransaction()
  {
    //If transaction success
    if(StatusTransaction)
    {
      this.setVisible(false);
      //Refresh Table.
      mcl = new MasterCustomerList();
      mcl.RefreshTable();
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
        jLabel1 = new javax.swing.JLabel();
        LitemCode = new javax.swing.JLabel();
        LitemCode1 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        LitemCode2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtCustomerCode = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        LitemCode3 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Info Pelanggang");

        LitemCode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode.setText("Kode Pelanggang :");

        LitemCode1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode1.setText("Nama Pelanggang :");

        LitemCode2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode2.setText("Alamat :");
        LitemCode2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        LitemCode3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LitemCode3.setText("Telepon : ");
        LitemCode3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LitemCode1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LitemCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LitemCode2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LitemCode3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCustomerCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LitemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LitemCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LitemCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LitemCode3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
      if(isUpdate)
      { update(); }
      else
      { create(); }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(MasterCustomerEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterCustomerEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterCustomerEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterCustomerEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MasterCustomerEdit dialog = new MasterCustomerEdit(new javax.swing.JFrame(), true, false, null);
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCustomerCode;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
