/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.host;

import app.Controller;
import app.models.Model;
import app.models.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author User
 */
public class Login extends javax.swing.JPanel  {

  /**
   * Creates new form Login
   *
   */
  public Login() {  
    initComponents();
    Controller.setFrameTitle("Quiz Master - Login");
        
  }
  private static String globalUsername;
  private static String globalPassword;
  private static String globalName;

  
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    usernameLoginField1 = new javax.swing.JTextField();
    rememberMeCheckBox = new javax.swing.JCheckBox();
    loginBackBtn = new javax.swing.JLabel();
    loginBtn = new javax.swing.JLabel();
    daftarBtn = new javax.swing.JLabel();
    showIcon = new javax.swing.JLabel();
    passwordLoginField = new javax.swing.JPasswordField();
    passwordLoginFieldShow = new javax.swing.JTextField();
    loginBG = new javax.swing.JLabel();

    setPreferredSize(new java.awt.Dimension(799, 527));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    usernameLoginField1.setBackground(new java.awt.Color(217, 217, 217));
    add(usernameLoginField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 212, 300, 35));

    rememberMeCheckBox.setBackground(new java.awt.Color(255, 255, 255));
    rememberMeCheckBox.setForeground(new java.awt.Color(255, 255, 255));
    rememberMeCheckBox.setText(" ");
    rememberMeCheckBox.setBorder(null);
    rememberMeCheckBox.setPreferredSize(new java.awt.Dimension(30, 30));
    add(rememberMeCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 343, 20, 20));

    loginBackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBackBtn.png"))); // NOI18N
    loginBackBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    loginBackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        loginBackBtnMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        loginBackBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        loginBackBtnMouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        loginBackBtnMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        loginBackBtnMouseReleased(evt);
      }
    });
    add(loginBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

    loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBtn.png"))); // NOI18N
    loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        loginBtnMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        loginBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        loginBtnMouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        loginBtnMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        loginBtnMouseReleased(evt);
      }
    });
    add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 368, 90, 40));

    daftarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/Daftar.png"))); // NOI18N
    daftarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    daftarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        daftarBtnMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        daftarBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        daftarBtnMouseExited(evt);
      }
    });
    add(daftarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 424, -1, -1));

    showIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/closed-eye.png"))); // NOI18N
    showIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    showIcon.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        showIconMouseClicked(evt);
      }
    });
    add(showIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, -1, -1));

    passwordLoginField.setBackground(new java.awt.Color(217, 217, 217));
    add(passwordLoginField, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 296, 300, 35));

    passwordLoginFieldShow.setBackground(new java.awt.Color(217, 217, 217));
    passwordLoginFieldShow.setText("jTextField1");
    add(passwordLoginFieldShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 296, 300, 35));

    loginBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background/login.png"))); // NOI18N
    add(loginBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 527));
  }// </editor-fold>//GEN-END:initComponents

  private void loginBackBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBackBtnMouseEntered
    loginBackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBackBtn-hover.png")));
  }//GEN-LAST:event_loginBackBtnMouseEntered

  private void loginBackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBackBtnMouseClicked
    Controller.setPanel(new Home());
  }//GEN-LAST:event_loginBackBtnMouseClicked

  private void daftarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarBtnMouseClicked
    Controller.setPanel(new Register());
  }//GEN-LAST:event_daftarBtnMouseClicked

  private void loginBackBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBackBtnMouseExited
    loginBackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBackBtn.png")));
  }//GEN-LAST:event_loginBackBtnMouseExited

  private void loginBackBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBackBtnMousePressed
    loginBackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBackBtn-hover.png")));
  }//GEN-LAST:event_loginBackBtnMousePressed

  private void loginBackBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBackBtnMouseReleased
    loginBackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBackBtn.png")));
  }//GEN-LAST:event_loginBackBtnMouseReleased

  private void loginBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseEntered
    loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBtn-hover.png")));
  }//GEN-LAST:event_loginBtnMouseEntered

  private void loginBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseExited
    loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBtn.png")));
  }//GEN-LAST:event_loginBtnMouseExited

  private void loginBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMousePressed
    loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBtn-click.png")));
  }//GEN-LAST:event_loginBtnMousePressed

  private void loginBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseReleased
    loginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBtn.png")));
  }//GEN-LAST:event_loginBtnMouseReleased

  private void daftarBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarBtnMouseEntered
    daftarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/Daftar-hover.png")));
  }//GEN-LAST:event_daftarBtnMouseEntered

  private void daftarBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarBtnMouseExited
    daftarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/Daftar.png")));
  }//GEN-LAST:event_daftarBtnMouseExited

  private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseClicked
    Model users = new User();
    String username = usernameLoginField1.getText();
    String password = new String(passwordLoginField.getPassword());
    
    if(users.get(new Document().append("username", username).append("password", password)) != null){
         globalUsername = username;
         globalPassword = password;
         if(rememberMeCheckBox.isSelected()){
            try {
              FileWriter fw = new FileWriter("cache/remember.txt");
              fw.write(globalUsername + "\n");
              fw.write(globalPassword );
              fw.flush();
              fw.close();
            } catch (IOException ex) {
              Controller.showErrorDialog("Gagal menyimpan data login");
            }
         }
         Controller.setPanel(new Dashboard());
    }
  }//GEN-LAST:event_loginBtnMouseClicked
  private boolean passwordHidden = true;
  private void showIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showIconMouseClicked
     passwordHidden = !passwordHidden;
    
    passwordLoginField.setVisible(passwordHidden);
    passwordLoginFieldShow.setVisible(!passwordHidden);
    
    if(passwordHidden) passwordLoginField.requestFocus();
    else passwordLoginFieldShow.requestFocus();
    
    String icon = passwordHidden ? "closed-eye" : "eye";
    showIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/" + icon + ".png")));
  }//GEN-LAST:event_showIconMouseClicked

  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel daftarBtn;
  private javax.swing.JLabel loginBG;
  private javax.swing.JLabel loginBackBtn;
  private javax.swing.JLabel loginBtn;
  private javax.swing.JPasswordField passwordLoginField;
  private javax.swing.JTextField passwordLoginFieldShow;
  private javax.swing.JCheckBox rememberMeCheckBox;
  private javax.swing.JLabel showIcon;
  private javax.swing.JTextField usernameLoginField1;
  // End of variables declaration//GEN-END:variables
}
