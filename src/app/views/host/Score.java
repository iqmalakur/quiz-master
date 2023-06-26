/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.host;

import app.Controller;
import app.models.Model;
import app.models.Question;
import app.models.Respondent;
import java.awt.Cursor;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class Score extends javax.swing.JPanel {
  private static LinkedList<JSONObject> respondents;
  private static LinkedList<JSONObject> quizAnswer;
  private static JSONObject respondent;
  
  /**
   * Creates new form Score
   */
  public Score(JSONObject quiz) {
    initComponents();
    namaLabel.setVisible(false);
    Model respondentModel = new Respondent();
    boolean haveOptField = !quiz.getString("optField").equals("");
    
    respondents = new LinkedList<>();
    quiz.getJSONArray("respondents").forEach(res -> {
      respondents.add(respondentModel.get((String) res));
    });
    
    Object[][] dataTable = new Object[respondents.size()][haveOptField ? 5 : 4];
    
    // Mengurutkan data berdasarkan score dan answer time
    respondents.sort((x, y) -> {
      Integer score1 = x.getInt("score");
      Integer score2 = y.getInt("score");
      
      Integer time1 = x.getInt("answerTime");
      Integer time2 = y.getInt("answerTime");
      
      int score = score2.compareTo(score1);
      int time = time1.compareTo(time2);
      
      return score == 0 ? time : score;
    });
    
    int i = 0;
    for(JSONObject respondent : respondents){
      dataTable[i][1] = respondent.getString("name");
      dataTable[i][haveOptField ? 3 : 2] = respondent.getInt("score") + " point";
      dataTable[i][haveOptField ? 4 : 3] = convertTime(respondent.getInt("answerTime"));
      
      if(haveOptField)
        dataTable[i][2] = respondent.getString("optFieldValue");
      
      dataTable[i][0] = ++i;
    }
    
    String[] column = haveOptField ?
      new String [] { "No.", "Nama", quiz.getString("optField"), "Skor", "Waktu" } :
      new String[] { "No.", "Nama", "Skor", "Waktu" }; 
    
    scoreTable.setModel(new DefaultTableModel(dataTable, column){
      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
      }
    });
    
    scoreTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
    showBtn.setVisible(false);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
  }
  
  private String convertTime(int second){
    String result = "";
    
    int hour = second / 3600;
    if(hour != 0) result += (hour + " jam ");
    
    int minute = second % 3600 / 60;
    if(minute != 0) result += (minute + " menit ");
    
    second = second % 3600 % 60;
    result += second + " detik";
    
    return result;
  }
  
  public static void setRespondents(LinkedList<JSONObject> respondents) {
    Score.respondents = respondents;
  }

  public static JSONObject getRespondent(int index) {
    return respondents.get(index);
  }
  
  public static void setQuizAnswer(LinkedList<JSONObject> quizAnswer) {
    Score.quizAnswer = quizAnswer;
  }

  public static LinkedList<JSONObject> getQuizAnswer() {
    return quizAnswer;
  }

  public static void setRespondent(JSONObject respondent) {
    Score.respondent = respondent;
  }

  public static JSONObject getRespondent() {
    return respondent;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    essayPanel = new javax.swing.JPanel();
    scrollPane = new javax.swing.JScrollPane();
    scoreTable = new javax.swing.JTable();
    showBtn = new javax.swing.JLabel();
    closeBtn = new javax.swing.JLabel();
    namaLabel = new javax.swing.JLabel();
    infoLabel = new javax.swing.JLabel();
    scoreBg = new javax.swing.JLabel();

    essayPanel.setLayout(new javax.swing.BoxLayout(essayPanel, javax.swing.BoxLayout.Y_AXIS));

    setMinimumSize(new java.awt.Dimension(799, 527));
    setPreferredSize(new java.awt.Dimension(799, 527));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    scoreTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "No.", "Nama", "Nama", "Score"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
      }
    });
    scoreTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    scoreTable.setGridColor(new java.awt.Color(217, 217, 217));
    scoreTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
    scoreTable.setShowGrid(true);
    scoreTable.getTableHeader().setResizingAllowed(false);
    scoreTable.getTableHeader().setReorderingAllowed(false);
    scoreTable.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        scoreTableMouseClicked(evt);
      }
    });
    scrollPane.setViewportView(scoreTable);
    if (scoreTable.getColumnModel().getColumnCount() > 0) {
      scoreTable.getColumnModel().getColumn(0).setResizable(false);
      scoreTable.getColumnModel().getColumn(1).setResizable(false);
      scoreTable.getColumnModel().getColumn(2).setResizable(false);
      scoreTable.getColumnModel().getColumn(3).setResizable(false);
    }

    add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 690, 350));

    showBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBackBtn.png"))); // NOI18N
    showBtn.setToolTipText("Tabel Skor");
    showBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    showBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        showBtnMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        showBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        showBtnMouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        showBtnMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        showBtnMouseReleased(evt);
      }
    });
    add(showBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 28, -1, -1));

    closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/close.png"))); // NOI18N
    closeBtn.setToolTipText("Dashboad");
    closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        closeBtnMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        closeBtnMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        closeBtnMouseExited(evt);
      }
    });
    add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 28, 60, 50));

    namaLabel.setFont(new java.awt.Font("MS PGothic", 1, 30)); // NOI18N
    namaLabel.setForeground(new java.awt.Color(255, 255, 255));
    namaLabel.setText("Nama: Ucup");
    add(namaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

    infoLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
    infoLabel.setForeground(new java.awt.Color(255, 255, 255));
    infoLabel.setText("*Klik tabel untuk memeriksa jawaban essay peserta.");
    add(infoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 490, -1, -1));

    scoreBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background/score.png"))); // NOI18N
    add(scoreBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 799, 527));
  }// </editor-fold>//GEN-END:initComponents

  private void closeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseEntered
    closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/close-hover.png")));
  }//GEN-LAST:event_closeBtnMouseEntered

  private void closeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseExited
    closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/close.png")));
  }//GEN-LAST:event_closeBtnMouseExited

  private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
    Controller.setPanel(new Dashboard());
  }//GEN-LAST:event_closeBtnMouseClicked

  private void scoreTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scoreTableMouseClicked
    respondent = respondents.get(scoreTable.getSelectedRow());
    quizAnswer = new LinkedList<>();

    respondent.getJSONArray("quizAnswer").forEach(answer -> {
      quizAnswer.add((JSONObject) answer);
    });
    
    int i = 0;
    for(JSONObject questionAnswer : quizAnswer){
      String questionId = (questionAnswer).getString("questionId");
      JSONObject question = new Question().get(questionId);
      
      if(question != null){
        if(question.getString("type").equals("LongEssay"))
          essayPanel.add(new EssayCheck(question.getString("question"), i,  scoreTable.getSelectedRow()));

        i++;
      }
    }
    
    scrollPane.setViewportView(essayPanel);
    showBtn.setVisible(true);
    closeBtn.setVisible(false);
