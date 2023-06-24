/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.host;

import app.Controller;
import app.models.Model;
import app.models.Question;
import app.models.Quiz;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author User
 */
    public class CreateQuiz extends javax.swing.JPanel {
    public static int nmbrOfQuestionCard = 0;
    JSONObject quiz; //one quiz
    int index; //index QUIZ card from Dashboard
    LinkedList<CreateQuizCard> listCard = new LinkedList<>(); //list contain data might saved
    public static int scrAll=100;
    public static int timeAll=60;
    ArrayList<String> deleteData = new ArrayList<>(); //array contains data might deleted
    boolean toggleON = true;
  /**
   * Creates new form CreayeQuiz
   */
  public CreateQuiz(int index) {
    initComponents();
    this.quiz = Dashboard.quizList.get(index);
    this.index = index;
    judulField.setBackground(new Color(0,0,0,0));
    judulField.setDisabledTextColor(Color.black);
    timeAllField.setBackground(new Color(0,0,0,0));
    scoreAllField.setBackground(new Color(0,0,0,0));
    containerScroll.getVerticalScrollBar().setUnitIncrement(16);
    judulField.setText(quiz.getString("name"));
    infoField.setText(quiz.getString("optField"));
    idLabel.setText("Kode: "+quiz.getString("code"));

  
    //opt field condition
    if(!quiz.getString("optField").equals("")){
      infoCheck.setSelected(toggleON);
      infoField.setEnabled(toggleON);
    }
            
    loopQuestionCard();//build every question card
//    System.out.println(listCard);
  }
  
  public void loopQuestionCard(){
    cardContainer.removeAll();
    nmbrOfQuestionCard = 0;
    listCard = new LinkedList<>();
    
    Model question = new Question();
    quiz.getJSONArray("questions").forEach(item ->{ // item = idQuestion
      if(!deleteData.contains(item)){
        listCard.addLast(new CreateQuizCard(this, question.get((String)item)));
        cardContainer.add(listCard.getLast());
      }
    
    });
    cardContainer.repaint();
    cardContainer.revalidate();
    
    //guide txt filter
    if(nmbrOfQuestionCard == 0 )teksLabel.setVisible(true);
    else teksLabel.setVisible(false);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    homeBtn = new javax.swing.JLabel();
    saveBtn = new javax.swing.JLabel();
    addBtn = new javax.swing.JLabel();
    idLabel = new javax.swing.JLabel();
    penBtn = new javax.swing.JLabel();
    copyBtn = new javax.swing.JLabel();
    teksLabel = new javax.swing.JLabel();
    containerScroll = new javax.swing.JScrollPane();
    cardContainer = new javax.swing.JPanel();
    timeAllField = new javax.swing.JTextField();
    scoreAllField = new javax.swing.JTextField();
    judulField = new javax.swing.JTextField();
    infoField = new javax.swing.JTextField();
    infoCheck = new javax.swing.JCheckBox();
    createQuizBG = new javax.swing.JLabel();

    setBackground(new java.awt.Color(68, 74, 74));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard.png"))); // NOI18N
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
    });
    add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 27, -1, -1));

    saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/saveIcon.png"))); // NOI18N
    saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        saveBtnMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        saveBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        saveBtnMouseExited(evt);
      }
    });
    add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 27, -1, -1));

    addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/tambahBtn.png"))); // NOI18N
    addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        addBtnMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        addBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        addBtnMouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        addBtnMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        addBtnMouseReleased(evt);
      }
    });
    add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 110, 50));

    idLabel.setFont(new java.awt.Font("Comic Sans MS", 2, 16)); // NOI18N
    idLabel.setForeground(new java.awt.Color(102, 102, 102));
    idLabel.setText("id: abcd123");
    add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

    penBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/pen.png"))); // NOI18N
    penBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    penBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        penBtnMouseClicked(evt);
      }
    });
    add(penBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

    copyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/copy.png"))); // NOI18N
    copyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    copyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        copyBtnMouseClicked(evt);
      }
    });
    add(copyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 20, 30));

    teksLabel.setBackground(new java.awt.Color(153, 153, 153));
    teksLabel.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
    teksLabel.setForeground(new java.awt.Color(153, 153, 153));
    teksLabel.setText("Klik tombol tambah untuk menambahkan soal baru");
    add(teksLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

    containerScroll.setBorder(null);
    containerScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    containerScroll.setColumnHeaderView(cardContainer);
    containerScroll.setRowHeaderView(cardContainer);

    cardContainer.setLayout(new javax.swing.BoxLayout(cardContainer, javax.swing.BoxLayout.PAGE_AXIS));
    containerScroll.setViewportView(cardContainer);

    add(containerScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 740, 310));

    timeAllField.setFont(new java.awt.Font("MS Gothic", 1, 16)); // NOI18N
    timeAllField.setForeground(new java.awt.Color(255, 255, 255));
    timeAllField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    timeAllField.setText("60");
    timeAllField.setBorder(null);
    timeAllField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    timeAllField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        timeAllFieldKeyReleased(evt);
      }
      public void keyTyped(java.awt.event.KeyEvent evt) {
        timeAllFieldKeyTyped(evt);
      }
    });
    add(timeAllField, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 110, 115, 25));

    scoreAllField.setFont(new java.awt.Font("MS Gothic", 1, 16)); // NOI18N
    scoreAllField.setForeground(new java.awt.Color(255, 255, 255));
    scoreAllField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    scoreAllField.setText("100");
    scoreAllField.setBorder(null);
    scoreAllField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
    scoreAllField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        scoreAllFieldKeyReleased(evt);
      }
      public void keyTyped(java.awt.event.KeyEvent evt) {
        scoreAllFieldKeyTyped(evt);
      }
    });
    add(scoreAllField, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 110, 115, 25));

    judulField.setFont(new java.awt.Font("MS Gothic", 1, 14)); // NOI18N
    judulField.setText("judul");
    judulField.setBorder(null);
    judulField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
    judulField.setEnabled(false);
    judulField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        judulFieldKeyTyped(evt);
      }
    });
    add(judulField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 190, 30));

    infoField.setFont(new java.awt.Font("MS UI Gothic", 1, 12)); // NOI18N
    infoField.setEnabled(false);
    add(infoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 120, -1));

    infoCheck.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        infoCheckActionPerformed(evt);
      }
    });
    add(infoCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 63, -1, -1));

    createQuizBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background/createQuizcard2.png"))); // NOI18N
    add(createQuizBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
  }// </editor-fold>//GEN-END:initComponents

  private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseClicked
    if(Controller.showConfirmDialog("Apakah anda yakin ingin keluar?\nData yang belum disimpan akan hilang")==0){
      Controller.setPanel(new Dashboard());
      nmbrOfQuestionCard = 0;
    }
  }//GEN-LAST:event_homeBtnMouseClicked
  
  private void penBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penBtnMouseClicked
    toggleON = !toggleON; 
      
    String icon = toggleON ? "confirm" : "pen";
    penBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/" + icon + ".png")));
    
    if(toggleON) {
      judulField.setEnabled(true);
      judulField.requestFocus();
    }
    else{ 
      judulField.setEnabled(false);
      JSONObject dataQuiz = new JSONObject().put("name", judulField.getText());
      quiz = new Quiz().update(dataQuiz, quiz.getString("_id"));
      Dashboard.quizList.set(index, quiz);
    }
  }//GEN-LAST:event_penBtnMouseClicked

  private void copyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyBtnMouseClicked
    String strID = idLabel.getText();
    String[] arrstrID = strID.split(" ");
    StringSelection stringSelection = new StringSelection(arrstrID[1]);
    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
    clpbrd.setContents(stringSelection, null);
    Controller.showInformationDialog("id: \""+arrstrID[1]+"\" disalin ke clipboard", "");
  }//GEN-LAST:event_copyBtnMouseClicked

  
  private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
    remove(teksLabel);
    listCard.addLast(new CreateQuizCard(this));
    cardContainer.add(listCard.getLast());
    
    repaint();
    revalidate();
  }//GEN-LAST:event_addBtnMouseClicked

  private void addBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMousePressed
    addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/tambahBtn-click.png")));
  }//GEN-LAST:event_addBtnMousePressed

  private void addBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseReleased
    addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/tambahBtn.png")));
  }//GEN-LAST:event_addBtnMouseReleased

  private void addBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseEntered
    addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/tambahBtn-hover.png")));
  }//GEN-LAST:event_addBtnMouseEntered

  private void addBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseExited
    addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/tambahBtn.png")));
  }//GEN-LAST:event_addBtnMouseExited

  private void scoreAllFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scoreAllFieldKeyTyped
    Pattern pattern = Pattern.compile("[0-9]");
    Matcher matcher = pattern.matcher(evt.getKeyChar()+"");
    boolean matchFound = matcher.find();
    if(!matchFound)evt.consume();
  }//GEN-LAST:event_scoreAllFieldKeyTyped

  private void timeAllFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeAllFieldKeyTyped
    Pattern pattern = Pattern.compile("[0-9]");
    Matcher matcher = pattern.matcher(evt.getKeyChar()+"");
    boolean matchFound = matcher.find();
    if(!matchFound)evt.consume();
  }//GEN-LAST:event_timeAllFieldKeyTyped

  private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
    listCard.forEach(item ->{
      CreateQuizCard card = (CreateQuizCard) item;
      
      Model questionModel = new Question();
      JSONObject answer = new JSONObject();
      String tipe = "";
      switch((int)card.tipeBtn.getSelectedIndex()){
        case 1:
          tipe = "SingleChoise";
          
          //update correct answer
          JRadioButton[] radioArray = (JRadioButton[])item.answers;
          JTextArea[] textArray = (JTextArea[])item.answersCpt;
          JSONArray y = new JSONArray();
          
          for (int i = 0 ; i < 4 ; i++){
            if(radioArray[i].isSelected())
              answer.put("correctAnswer", i);
            y.put(textArray[i].getText());
          }
            answer.put("choises", y);
          
          break;
        case 2:
          tipe = "MultiChoises";
          
          //update correct answer
          JCheckBox[] checkArray = (JCheckBox[])item.answers;
          JTextArea[] textArray2 = (JTextArea[])item.answersCpt;
          JSONArray answerPoint = new JSONArray();
          JSONArray answerTXT = new JSONArray();
          
          for (int i = 0 ; i < 4 ; i++){
            if(checkArray[i].isSelected())answerPoint.put(i);
            answerTXT.put(textArray2[i].getText());
          }
          answer.put("correctAnswer", answerPoint); // answer point == check/radio
          answer.put("choises", answerTXT);
          
          break;
        case 3:
          tipe = "ShortEssay";
          
          answer.put("correctAnswer", ((JTextField)item.answers).getText());
          break;
        case 4:
          tipe = "LongEssay";
          break;
      }
     
      
      if(card.scoreField.getText().equals("")||
         card.timeField.getText().equals("")||
         tipe.equals("") ||
         card.soalTextArea.getText().equals("")||
         answer.getString("correctAnswer").equals("")||
         answer.has("choises") && answer.getString("choises").equals("")
         )
      {
        Controller.showErrorDialog("Lengkapi semua field yang tersedia!");
        
        return;
      }
      
      card.dataQuestion
              .put("grade", Integer.parseInt(card.scoreField.getText()))
              .put("time",Integer.parseInt(card.timeField.getText()))
              .put("type", tipe)
              .put("question", card.soalTextArea.getText())
              .put("answer", answer)
          ;
      
      if(card.dataQuestion.has("_id")){
        questionModel.update(card.dataQuestion, card.dataQuestion.getString("_id"));
      }else {
        questionModel.insert(card.dataQuestion);
        quiz.put("questions", quiz.getJSONArray("questions").put(card.dataQuestion.getString("_id")));
        new Quiz().update(quiz, quiz.getString("_id"));
      }
    });
    
    deleteData.forEach(item -> {
      JSONArray idQuestions = quiz.getJSONArray("questions");
      for (int i = 0 ; i < idQuestions.length() ; i++){
        if (idQuestions.getString(i).equals(item))
          idQuestions.remove(i);
      }
      quiz.put("questions", idQuestions);
      new Question().delete(item);
      quiz = new Quiz().update(quiz, quiz.getString("_id"));
    });
    
    //opt field filter
    JSONObject dataInfoTambahan = new JSONObject();
    if(!infoCheck.isSelected())dataInfoTambahan = new JSONObject().put("optField", "");
    else dataInfoTambahan = new JSONObject().put("optField", infoField.getText());
    //quiz query update for opt field
    quiz = new Quiz().update(dataInfoTambahan, quiz.getString("_id"));
    
    Controller.showInformationDialog("Data Berhasil Disimpan!", "Sukses");
  }//GEN-LAST:event_saveBtnMouseClicked

  private void scoreAllFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scoreAllFieldKeyReleased
    scrAll = Integer.parseInt(scoreAllField.getText());
  }//GEN-LAST:event_scoreAllFieldKeyReleased

  private void timeAllFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeAllFieldKeyReleased
    timeAll = Integer.parseInt(timeAllField.getText());
    // TODO add your handling code here:
  }//GEN-LAST:event_timeAllFieldKeyReleased

  private void infoCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoCheckActionPerformed
    if(!infoCheck.isSelected()){
      infoField.setEnabled(false);
      infoField.setText("");
      return;
    }
    infoField.setEnabled(true);
  }//GEN-LAST:event_infoCheckActionPerformed

  private void homeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseEntered
    homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard-hover.png")));
  }//GEN-LAST:event_homeBtnMouseEntered

  private void homeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseExited
    homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/dashboard.png")));
  }//GEN-LAST:event_homeBtnMouseExited

  private void saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseEntered
    saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/save-hover.png")));
  }//GEN-LAST:event_saveBtnMouseEntered

  private void saveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseExited
    saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/saveIcon.png")));
  }//GEN-LAST:event_saveBtnMouseExited

  private void judulFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_judulFieldKeyTyped
    if(judulField.getText().length() > 24)evt.consume();
  }//GEN-LAST:event_judulFieldKeyTyped


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel addBtn;
  private javax.swing.ButtonGroup buttonGroup1;
  public javax.swing.JPanel cardContainer;
  private javax.swing.JScrollPane containerScroll;
  private javax.swing.JLabel copyBtn;
  private javax.swing.JLabel createQuizBG;
  private javax.swing.JLabel homeBtn;
  private javax.swing.JLabel idLabel;
  private javax.swing.JCheckBox infoCheck;
  private javax.swing.JTextField infoField;
  private javax.swing.JTextField judulField;
  private javax.swing.JLabel penBtn;
  private javax.swing.JLabel saveBtn;
  private javax.swing.JTextField scoreAllField;
  private javax.swing.JLabel teksLabel;
  private javax.swing.JTextField timeAllField;
  // End of variables declaration//GEN-END:variables
}
