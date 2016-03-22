/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.ui;
import com.st.beans.MasterUserBean;
import com.st.core.Main;
import com.st.process.MasterUserProcessor;
import com.st.ui.Home;
import com.st.utils.Constants;
import com.st.utils.Utilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

/**
 *
 * @author Timothy_Fab
 */
public class Login extends javax.swing.JFrame 
{
  
  /**
   * Creates new form LoginUI
   */
  public Login() {
      initComponents();
      super.setSize(367, 390);
      this.setLocationRelativeTo(null);
      
      //clear value when mouse on click
      txtUserName.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                txtUserName.setText("");
            }
        });
     
       txtPassword.setEchoChar((char)0);
       txtPassword.setText("  password");
       
       txtPassword.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                txtPassword.setText("");
                txtPassword.setEchoChar('*');
            }
        });
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMsg = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        Lmain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Form Login");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 20, 135, 29);

        txtUserName.setText(" username");
        txtUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));
        getContentPane().add(txtUserName);
        txtUserName.setBounds(110, 130, 180, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/password.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 180, 34, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/username.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 130, 34, 30);
        getContentPane().add(txtMsg);
        txtMsg.setBounds(90, 230, 190, 30);

        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));
        getContentPane().add(txtPassword);
        txtPassword.setBounds(110, 180, 180, 30);

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/ButtonLogin.png"))); // NOI18N
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(100, 280, 160, 30);

        Lmain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/st/ui/image/Background_edit_ok.png"))); // NOI18N
        getContentPane().add(Lmain);
        Lmain.setBounds(0, 0, 360, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    System.exit(0);
  }//GEN-LAST:event_formWindowClosing

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       this.processLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

  /** This method used to processes login. */
  public void processLogin()
  {
     /* Login Object. */
    MasterUserBean mub = null;
    MasterUserProcessor mup = new MasterUserProcessor();
    //Get Username and Pass
    String UserName = txtUserName.getText();
    String UserPass = String.valueOf(txtPassword.getPassword());
    
    if(Utilities.isEmpty(UserName) || 
            Utilities.isEmpty(UserPass))
    {
      txtMsg.setText("UserName atau Password kosong!!");
    }
    else
    {
      //Validate
      mub = mup.validateLogin(UserName, UserPass);
      if(null==mub)
      {
        txtMsg.setText("UserName atau Password salah!!");
      }
      else
      {
        Main.callModule(Constants.MOD_HOME);
        this.finalize();
      }
    }

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
          java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
              new Login().setVisible(true);
          }
      });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lmain;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel txtMsg;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}