/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author iakba
 */

public class Quiz extends Model {

  /**
   * Menginisialisasi objek dengan memanggil parent constructor <br>
   * Menetapkan "Quiz" sebagai nama collection yang digunakan
   */
  public Quiz() {
    super("Quiz");
  }
  
  /**
   * Mengambil data spesifik berdasarkan Id pada collcetion
   * 
   * @param id Id dari data yang dicari berupa ObjectId
   * @return   Data yang dicari, berupa Document
   */
  @Override
  public Document get(ObjectId id){
    Document query = new Document("_id", id);
    Document data = getCollection().find(query).first();
    
    return data;
  }
  
  /**
   * Mengambil semua data pada collection
   * 
   * @return LinkedList dari data yang berbentuk Document
   */
  @Override
  public LinkedList<Document> get(){
    MongoCursor<Document> cursor = getCollection().find().iterator();
    LinkedList<Document> data = new LinkedList<>();

    while(cursor.hasNext()){
      data.add(cursor.next());
    }

    return data;
  }
  
  /**
   * Mengubah data pada collection
   * 
   * @param data Data baru berupa Document
   * @param id   Id dari data yang akan diubah berupa ObjectId
   * @return     Mengembalikan true jika berhasil dan false jika gagal
   */
  @Override
  public boolean update(Document data, ObjectId id){
    Document query = new Document("_id", id);
    Document existingDoc = getCollection().find(query).first();
    
    // Jika data ditemukan
    if (existingDoc != null) {
      // Menyiapkan data untuk update
      // Jika field ada pada parameter data, maka akan digunakan
      // Jika tidak ada maka akan digunakan dari existingDoc
      
      String name = data.containsKey("name") ?
        data.getString("name") : existingDoc.getString("name");
      
      List<ObjectId> questions = data.containsKey("questions") ?
        data.getList("questions", ObjectId.class) : existingDoc.getList("questions", ObjectId.class);
      
      List<ObjectId> respondents = data.containsKey("respondents") ?
        data.getList("respondents", ObjectId.class) : existingDoc.getList("respondents", ObjectId.class);
      
      String code = data.containsKey("code") ?
        data.getString("code") : existingDoc.getString("code");
      
      String optField = data.containsKey("optField") ?
        data.getString("optField") : existingDoc.getString("optField");
      
      // Update data
      UpdateResult updateResult = getCollection().updateOne(
        query,
        Updates.combine(
          Updates.set("name", name),
          Updates.set("questions", questions),
          Updates.set("respondents", respondents),
          Updates.set("code", code),
          Updates.set("optField", optField)
        )
      );

      // Mengembalikan true jika ada data yang berubah
      return updateResult.getModifiedCount() > 0;
    }
    
    return false;
  }
}
