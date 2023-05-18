/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author iakba
 */
public class Question extends Model {

  /**
   * Menginisialisasi objek dengan memanggil parent constructor <br>
   * Menetapkan "Question" sebagai nama collection yang digunakan
   */
  public Question() {
    super("Question");
  }

  /**
   * Mengubah data pada collection
   * 
   * @param data Data baru berupa Document
   * @param id   Id dari data yang akan diubah berupa ObjectId
   * @return     Mengembalikan true jika berhasil dan false jika gagal
   */
  @Override
  public boolean update(Document data, ObjectId id) {
    Document query = new Document("_id", id);
    Document existingDoc = getCollection().find(query).first();
    
    // Jika data ditemukan
    if (existingDoc != null) {
      // Menyiapkan data untuk update
      // Jika field ada pada parameter data, maka akan digunakan
      // Jika tidak ada maka akan digunakan dari existingDoc
      
      String question = data.containsKey("question") ?
        data.getString("question") : existingDoc.getString("question");
      
      Integer time = data.containsKey("time") ?
        data.getInteger("time") : existingDoc.getInteger("time");
      
      Integer grade = data.containsKey("grade") ?
        data.getInteger("grade") : existingDoc.getInteger("grade");
      
      String type = data.containsKey("type") ?
        data.getString("type") : existingDoc.getString("type");
      
      Document answer = data.containsKey("answer") ?
        data.get("answer", Document.class) : existingDoc.get("answer", Document.class);
      
      // Update data
      UpdateResult updateResult = getCollection().updateOne(
        query,
        Updates.combine(
          Updates.set("question", question),
          Updates.set("time", time),
          Updates.set("grade", grade),
          Updates.set("type", type),
          Updates.set("answer", answer)
        )
      );

      // Mengembalikan true jika ada data yang berubah
      return updateResult.getModifiedCount() > 0;
    }
    
    return false;
  }
  
}
