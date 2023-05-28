/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

/**
 *
 * @author iakba
 */

public class Quiz extends Model {
  /**
   * Menginisialisasi objek dengan memanggil parent constructor <br>
   * Menetapkan "Quiz" sebagai nama file JSON yang digunakan
   * dan "QUZ" sebagai prefix id untuk Model Quiz
   */
  public Quiz() {
    super("Quiz", "QUZ");
  }
}
