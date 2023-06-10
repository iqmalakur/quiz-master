/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.views.respondent;

import javax.swing.JPanel;

/**
 *
 * @author iakba
 */
public abstract class Answer extends JPanel {

  /**
   * Mendapatkan answer dari sub-panel
   * @return Mengembalikan jawaban berupa Object
   */
  public abstract Object getAnswer();
}
