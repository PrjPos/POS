/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.ui;

import com.st.core.Main;
import com.st.utils.Constants;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.lang.Object;
import javax.swing.border.Border;
/**
 *
 * @author Timothy_Fab
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Home() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
         //jPanel1.setOpaque(false);
        
       // jPanel2.setBackground(new Color(0,0,0,55));
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCustomer = new javax.swing.JButton();
        btnItemType = new javax.swing.JButton();
        btnItem = new javax.swing.JButton();
        btnSupplier = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnSales = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnPurchase = new javax.swing.JButton();
        btnPurchaseReport = new javax.swing.JButton();
        btnBorrow = new javax.swing.JButton();
        LReport = new javax.swing.JLabel();
        LTransactionData = new javax.swing.JLabel();
        LMaster = new javax.swing.JLabel();
        btnCard = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LMain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        btnCustomer.setIcon(new javax.swing.ImageIcon("D:\\Project\\Cashier Phone\\CashierPhone\\src\\com\\st\\ui\\image\\ButtonCustomer.png")); // NOI18N
        btnCustomer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });
        getContentPane().add(btnCustomer);
        btnCustomer.setBounds(50, 380, 220, 60);

        btnItemType.setForeground(new java.awt.Color(153, 153, 153));
        btnItemType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/ButtonItemType.png"))); // NOI18N
        btnItemType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnItemType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemTypeActionPerformed(evt);
            }
        });
        getContentPane().add(btnItemType);
        btnItemType.setBounds(280, 290, 220, 60);

        btnItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/ButtonItem.png"))); // NOI18N
        btnItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemActionPerformed(evt);
            }
        });
        getContentPane().add(btnItem);
        btnItem.setBounds(50, 290, 220, 60);

        btnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/Button Supplier.png"))); // NOI18N
        btnSupplier.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierActionPerformed(evt);
            }
        });
        getContentPane().add(btnSupplier);
        btnSupplier.setBounds(280, 380, 220, 60);

        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/Button User3.png"))); // NOI18N
        btnUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnUser);
        btnUser.setBounds(280, 470, 220, 60);

        btnSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/ButtonSales.png"))); // NOI18N
        btnSales.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnSales);
        btnSales.setBounds(670, 380, 220, 60);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/ButtonSalesReport.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jButton1);
        jButton1.setBounds(1040, 380, 220, 60);

        btnPurchase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/ButtonPurchase.png"))); // NOI18N
        btnPurchase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnPurchase);
        btnPurchase.setBounds(670, 290, 220, 60);

        btnPurchaseReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/ButtonPurchaseReport2.png"))); // NOI18N
        btnPurchaseReport.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnPurchaseReport);
        btnPurchaseReport.setBounds(1040, 290, 220, 60);

        btnBorrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/ButtonBorrow.png"))); // NOI18N
        btnBorrow.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnBorrow);
        btnBorrow.setBounds(670, 470, 220, 60);

        LReport.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LReport.setForeground(new java.awt.Color(51, 204, 255));
        LReport.setText("LAPORAN");
        getContentPane().add(LReport);
        LReport.setBounds(1090, 250, 140, 29);

        LTransactionData.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LTransactionData.setForeground(new java.awt.Color(51, 204, 255));
        LTransactionData.setText("DATA TRANSAKSI");
        getContentPane().add(LTransactionData);
        LTransactionData.setBounds(670, 250, 240, 29);

        LMaster.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LMaster.setForeground(new java.awt.Color(51, 204, 255));
        LMaster.setText("DATA MASTER");
        getContentPane().add(LMaster);
        LMaster.setBounds(190, 250, 200, 29);

        btnCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/ButtonCard2.png"))); // NOI18N
        btnCard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardActionPerformed(evt);
            }
        });
        getContentPane().add(btnCard);
        btnCard.setBounds(50, 470, 220, 60);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("MENU UTAMA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(620, 30, 200, 30);

        LMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/Background_jadi.png"))); // NOI18N
        getContentPane().add(LMain);
        LMain.setBounds(0, 0, 1380, 750);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    Login l = new Login();
    l.setVisible(true);
    l.toFront();
    
    System.exit(0);
  }//GEN-LAST:event_formWindowClosing

    private void btnItemTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemTypeActionPerformed
        // TODO add your handling code here:
        Main.callModule(Constants.MOD_ITEM_TYPE);
    }//GEN-LAST:event_btnItemTypeActionPerformed

    private void btnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemActionPerformed
         Main.callModule(Constants.MOD_ITEM);
    }//GEN-LAST:event_btnItemActionPerformed

    private void btnSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierActionPerformed
        Main.callModule(Constants.MOD_SUPPLIER);
    }//GEN-LAST:event_btnSupplierActionPerformed

    private void btnCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardActionPerformed
         Main.callModule(Constants.MOD_CARD);
    }//GEN-LAST:event_btnCardActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
         Main.callModule(Constants.MOD_USER);
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        Main.callModule(Constants.MOD_CUSTOMER);
    }//GEN-LAST:event_btnCustomerActionPerformed
  
  private void CloseMe()
  {
    Main.callModule(Constants.MOD_LOGIN);
    this.finalize();
  }
  
  public void finalize()
  {
    this.setVisible(false);
    System.out.println("Make login page invisible!");
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
          java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
              new Home().setVisible(true);
          }
      });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LMain;
    private javax.swing.JLabel LMaster;
    private javax.swing.JLabel LReport;
    private javax.swing.JLabel LTransactionData;
    private javax.swing.JButton btnBorrow;
    private javax.swing.JButton btnCard;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnItem;
    private javax.swing.JButton btnItemType;
    private javax.swing.JButton btnPurchase;
    private javax.swing.JButton btnPurchaseReport;
    private javax.swing.JButton btnSales;
    private javax.swing.JButton btnSupplier;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
