/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.respondent;

import app.Controller;
import app.models.Model;
import app.models.Question;
import app.models.Quiz;
import app.models.Respondent;
import app.views.host.Home;
import java.awt.Color;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author iakba
 */
public class QuizAnswer extends javax.swing.JPanel {
  private final JSONObject quiz;
  private JSONObject respondent;
  private LinkedList<JSONObject> questionData;
  private JSONObject currentQuestion;
  private Answer answerPanel;
  private int count = 0;
  private int counter = 0;
  private int scoreMax = 0;
  private TimerTask task;

  /**
   * Creates new form QuizAnswer
   * @param quiz       Data quiz berupa JSONObject
   * @param respondent Data respondent berupa JSONObject
   */
  public QuizAnswer(JSONObject quiz, JSONObject respondent) {
    initComponents();
    
    this.quiz = quiz;
    this.respondent = respondent
            .put("quizAnswer", new JSONArray())
            .put("score", 0)
            .put("answerTime", 0);
    
    Model questionModel = new Question();
    questionData = new LinkedList<>();
    
    quiz.getJSONArray("questions").forEach(item -> {
      questionData.add(questionModel.get((String) item));
    });
    
    title.setText(quiz.getString("name"));
    answerContainer.setBackground(new Color(0, 0, 0, 0));
    
    updateQuestion();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    answerContainer = new javax.swing.JPanel();
    question = new javax.swing.JLabel();
    title = new javax.swing.JLabel();
    time = new javax.swing.JLabel();
    btnNext = new javax.swing.JLabel();
    background = new javax.swing.JLabel();

    setBackground(new java.awt.Color(68, 74, 74));
    setMinimumSize(new java.awt.Dimension(799, 527));
    setPreferredSize(new java.awt.Dimension(799, 527));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    answerContainer.setBackground(new java.awt.Color(0, 0, 0));
    answerContainer.setLayout(new java.awt.CardLayout());
    add(answerContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 286, 670, 220));

