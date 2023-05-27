/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.host;

import app.Controller;
import app.models.Model;
import app.models.User;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author iakba
 */
public class Register extends javax.swing.JPanel {
  private boolean passwordHidden = true;

  /**
   * Creates new form Register
   *
   */
  public Register() {
    initComponents();
    Controller.setFrameTitle("Quiz Master - Register");
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    nameField = new javax.swing.JTextField();
    usernameField = new javax.swing.JTextField();
    eyeIcon = new javax.swing.JLabel();
    passwordField = new javax.swing.JPasswordField();
    passwordFieldUnhide = new javax.swing.JTextField();
    quoteText = new javax.swing.JLabel();
    quoteSource = new javax.swing.JLabel();
    btnSend = new javax.swing.JLabel();
    btnBack = new javax.swing.JLabel();
    background = new javax.swing.JLabel();

    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    nameField.setBackground(new java.awt.Color(217, 217, 217));
    add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 212, 300, 35));

    usernameField.setBackground(new java.awt.Color(217, 217, 217));
    add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 296, 300, 35));

    eyeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/closed-eye.png"))); // NOI18N
    eyeIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    eyeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        eyeIconMouseClicked(evt);
      }
    });
    add(eyeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 389, -1, -1));

    passwordField.setBackground(new java.awt.Color(217, 217, 217));
    passwordField.setCaretColor(new java.awt.Color(230, 230, 230));
    passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        passwordFieldKeyReleased(evt);
      }
    });
    add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 385, 300, 35));

    passwordFieldUnhide.setBackground(new java.awt.Color(217, 217, 217));
    passwordFieldUnhide.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        passwordFieldUnhideKeyReleased(evt);
      }
    });
    add(passwordFieldUnhide, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 385, 300, 35));

    quoteText.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
    quoteText.setForeground(new java.awt.Color(255, 255, 255));
    quoteText.setText("quote text");
    add(quoteText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

    quoteSource.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
    quoteSource.setForeground(new java.awt.Color(255, 255, 255));
    quoteSource.setText("- quote source");
    add(quoteSource, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

    btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/register-submit-btn.png"))); // NOI18N
    btnSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnSend.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnSendMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnSendMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        btnSendMouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        btnSendMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        btnSendMouseReleased(evt);
      }
    });
    add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 442, -1, -1));

    btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/register-back-btn.png"))); // NOI18N
    btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnBackMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnBackMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        btnBackMouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        btnBackMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        btnBackMouseReleased(evt);
      }
    });
    add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 38, -1, -1));

    background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background/register.png"))); // NOI18N
    add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
  }// </editor-fold>//GEN-END:initComponents

  private void btnSendMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendMouseEntered
    btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/register-submit-btn-hover.png")));
  }//GEN-LAST:event_btnSendMouseEntered

  private void btnSendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendMouseExited
    btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/register-submit-btn.png")));
  }//GEN-LAST:event_btnSendMouseExited

  private void btnSendMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendMousePressed
    btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/register-submit-btn-press.png")));
  }//GEN-LAST:event_btnSendMousePressed

  private void btnSendMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendMouseReleased
    btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/register-submit-btn.png")));
  }//GEN-LAST:event_btnSendMouseReleased

  private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
    Controller.setPanel(new Login());
  }//GEN-LAST:event_btnBackMouseClicked

  private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
    btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/registBackBtn-hover.png")));
  }//GEN-LAST:event_btnBackMouseEntered

  private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
    btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/register-back-btn.png")));
  }//GEN-LAST:event_btnBackMouseExited

  private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
    btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/registBackBtn-click.png")));
  }//GEN-LAST:event_btnBackMousePressed

  private void btnBackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseReleased
    btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/register-back-btn.png")));
  }//GEN-LAST:event_btnBackMouseReleased

  private void btnSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendMouseClicked
    String name = nameField.getText();
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());
    
    Model user = new User();
    
    Document userExist = user.get("username", username);
    
    if(userExist != null){
      Controller.showErrorDialog("Username telah terdaftar!");
      return;
    }
    
    if(password.length() < 8){
      Controller.showErrorDialog("Panjang password minimal 8 karakter!");
      return;
    }
    
    if(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")){
      Controller.showErrorDialog("Password harus terdapat setidaknya 1 huruf kecil, 1 huruf besar, dan 1 angka!");
      return;
    }
    
    Document data = new Document()
      .append("name", name)
      .append("username", username)
      .append("password", password)
      .append("quizzes", new ArrayList<ObjectId>())
    ;
    
    if(user.insert(data)){
      Controller.showInformationDialog("Berhasil melakukan Register!\nSilakan login kembali");
      Controller.setPanel(new Login());
    } else{
      Controller.showErrorDialog("Gagal melakukan Register!");
    }
  }//GEN-LAST:event_btnSendMouseClicked

  private void eyeIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeIconMouseClicked
    passwordHidden = !passwordHidden;
    
    passwordField.setVisible(passwordHidden);
    passwordFieldUnhide.setVisible(!passwordHidden);
    
    if(passwordHidden) passwordField.requestFocus();
    else passwordFieldUnhide.requestFocus();
    
    String icon = passwordHidden ? "closed-eye" : "eye";
    eyeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/" + icon + ".png")));
  }//GEN-LAST:event_eyeIconMouseClicked

  private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyReleased
    passwordFieldUnhide.setText(new String(passwordField.getPassword()));
  }//GEN-LAST:event_passwordFieldKeyReleased

  private void passwordFieldUnhideKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldUnhideKeyReleased
    passwordField.setText(passwordFieldUnhide.getText());
  }//GEN-LAST:event_passwordFieldUnhideKeyReleased


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel background;
  private javax.swing.JLabel btnBack;
  private javax.swing.JLabel btnSend;
  private javax.swing.JLabel eyeIcon;
  private javax.swing.JTextField nameField;
  private javax.swing.JPasswordField passwordField;
  private javax.swing.JTextField passwordFieldUnhide;
  private javax.swing.JLabel quoteSource;
  private javax.swing.JLabel quoteText;
  private javax.swing.JTextField usernameField;
  // End of variables declaration//GEN-END:variables
}
