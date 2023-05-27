/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.host;

import app.Controller;
import javax.swing.JOptionPane;

/**
 *
 * @author iakba
 */
public class Dashboard extends javax.swing.JPanel {

  /**
   * Creates new form Dashboard
   */
  public Dashboard() {
    initComponents();
    Controller.setFrameTitle("Quiz Master - Dashboard");
//    quizCard1.setVisible(false);
//    quizCard2.setVisible(false);
//    quizCard3.setVisible(false);
    nameTextField.setText("Ucup");
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btnLogout = new javax.swing.JLabel();
    editBtn = new javax.swing.JLabel();
    nameTextField = new javax.swing.JLabel();
    quizCard1 = new javax.swing.JLabel();
    quizCard2 = new javax.swing.JLabel();
    quizCard3 = new javax.swing.JLabel();
    background = new javax.swing.JLabel();

    setBackground(new java.awt.Color(68, 74, 74));
    setMinimumSize(new java.awt.Dimension(799, 527));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-logout-btn.png"))); // NOI18N
    btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnLogoutMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnLogoutMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        btnLogoutMouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        btnLogoutMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        btnLogoutMouseReleased(evt);
      }
    });
    add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 458, -1, -1));

    editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/pen.png"))); // NOI18N
    editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        editBtnMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        editBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        editBtnMouseExited(evt);
      }
    });
    add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 25, -1, -1));

    nameTextField.setFont(new java.awt.Font("MS Gothic", 1, 24)); // NOI18N
    nameTextField.setText("jLabel2");
    add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 20, 190, 30));

    quizCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-quiz-card1.png"))); // NOI18N
    add(quizCard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

    quizCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-quiz-card2.png"))); // NOI18N
    add(quizCard2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

    quizCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-quiz-card3.png"))); // NOI18N
    add(quizCard3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

    background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background/dashboard.png"))); // NOI18N
    add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
  }// </editor-fold>//GEN-END:initComponents

  private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
    btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-logout-btn-hover.png")));
  }//GEN-LAST:event_btnLogoutMouseEntered

  private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
    btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-logout-btn.png")));
  }//GEN-LAST:event_btnLogoutMouseExited

  private void btnLogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMousePressed
    btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-logout-btn-press.png")));
  }//GEN-LAST:event_btnLogoutMousePressed

  private void btnLogoutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseReleased
    btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-logout-btn.png")));
  }//GEN-LAST:event_btnLogoutMouseReleased

  private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
    Controller.showConfirmDialog("Anda yakin ingin melakukan Log Out?");
    Controller.setPanel(new Login());
  }//GEN-LAST:event_btnLogoutMouseClicked

  private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
    nameTextField.setText(JOptionPane.showInputDialog("Buat nama baru:"));
    
  }//GEN-LAST:event_editBtnMouseClicked

  private void editBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseEntered
    editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/pen-hover.png")));
  }//GEN-LAST:event_editBtnMouseEntered

  private void editBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseExited
    editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/pen.png")));
  }//GEN-LAST:event_editBtnMouseExited


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel background;
  private javax.swing.JLabel btnLogout;
  private javax.swing.JLabel editBtn;
  private javax.swing.JLabel nameTextField;
  private javax.swing.JLabel quizCard1;
  private javax.swing.JLabel quizCard2;
  private javax.swing.JLabel quizCard3;
  // End of variables declaration//GEN-END:variables
}
