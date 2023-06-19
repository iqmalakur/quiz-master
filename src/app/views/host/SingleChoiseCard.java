/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.host;

import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class SingleChoiseCard extends javax.swing.JPanel {

  /**
   * Creates new form tunggalCard
   */
  public SingleChoiseCard(CreateQuizCard card) {
    initComponents();
    JRadioButton[] radioArray = new JRadioButton[4];
    radioArray[0] = Abtn;
    radioArray[1] = Bbtn;
    radioArray[2] = Cbtn;
    radioArray[3] = Dbtn;
    card.answers = radioArray;
    
    JTextArea[] textArray = new JTextArea[4];
    textArray[0] = answerA;
    textArray[1] = answerB;
    textArray[2] = answerC;
    textArray[3] = answerD;
    card.answersCpt = textArray;
    
    
    jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
    jScrollPane2.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
    jScrollPane3.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
    jScrollPane4.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
  }
  
    public SingleChoiseCard(CreateQuizCard card, JSONObject data){
      this(card);
      if(data.getString("type").equals("SingleChoise")){
      JSONArray choisesData = data.getJSONObject("answer").getJSONArray("choises");
      int correctAnswer = data.getJSONObject("answer").getInt("correctAnswer");
      answerA.setText(choisesData.getString(0));
      answerB.setText(choisesData.getString(1));
      answerC.setText(choisesData.getString(2));
      answerD.setText(choisesData.getString(3));
        switch(correctAnswer){
          case 0:
            Abtn.setSelected(true);
            break;
          case 1:
            Bbtn.setSelected(true);
            break;
          case 2:
            Cbtn.setSelected(true);
            break;
          case 3:
            Dbtn.setSelected(true);
            break; 
        }
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

    tunggalPilihan = new javax.swing.ButtonGroup();
    Abtn = new javax.swing.JRadioButton();
    Bbtn = new javax.swing.JRadioButton();
    Cbtn = new javax.swing.JRadioButton();
    Dbtn = new javax.swing.JRadioButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    answerA = new javax.swing.JTextArea();
    jScrollPane2 = new javax.swing.JScrollPane();
    answerB = new javax.swing.JTextArea();
    jScrollPane3 = new javax.swing.JScrollPane();
    answerC = new javax.swing.JTextArea();
    jScrollPane4 = new javax.swing.JScrollPane();
    answerD = new javax.swing.JTextArea();

    setBackground(new java.awt.Color(255, 255, 255));
    setPreferredSize(new java.awt.Dimension(487, 170));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    tunggalPilihan.add(Abtn);
    add(Abtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

    tunggalPilihan.add(Bbtn);
    add(Bbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

    tunggalPilihan.add(Cbtn);
    add(Cbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

    tunggalPilihan.add(Dbtn);
    add(Dbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

    jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    answerA.setColumns(20);
    answerA.setLineWrap(true);
    answerA.setRows(5);
    jScrollPane1.setViewportView(answerA);

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 70));

    jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    answerB.setColumns(20);
    answerB.setLineWrap(true);
    answerB.setRows(5);
    jScrollPane2.setViewportView(answerB);

    add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 180, 70));

    jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    answerC.setColumns(20);
    answerC.setLineWrap(true);
    answerC.setRows(5);
    jScrollPane3.setViewportView(answerC);

    add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 180, 70));

    jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    answerD.setColumns(20);
    answerD.setLineWrap(true);
    answerD.setRows(5);
    jScrollPane4.setViewportView(answerD);

    add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 180, 70));
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JRadioButton Abtn;
  private javax.swing.JRadioButton Bbtn;
  private javax.swing.JRadioButton Cbtn;
  private javax.swing.JRadioButton Dbtn;
  private javax.swing.JTextArea answerA;
  private javax.swing.JTextArea answerB;
  private javax.swing.JTextArea answerC;
  private javax.swing.JTextArea answerD;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.ButtonGroup tunggalPilihan;
  // End of variables declaration//GEN-END:variables
}