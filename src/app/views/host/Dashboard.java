/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.host;

import app.Controller;
import app.models.Model;
import app.models.Quiz;
import app.models.User;
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author iakba
 */
public class Dashboard extends javax.swing.JPanel {

  /**
   * Creates new form Dashboard
   */
  public Dashboard() {
    DashboardCard.COUNT=0;
    initComponents();
    Controller.setFrameTitle("Quiz Master - Dashboard");
    containerCardPanel.setBackground(new Color (0,0,0,0));
    nameTextField.setBackground(new Color(0,0,0,0));
    nameTextField.setDisabledTextColor(Color.black);
    
    String nama = Login.getUSER().getString("name");
    nameTextField.setText(nama);
    
    Model quiz = new Quiz();
    Login.getUSER().getJSONArray("quizzes").forEach(item -> {
      containerCardPanel.remove(DashboardCard.COUNT);
      containerCardPanel.add(new DashboardCard(quiz.get((String)item)));
      if (DashboardCard.COUNT != 3) containerCardPanel.add(addCardBtn);
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

    btnLogout = new javax.swing.JLabel();
    editBtn = new javax.swing.JLabel();
    containerCardPanel = new javax.swing.JPanel();
    addCardBtn = new javax.swing.JLabel();
    homeBtn = new javax.swing.JLabel();
    nameTextField = new javax.swing.JTextField();
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
    });
    add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 25, -1, -1));

    containerCardPanel.setBackground(new java.awt.Color(255, 255, 255));

    addCardBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-quiz-card-add.png"))); // NOI18N
    addCardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    addCardBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        addCardBtnMouseClicked(evt);
      }
    });
    containerCardPanel.add(addCardBtn);

    add(containerCardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 470, 170));

    homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-home.png"))); // NOI18N
    homeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        homeBtnMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        homeBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        homeBtnMouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        homeBtnMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        homeBtnMouseReleased(evt);
      }
    });
    add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(-45, 120, -1, -1));

    nameTextField.setFont(new java.awt.Font("MS Gothic", 1, 24)); // NOI18N
    nameTextField.setText("jTextField1");
    nameTextField.setBorder(null);
    nameTextField.setEnabled(false);
    add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 20, 190, 30));

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
    int check = Controller.showConfirmDialog("Anda yakin ingin melakukan Log Out?");
    if(check == 0){
      Controller.setPanel(new Login());
      Login.setUSER(null);
      try(FileWriter fw = new FileWriter("cache/remember.txt")){} catch (IOException ex) {}
    }
  }//GEN-LAST:event_btnLogoutMouseClicked

  boolean toggleON = true;
  private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
    toggleON = !toggleON; 
      
    String icon = toggleON ? "confirm" : "pen";
    editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/" + icon + ".png")));
    
    if(toggleON) {
      nameTextField.setEnabled(true);
      nameTextField.requestFocus();
    }
    else{ 
      nameTextField.setEnabled(false);
      JSONObject dataUser = new JSONObject().put("name", nameTextField.getText());
      new User().update(dataUser, Login.getUSER().getString("_id"));
      
    }
  }//GEN-LAST:event_editBtnMouseClicked

  private void homeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseEntered
    homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-home-hover.png")));
  }//GEN-LAST:event_homeBtnMouseEntered

  private void homeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseExited
    homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-home.png")));
  }//GEN-LAST:event_homeBtnMouseExited

  private void homeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMousePressed
    homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-home-click.png")));
  }//GEN-LAST:event_homeBtnMousePressed

  private void homeBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseReleased
    homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-home.png")));
  }//GEN-LAST:event_homeBtnMouseReleased

  private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseClicked
    Controller.setPanel(new Home());
  }//GEN-LAST:event_homeBtnMouseClicked

  private void addCardBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCardBtnMouseClicked
    Model quiz = new Quiz();
    boolean codeIsExist = true;
    
    containerCardPanel.remove(DashboardCard.COUNT);
    containerCardPanel.add(new DashboardCard());
    String karakter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    
    StringBuilder codeQuiz = new StringBuilder();
    Random rnd = new Random();
    while(codeIsExist){
      while (codeQuiz.length() < 5) { // length of the random string.
          int index = (int) (rnd.nextFloat() * karakter.length());
          codeQuiz.append(karakter.charAt(index));
      }
      
      JSONObject quizCheck = quiz.get("code", codeQuiz.toString());
      if(quizCheck == null) codeIsExist =  false;
    }
    
    JSONObject dataQuiz = new JSONObject()
    .put("respondents",new JSONArray())
    .put("code",codeQuiz.toString())
    .put("name","Quiz"+DashboardCard.COUNT)
    .put("questions",new JSONArray())
    .put("optField","")
    ;
    
    quiz.insert(dataQuiz);
    String s = dataQuiz.getString("_id");
    Login.getUSER().getJSONArray("quizzes").put(s);
    new User().update(Login.getUSER(), Login.getUSER().getString("_id"));
            
    if (DashboardCard.COUNT != 3) containerCardPanel.add(addCardBtn);
    revalidate();
    repaint();
  }//GEN-LAST:event_addCardBtnMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel addCardBtn;
  private javax.swing.JLabel background;
  private javax.swing.JLabel btnLogout;
  private javax.swing.JPanel containerCardPanel;
  private javax.swing.JLabel editBtn;
  private javax.swing.JLabel homeBtn;
  private javax.swing.JTextField nameTextField;
  // End of variables declaration//GEN-END:variables
}
