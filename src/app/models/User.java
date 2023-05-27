/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author iakba
 */
public class User extends Model {

  /**
   * Menginisialisasi objek dengan memanggil parent constructor <br>
   * Menetapkan "User" sebagai nama collection yang digunakan
   */
  public User(){
    super("User");
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
      
      String username = data.containsKey("username") ?
        data.getString("username") : existingDoc.getString("username");
      
      String password = data.containsKey("password") ?
        data.getString("password") : existingDoc.getString("password");
      
      String email = data.containsKey("email") ?
        data.getString("email") : existingDoc.getString("email");
      
      String name = data.containsKey("name") ?
        data.getString("name") : existingDoc.getString("name");
      
      List<ObjectId> quizzes = data.containsKey("quizzes") ?
        data.getList("quizzes", ObjectId.class) : existingDoc.getList("quizzes", ObjectId.class);
      
      // Update data
      UpdateResult updateResult = getCollection().updateOne(
        query,
        Updates.combine(
          Updates.set("username", username),
          Updates.set("password", password),
          Updates.set("email", email),
          Updates.set("name", name),
          Updates.set("quizzes", quizzes)
        )
      );

      // Mengembalikan true jika ada data yang berubah
      return updateResult.getModifiedCount() > 0;
    }
    
    return false;
  }
}
