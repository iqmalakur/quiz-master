/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.host;

import app.Controller;
import app.models.Model;
import app.models.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

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
    
    LinkedList<JSONObject> quotes = getQuotes();
    
    if(quotes.size() > 0){
      new Thread(() -> {
        while(true){
          Random rand = new Random();
          int i = rand.nextInt(quotes.size());

          String quoteText = quotes.get(i).getString("quote");
          String quote = "";

          try{
            for(int j = 0; j < quoteText.length(); j++){
              quote += quoteText.charAt(j);
              quoteLabel.setText("<html>" + quote + "</html>");
              Thread.sleep(50);
            }

            quote += "<br/><div style=\"text-align: right; margin-top: 20px;\">- "
                    + quotes.get(i).getString("source")
                    + "</div>";
            quoteLabel.setText("<html>" + quote + "</html>");

            Thread.sleep(5000);
          } catch(InterruptedException e){}
        }
      }, "quote")
      .start();
    }
  }
  
  private static JSONObject USER;

  public static JSONObject getUSER() {
    return USER;
  }

  public static void setUSER(JSONObject USER) {
    Login.USER = USER;
  }
  
  public static LinkedList<JSONObject> getQuotes() {
    File quoteFile = new File("data/Quotes.json");
    
    if(!quoteFile.exists()){
      try(OutputStream dataWrite = new FileOutputStream(quoteFile)){
        String quoteStr = "[]";
        dataWrite.write(quoteStr.getBytes());
      } catch(IOException e){}
    }
    
    try(InputStream dataRead = new FileInputStream(quoteFile)) {
      byte[] byteData = dataRead.readAllBytes();
      
      JSONArray data = new JSONArray(new String(byteData));
      LinkedList<JSONObject> result = new LinkedList<>();

      // Mengisi linked list dengan data pada file JSON
      data.forEach(item -> result.add((JSONObject) item));

      return result;
    } catch(IOException e){
      return null;
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

    usernameLoginField1 = new javax.swing.JTextField();
    rememberMeCheckBox = new javax.swing.JCheckBox();
    loginBackBtn = new javax.swing.JLabel();
    loginBtn = new javax.swing.JLabel();
    daftarBtn = new javax.swing.JLabel();
    showIcon = new javax.swing.JLabel();
    passwordLoginField = new javax.swing.JPasswordField();
    passwordLoginFieldShow = new javax.swing.JTextField();
    quoteLabel = new javax.swing.JLabel();
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
    passwordLoginField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        passwordLoginFieldKeyReleased(evt);
      }
    });
    add(passwordLoginField, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 296, 300, 35));

    passwordLoginFieldShow.setBackground(new java.awt.Color(217, 217, 217));
    passwordLoginFieldShow.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        passwordLoginFieldShowKeyReleased(evt);
      }
    });
    add(passwordLoginFieldShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 296, 300, 35));

    quoteLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
    quoteLabel.setForeground(new java.awt.Color(255, 255, 255));
    quoteLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    add(quoteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 240, 250));

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
    JSONObject user = users.get(new JSONObject().put("username", username).put("password", password));
    
    if("".equals(username) || "".equals(password)){
      Controller.showErrorDialog(
              "Username dan Password tidak boleh kosong"); return;
    }
    if(user == null){ 
      Controller.showErrorDialog(
              "Username atau Password yang anda masukkan salah!"); return;
    }
    if(rememberMeCheckBox.isSelected()){
       try {
         FileWriter fw = new FileWriter("cache/remember.txt");
         fw.write(username + "\n");
         fw.write(password );
         fw.flush();
         fw.close();
       } catch (IOException ex) {
         Controller.showErrorDialog("Gagal menyimpan data login");
       }
    }
    Login.setUSER(user);
    Controller.setPanel(new Dashboard());
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

  private void passwordLoginFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordLoginFieldKeyReleased
    passwordLoginFieldShow.setText(new String(passwordLoginField.getPassword()));  
  }//GEN-LAST:event_passwordLoginFieldKeyReleased

  private void passwordLoginFieldShowKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordLoginFieldShowKeyReleased
    passwordLoginField.setText(passwordLoginFieldShow.getText());
  }//GEN-LAST:event_passwordLoginFieldShowKeyReleased

  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel daftarBtn;
  private javax.swing.JLabel loginBG;
  private javax.swing.JLabel loginBackBtn;
  private javax.swing.JLabel loginBtn;
  private javax.swing.JPasswordField passwordLoginField;
  private javax.swing.JTextField passwordLoginFieldShow;
  private javax.swing.JLabel quoteLabel;
  private javax.swing.JCheckBox rememberMeCheckBox;
  private javax.swing.JLabel showIcon;
  private javax.swing.JTextField usernameLoginField1;
  // End of variables declaration//GEN-END:variables
}
