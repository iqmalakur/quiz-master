/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

/**
 *
 * @author iakba
 */
public class User extends Model {
  /**
   * Menginisialisasi objek dengan memanggil parent constructor <br>
   * Menetapkan "User" sebagai nama file JSON yang digunakan
   * dan "USR" sebagai prefix id untuk Model User
   */
  public User(){
    super("User", "USR");
  }
}
