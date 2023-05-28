/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

/**
 *
 * @author iakba
 */
public class Question extends Model {
  /**
   * Menginisialisasi objek dengan memanggil parent constructor <br>
   * Menetapkan "Question" sebagai nama file JSON yang digunakan
   * dan "QST" sebagai prefix id untuk Model Question
   */
  public Question() {
    super("Question", "QST");
  }
}
