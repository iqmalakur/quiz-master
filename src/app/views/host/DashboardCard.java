/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.host;

import app.Controller;
import java.awt.Color;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class DashboardCard extends javax.swing.JPanel {
  public int index; 
  public static int COUNT = 0;
  /**
   * Creates new form DashboardCard
   */
  public DashboardCard() {
    initComponents();
    index = COUNT;
    COUNT++;
    setBackground(new Color(0,0,0,0));
    setVisible(true);
  }
  public DashboardCard(JSONObject data) {
    this();
     cardTitle.setText(data.getString("name"));
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    deleteBtn = new javax.swing.JLabel();
    cardTitle = new javax.swing.JLabel();
    openQuizBtn = new javax.swing.JLabel();
    openScoreBtn = new javax.swing.JLabel();
    cardBG = new javax.swing.JLabel();

    setPreferredSize(new java.awt.Dimension(136, 121));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/delete.png"))); // NOI18N
    deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        deleteBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        deleteBtnMouseExited(evt);
      }
    });
    add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 7, -1, -1));

    cardTitle.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
    cardTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    cardTitle.setText("title");
    cardTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    add(cardTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, 120, 40));

    openQuizBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/openQuizBtn.png"))); // NOI18N
    openQuizBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    openQuizBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        openQuizBtnMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        openQuizBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        openQuizBtnMouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        openQuizBtnMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        openQuizBtnMouseReleased(evt);
      }
    });
    add(openQuizBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 55, -1, -1));

    openScoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/openScoreBtn.png"))); // NOI18N
    openScoreBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    openScoreBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        openScoreBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        openScoreBtnMouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        openScoreBtnMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        openScoreBtnMouseReleased(evt);
      }
    });
    add(openScoreBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 77, -1, -1));

    cardBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-card.png"))); // NOI18N
    add(cardBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 120));
  }// </editor-fold>//GEN-END:initComponents

  private void openQuizBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openQuizBtnMouseEntered
    openQuizBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/openQuizBtn-hover.png")));
  }//GEN-LAST:event_openQuizBtnMouseEntered

  private void openQuizBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openQuizBtnMouseExited
    openQuizBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/openQuizBtn.png")));
  }//GEN-LAST:event_openQuizBtnMouseExited

  private void openScoreBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openScoreBtnMouseEntered
    openScoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/openScoreBtn-hover.png")));
  }//GEN-LAST:event_openScoreBtnMouseEntered

  private void openScoreBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openScoreBtnMouseExited
    // TODO add your handling code here:
    openScoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/openScoreBtn.png")));
  }//GEN-LAST:event_openScoreBtnMouseExited

  private void openQuizBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openQuizBtnMousePressed
    // TODO add your handling code here:
    openQuizBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/openQuizBtn-click.png")));
  }//GEN-LAST:event_openQuizBtnMousePressed

  private void openQuizBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openQuizBtnMouseReleased
    // TODO add your handling code here:
    openQuizBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/openQuizBtn.png")));
  }//GEN-LAST:event_openQuizBtnMouseReleased

  private void openScoreBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openScoreBtnMousePressed
    // TODO add your handling code here:
    openScoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/openScoreBtn-click.png")));
  }//GEN-LAST:event_openScoreBtnMousePressed

  private void openScoreBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openScoreBtnMouseReleased
    // TODO add your handling code here:
    openScoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/openScoreBtn.png")));
  }//GEN-LAST:event_openScoreBtnMouseReleased

  private void openQuizBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openQuizBtnMouseClicked
    Controller.setPanel(new CreateQuiz(index));  
  }//GEN-LAST:event_openQuizBtnMouseClicked

  private void deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseEntered
    deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/delete-hover.png")));
  }//GEN-LAST:event_deleteBtnMouseEntered

  private void deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseExited
    deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/delete.png")));
  }//GEN-LAST:event_deleteBtnMouseExited


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel cardBG;
  private javax.swing.JLabel cardTitle;
  private javax.swing.JLabel deleteBtn;
  private javax.swing.JLabel openQuizBtn;
  private javax.swing.JLabel openScoreBtn;
  // End of variables declaration//GEN-END:variables
}
