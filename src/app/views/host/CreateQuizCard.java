/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.host;

import app.Controller;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class CreateQuizCard extends javax.swing.JPanel {
  
  /**
   * Creates new form CreateQuizCard
   */
  
  public JSONObject dataQuestion;
  public Object answers ; //answer btn (check/radio)
  public Object answersCpt; //answer text
  public CreateQuiz parentPanel;
  public int index; //index from createQuiz.nmbrQuestionCard
  
  public CreateQuizCard(CreateQuiz parentPanel) {
    initComponents();
    this.parentPanel = parentPanel;
    this.index = CreateQuiz.nmbrOfQuestionCard;
    dataQuestion = new JSONObject(); //init
    CreateQuiz.nmbrOfQuestionCard++;//increment every add new questionCard
    
    soalScroll.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
    resContainer.setBackground(new Color(0,0,0,0));
    
    
    LabelOfNumber.setText(""+CreateQuiz.nmbrOfQuestionCard+".");
    scoreField.setText(CreateQuiz.scrAll+"");
    timeField.setText(CreateQuiz.timeAll+"");
  }
  
  public CreateQuizCard(CreateQuiz parentPanel, JSONObject data){
    this(parentPanel);
    dataQuestion = data;
    soalTextArea.setText(data.getString("question"));
    String score = "" + data.getInt("grade");
    scoreField.setText(score);
    timeField.setText(""+data.getInt("time"));
    switch(data.getString("type")){
      case "MultiChoises":
        tipeBtn.setSelectedIndex(2);
        break;
      case "SingleChoise":
        tipeBtn.setSelectedIndex(1);
        break;
      case "ShortEssay":
        tipeBtn.setSelectedIndex(3);
        break;
      case "LongEssay":
        tipeBtn.setSelectedIndex(4);
        break;
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

    LabelOfNumber = new javax.swing.JLabel();
    tipeBtn = new javax.swing.JComboBox<>();
    soalScroll = new javax.swing.JScrollPane();
    soalTextArea = new javax.swing.JTextArea();
    scoreField = new javax.swing.JTextField();
    timeField = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    resContainer = new javax.swing.JPanel();
    deleteBtn = new javax.swing.JLabel();
    containerBG = new javax.swing.JLabel();

    setBackground(new java.awt.Color(255, 255, 255));
    setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    setPreferredSize(new java.awt.Dimension(725, 249));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    LabelOfNumber.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
    LabelOfNumber.setText("No.");
    add(LabelOfNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 15, -1, -1));

    tipeBtn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jenis Soal", "Pilihan Tunggal", "Pilihan Ganda", "Isian Singkat", "Essay" }));
    tipeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    tipeBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tipeBtnActionPerformed(evt);
      }
    });
    add(tipeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 13, 116, 25));

    soalTextArea.setColumns(20);
    soalTextArea.setLineWrap(true);
    soalTextArea.setRows(5);
    soalTextArea.setText("Buat soal anda disini");
    soalScroll.setViewportView(soalTextArea);

    add(soalScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 160, 170));

    scoreField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    scoreField.setText("score");
    scoreField.setBorder(null);
    scoreField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        scoreFieldKeyTyped(evt);
      }
    });
    add(scoreField, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 15, 110, 20));

    timeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    timeField.setText("time");
    timeField.setBorder(null);
    timeField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        timeFieldKeyTyped(evt);
      }
    });
    add(timeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 15, 110, 20));

    jLabel1.setFont(new java.awt.Font("MS PGothic", 1, 14)); // NOI18N
    jLabel1.setText("Kunci Jawaban :");
    add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));
    add(resContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 487, 170));

    deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/trash.png"))); // NOI18N
    deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        deleteBtnMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        deleteBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        deleteBtnMouseExited(evt);
      }
    });
    add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 16, -1, -1));

    containerBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background/CreateQuizCard.png"))); // NOI18N
    add(containerBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 730, 270));
  }// </editor-fold>//GEN-END:initComponents

  private void tipeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipeBtnActionPerformed
    int tipe = tipeBtn.getSelectedIndex();
    switch(tipe){
      case 0:
        resContainer.removeAll();
      break;
      case 1:
        resContainer.removeAll();
        if(!dataQuestion.has("_id")){
          resContainer.add(new SingleChoiseCard(this)); break;
        }
        resContainer.add(new SingleChoiseCard(this, dataQuestion));
      break;
      case 2:
        resContainer.removeAll();
        if(!dataQuestion.has("_id")){
          resContainer.add(new MultipleChoiseCard(this)); break;
        }
        resContainer.add(new MultipleChoiseCard(this, dataQuestion));
      break;
      case 3:
        resContainer.removeAll();
        if(!dataQuestion.has("_id")){
          resContainer.add(new ShortEssayCard(this)); break;
        }
        resContainer.add(new ShortEssayCard(this, dataQuestion));
      break;
      case 4:
        resContainer.removeAll();
      break;
    }
    resContainer.revalidate();
    resContainer.repaint();
  }//GEN-LAST:event_tipeBtnActionPerformed

  private void scoreFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scoreFieldKeyTyped
    Pattern pattern = Pattern.compile("[0-9]");
    Matcher matcher = pattern.matcher(evt.getKeyChar()+"");
    boolean matchFound = matcher.find();
    if(!matchFound)evt.consume();
  }//GEN-LAST:event_scoreFieldKeyTyped

  private void timeFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeFieldKeyTyped
    Pattern pattern = Pattern.compile("[0-9]");
    Matcher matcher = pattern.matcher(evt.getKeyChar()+"");
    boolean matchFound = matcher.find();
    if(!matchFound)evt.consume();
  }//GEN-LAST:event_timeFieldKeyTyped

  private void deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseEntered
    deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/trash-hover.png")));
  }//GEN-LAST:event_deleteBtnMouseEntered

  private void deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseExited
    deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/trash.png")));
  }//GEN-LAST:event_deleteBtnMouseExited

  
  private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
    
    if(Controller.
       showConfirmDialog(
               "Anda yakin mau menghapus soal ini?\nSoal yang dihapus tidak dapat dikembalikan")==0){

      if(dataQuestion.has("_id")){ //dataQuestion == one question
        parentPanel.deleteData.add(dataQuestion.getString("_id")); //parentPanel == CreateQuiz panel
      }                                                               
      
      parentPanel.cardContainer.remove(index);
      parentPanel.loopQuestionCard();
    }
  }//GEN-LAST:event_deleteBtnMouseClicked


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel LabelOfNumber;
  private javax.swing.JLabel containerBG;
  private javax.swing.JLabel deleteBtn;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel resContainer;
  public javax.swing.JTextField scoreField;
  private javax.swing.JScrollPane soalScroll;
  public javax.swing.JTextArea soalTextArea;
  public javax.swing.JTextField timeField;
  public javax.swing.JComboBox<String> tipeBtn;
  // End of variables declaration//GEN-END:variables
}