    question.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
    question.setForeground(new java.awt.Color(255, 255, 255));
    question.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    add(question, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 705, 165));

    title.setFont(new java.awt.Font("Comic Sans MS", 1, 40)); // NOI18N
    title.setForeground(new java.awt.Color(255, 255, 255));
    add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 510, 60));

    time.setFont(new java.awt.Font("sansserif", 0, 32)); // NOI18N
    time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 105, 50));

    btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/next.png"))); // NOI18N
    btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnNextMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnNextMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        btnNextMouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        btnNextMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        btnNextMouseReleased(evt);
      }
    });
    add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, -1, -1));

    background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background/quizAnswer.png"))); // NOI18N
    add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, -1, -1));
  }// </editor-fold>//GEN-END:initComponents

  private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
    JSONObject quizAnswer = new JSONObject()
          .put("questionId", currentQuestion.getString("_id"))
          .put("answer", answerPanel.getAnswer());
    
    respondent.put(
      "quizAnswer",
      respondent.getJSONArray("quizAnswer").put(quizAnswer)
    );
    
    int answerTime = currentQuestion.getInt("time") - counter;
    respondent.put(
      "answerTime",
      respondent.getInt("answerTime") + answerTime
    );
    
    // Matching jawaban yang bukan LongEssay
    if(!currentQuestion.getString("type").equals("LongEssay")){
      int score = 0;
      
      // Matching jawaban Multiple Choises
      if(currentQuestion.getString("type").equals("MultiChoises")){
        JSONArray correctAnswer = currentQuestion
                .getJSONObject("answer").getJSONArray("correctAnswer");
        
        if(quizAnswer.getJSONArray("answer").similar(correctAnswer)){
          score = currentQuestion.getInt("grade");
        }
      }
      
      // Matching jawaban Single Choise dan Short Essay
      else{
        Object correctAnswer = currentQuestion
                .getJSONObject("answer").get("correctAnswer");
        
        if(quizAnswer.get("answer").equals(correctAnswer)){
          score = currentQuestion.getInt("grade");
        }
      }
      
      respondent.put(
        "score",
        respondent.getInt("score") + score
      );
    }
    
    // Jika soal berikutnya merupakan soal terakhir,
    // maka tombol next berubah menjadi finish
    if(count + 2 >= questionData.size()) 
      btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/finish.png")));
    
    // Jika soal ini merupakan soal terakhir
    if(count + 2 > questionData.size()) {
      task.cancel();
      
      respondent = new Respondent().insert(respondent);
      
      // Update isi respondent pada quiz
      quiz.put(
        "respondents",
        quiz.getJSONArray("respondents")
          .put(respondent.getString("_id"))
      ).put("state", 0);
      new Quiz().update(quiz, quiz.getString("_id"));
      
      Controller.showInformationDialog(String.format(
              """
              Jawaban Anda berhasil dikirim!
              Score Anda : %d point / %d point
              Waktu Pengerjaan : %d detik
              """, respondent.getInt("score"),
              scoreMax,
              respondent.getInt("answerTime")),
              "Quiz Selesai");
      
      Controller.setPanel(new Home());
    }
    else nextQuestion();
  }//GEN-LAST:event_btnNextMouseClicked

  private void btnNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseEntered
     if(count + 2 >= questionData.size()) {
      btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/finish-hover.png")));
     return;
     }
    btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/next-hover.png")));
  }//GEN-LAST:event_btnNextMouseEntered

  private void btnNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseExited
     if(count + 2 >= questionData.size()) {
      btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/finish.png")));
     return;
     }
    btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/next.png")));
    // TODO add your handling code here:
  }//GEN-LAST:event_btnNextMouseExited

  private void btnNextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMousePressed
     if(count + 2 >= questionData.size()) {
      btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/finish-hover.png")));
     return;
     }
    btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/next-click.png")));
    // TODO add your handling code here:
  }//GEN-LAST:event_btnNextMousePressed

  private void btnNextMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseReleased
     if(count + 2 >= questionData.size()) {
      btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/finish-hover.png")));
     return;
     }
    btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button/next.png")));
    // TODO add your handling code here:
  }//GEN-LAST:event_btnNextMouseReleased

  private void nextQuestion(){
    task.cancel();
    count++;
    updateQuestion();
  }
  
  private void setAnswerPanel(JPanel panel){
    answerContainer.removeAll();
    answerContainer.add(panel);
  }
  
  private void updateQuestion(){
    currentQuestion = questionData.get(count);
    counter = currentQuestion.getInt("time");
    scoreMax += currentQuestion.getInt("grade");
    
    time.setForeground(Color.WHITE);
    time.setText(counter + "");
    
    task = new TimerTask() {
        @Override
        public void run() {
          time.setText(--counter + "");
          if(counter <= 5) time.setForeground(Color.RED);
          if(counter <= 0) {
            cancel();
            nextQuestion();
          }
        }
    };
    
    int delay = 1000; // 1 second first delay
    int period = 1000; // 1 second every time changing
    
    Timer timer = new Timer("Timer");
    timer.schedule(task, delay, period);
    
    question.setText(currentQuestion.getString("question"));
    
    // Ubah answer panel sesuai tipe soal
    switch(currentQuestion.getString("type")){
      case "SingleChoise" -> {
        JSONArray choises = currentQuestion
                .getJSONObject("answer")
                .getJSONArray("choises");
        answerPanel = new SingleChoise(choises);
      }
      case "MultiChoises" -> {
        JSONArray choises = currentQuestion
                .getJSONObject("answer")
                .getJSONArray("choises");
        answerPanel = new MultiChoises(choises);
      }
      case "ShortEssay" -> answerPanel = new ShortEssay();
      case "LongEssay" -> answerPanel = new LongEssay();
    }
    
    setAnswerPanel(answerPanel);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel answerContainer;
  private javax.swing.JLabel background;
  private javax.swing.JLabel btnNext;
  private javax.swing.JLabel question;
  private javax.swing.JLabel time;
  private javax.swing.JLabel title;
  // End of variables declaration//GEN-END:variables
}
