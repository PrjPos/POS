/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.ui;

/**
 *
 * @author SANFON
 */
public class PurchaseTransaction extends javax.swing.JFrame {

  /**
   * Creates new form SalesTransaction
   */
  public PurchaseTransaction() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pnlTop = new javax.swing.JPanel();
    txtItemID = new javax.swing.JTextField();
    txtItemName = new javax.swing.JTextField();
    txtItemQty = new javax.swing.JTextField();
    txtItemSellPrice = new javax.swing.JTextField();
    pnlMiddle = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    lblSubTotal = new javax.swing.JLabel();
    txtSubTotal = new javax.swing.JTextField();
    pnlSide = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jTextField2 = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jTextField3 = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jTextField4 = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    pnlPayment = new javax.swing.JPanel();
    txtPayInfoCash = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    txtPayInfoCard = new javax.swing.JTextField();
    pnlLegend = new javax.swing.JPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(0, 102, 102));
    setForeground(java.awt.Color.lightGray);

    pnlTop.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), java.awt.Color.black)); // NOI18N

    txtItemID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txtItemID.setText("KODE ITEM");

    txtItemName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    txtItemName.setText("NAMA ITEM");

    txtItemQty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    txtItemQty.setText("QTY");

    txtItemSellPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    txtItemSellPrice.setText("PRICE");

    javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
    pnlTop.setLayout(pnlTopLayout);
    pnlTopLayout.setHorizontalGroup(
      pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(txtItemID)
      .addComponent(txtItemName)
      .addGroup(pnlTopLayout.createSequentialGroup()
        .addComponent(txtItemQty, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtItemSellPrice))
    );
    pnlTopLayout.setVerticalGroup(
      pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlTopLayout.createSequentialGroup()
        .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtItemQty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtItemSellPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 11, Short.MAX_VALUE))
    );

    pnlMiddle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(jTable1);

    lblSubTotal.setForeground(new java.awt.Color(51, 51, 51));
    lblSubTotal.setText("Sub Total:");

    txtSubTotal.setEditable(false);
    txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    txtSubTotal.setText("123,456,789,012,345,678.90");

    javax.swing.GroupLayout pnlMiddleLayout = new javax.swing.GroupLayout(pnlMiddle);
    pnlMiddle.setLayout(pnlMiddleLayout);
    pnlMiddleLayout.setHorizontalGroup(
      pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
      .addGroup(pnlMiddleLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(lblSubTotal)
        .addGap(18, 18, 18)
        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    pnlMiddleLayout.setVerticalGroup(
      pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlMiddleLayout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(pnlMiddleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblSubTotal))
        .addGap(0, 179, Short.MAX_VALUE))
    );

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel1.setText(" NO         :");

    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel2.setText("REFF       :");

    jTextField3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField3ActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel3.setText(" NO         :");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel4.setText("CUST      :");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField3)
            .addComponent(jTextField4))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jTextField2)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(27, 27, 27))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(5, 5, 5)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pnlPayment.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pembayran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel5.setText("CASH");

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel6.setText("CARD");

    javax.swing.GroupLayout pnlPaymentLayout = new javax.swing.GroupLayout(pnlPayment);
    pnlPayment.setLayout(pnlPaymentLayout);
    pnlPaymentLayout.setHorizontalGroup(
      pnlPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlPaymentLayout.createSequentialGroup()
        .addGroup(pnlPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(pnlPaymentLayout.createSequentialGroup()
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtPayInfoCard, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(pnlPaymentLayout.createSequentialGroup()
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtPayInfoCash, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    pnlPaymentLayout.setVerticalGroup(
      pnlPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlPaymentLayout.createSequentialGroup()
        .addGroup(pnlPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtPayInfoCash, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(pnlPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtPayInfoCard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 24, Short.MAX_VALUE))
    );

    pnlLegend.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Legend", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

    javax.swing.GroupLayout pnlLegendLayout = new javax.swing.GroupLayout(pnlLegend);
    pnlLegend.setLayout(pnlLegendLayout);
    pnlLegendLayout.setHorizontalGroup(
      pnlLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    pnlLegendLayout.setVerticalGroup(
      pnlLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout pnlSideLayout = new javax.swing.GroupLayout(pnlSide);
    pnlSide.setLayout(pnlSideLayout);
    pnlSideLayout.setHorizontalGroup(
      pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(pnlPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(pnlLegend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    pnlSideLayout.setVerticalGroup(
      pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pnlSideLayout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(pnlPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(pnlLegend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(pnlSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(pnlTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(pnlMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(pnlMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addComponent(pnlSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField3ActionPerformed

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
      java.util.logging.Logger.getLogger(PurchaseTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PurchaseTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PurchaseTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PurchaseTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new PurchaseTransaction().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JTextField jTextField2;
  private javax.swing.JTextField jTextField3;
  private javax.swing.JTextField jTextField4;
  private javax.swing.JLabel lblSubTotal;
  private javax.swing.JPanel pnlLegend;
  private javax.swing.JPanel pnlMiddle;
  private javax.swing.JPanel pnlPayment;
  private javax.swing.JPanel pnlSide;
  private javax.swing.JPanel pnlTop;
  private javax.swing.JTextField txtItemID;
  private javax.swing.JTextField txtItemName;
  private javax.swing.JTextField txtItemQty;
  private javax.swing.JTextField txtItemSellPrice;
  private javax.swing.JTextField txtPayInfoCard;
  private javax.swing.JTextField txtPayInfoCash;
  private javax.swing.JTextField txtSubTotal;
  // End of variables declaration//GEN-END:variables
}
