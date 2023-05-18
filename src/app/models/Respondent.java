/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author iakba
 */
public class Respondent extends Model {

  /**
   * Menginisialisasi objek dengan memanggil parent constructor <br>
   * Menetapkan "Respondent" sebagai nama collection yang digunakan
   */
  public Respondent() {
    super("Respondent");
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
      
      String name = data.containsKey("name") ?
        data.getString("name") : existingDoc.getString("name");
      
      String optFieldValue = data.containsKey("optFieldValue") ?
        data.getString("optFieldValue") : existingDoc.getString("optFieldValue");
      
      Integer score = data.containsKey("score") ?
        data.getInteger("score") : existingDoc.getInteger("score");
      
      Integer answerTime = data.containsKey("answerTime") ?
        data.getInteger("answerTime") : existingDoc.getInteger("answerTime");
      
      List<Document> quizAnswer = data.containsKey("quizAnswer") ?
        data.getList("quizAnswer", Document.class) : existingDoc.getList("quizAnswer", Document.class);
      
      // Update data
      UpdateResult updateResult = getCollection().updateOne(
        query,
        Updates.combine(
          Updates.set("name", name),
          Updates.set("optFieldValue", optFieldValue),
          Updates.set("score", score),
          Updates.set("answerTime", answerTime),
          Updates.set("quizAnswer", quizAnswer)
        )
      );
      
      // Mengembalikan true jika ada data yang berubah
      return updateResult.getModifiedCount() > 0;
    }
    
    return false;
  }
  
}