//    scoreBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background/essayBG.png")));
    namaLabel.setVisible(true);
    infoLabel.setVisible(false);
    namaLabel.setText("Nama : " + respondent.getString("name"));
  }//GEN-LAST:event_scoreTableMouseClicked

  private void showBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showBtnMouseClicked
    scrollPane.setViewportView(scoreTable);
    showBtn.setVisible(false);
    closeBtn.setVisible(true);
    namaLabel.setVisible(false);
    essayPanel.removeAll();
//    scoreBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background/score.png")));
  }//GEN-LAST:event_showBtnMouseClicked

  private void showBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showBtnMouseEntered
    showBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBackBtn-hover.png")));
  }//GEN-LAST:event_showBtnMouseEntered

  private void showBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showBtnMouseExited
    showBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBackBtn.png")));
  }//GEN-LAST:event_showBtnMouseExited

  private void showBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showBtnMousePressed
    showBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBackBtn-click.png")));
  }//GEN-LAST:event_showBtnMousePressed

  private void showBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showBtnMouseReleased
    showBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/loginBackBtn.png")));
  }//GEN-LAST:event_showBtnMouseReleased

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel closeBtn;
  private javax.swing.JPanel essayPanel;
  private javax.swing.JLabel infoLabel;
  private javax.swing.JLabel namaLabel;
  private javax.swing.JLabel scoreBg;
  private javax.swing.JTable scoreTable;
  private javax.swing.JScrollPane scrollPane;
  private javax.swing.JLabel showBtn;
  // End of variables declaration//GEN-END:variables
}
