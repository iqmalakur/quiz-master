/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views.respondent;

import java.awt.Color;

/**
 *
 * @author iakba
 */
public class SingleChoise extends javax.swing.JPanel {

  /**
   * Creates new form SingleChoise
   */
  public SingleChoise() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    shortEssayAnswer = new javax.swing.JTextField();
    background = new javax.swing.JLabel();

    setBackground(new java.awt.Color(68, 74, 74));
    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    add(shortEssayAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 78, 658, 60));

    background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background/quizAnswer.png"))); // NOI18N
    add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-27, -274, 720, 510));
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel background;
  private javax.swing.JTextField shortEssayAnswer;
  // End of variables declaration//GEN-END:variables
}