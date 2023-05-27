/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import app.Controller;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import java.util.LinkedList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author iakba
 */

public abstract class Model {
  private MongoCollection<Document> collection;

  /**
   * Menginisialisasi objek dari Model <br>
   * Melakukan koneksi ke database MongoDB
   * 
   * @param collectionName Nama collection yang akan digunakan
   */
  public Model(String collectionName) {
    String connectionString = "mongodb+srv://iqmalak21:iqmalakur@tubes.fpy8mlc.mongodb.net/?retryWrites=true&w=majority";

    ServerApi serverApi = ServerApi.builder()
      .version(ServerApiVersion.V1)
      .build();

    MongoClientSettings settings = MongoClientSettings.builder()
      .applyConnectionString(new ConnectionString(connectionString))
      .serverApi(serverApi)
      .build();

    // Membuat koneksi
    MongoClient mongoClient = MongoClients.create(settings);
    try {
      MongoDatabase database = mongoClient.getDatabase("TubesQuiz");
      collection = database.getCollection(collectionName);
    } catch (MongoException e) {
      Controller.showErrorDialog("Terjadi kesalahan koneksi!\nError : " + e.getMessage());
    }
  }
  
  /**
   * Mengembalikan objek collection untuk berinteraksi dengan data pada collection
   * 
   * @return Objek dari MongoCollection
   */
  protected MongoCollection<Document> getCollection(){
    return collection;
  }

  /**
   * Mengambil data spesifik berdasarkan Id pada collcetion
   * 
   * @param id Id dari data yang dicari berupa ObjectId
   * @return   Data yang dicari, berupa Document
   */
  public Document get(ObjectId id) {
    Document query = new Document("_id", id);
    Document data = getCollection().find(query).first();
    
    return data;
  }
  
  /**
   * Mengambil data spesifik berdasarkan key dan value tertentu pada collcetion
   * 
   * @param key   Key pada collection
   * @param value Nilai dari key
   * @return      Data yang dicari, berupa Document
   */
  public Document get(String key, String value) {
    Document query = new Document(key, value);
    Document data = getCollection().find(query).first();
    
    return data;
  }
  
  /**
   * Mengambil data spesifik berdasarkan query tertentu
   * 
   * @param query Object Document yang berisi key - value untuk query pencarian
   * @return      Data yang dicari, berupa Document
   */
  public Document get(Document query) {
    Document data = getCollection().find(query).first();
    return data;
  }

  /**
   * Mengambil semua data pada collection
   * 
   * @return LinkedList dari data yang berbentuk Document
   */
  public LinkedList<Document> get() {
    MongoCursor<Document> cursor = getCollection().find().iterator();
    LinkedList<Document> data = new LinkedList<>();

    while(cursor.hasNext()){
      data.add(cursor.next());
    }

    return data;
  }
  
  /**
   * Menambahkan data baru pada collection
   * 
   * @param data Data yang akan ditambahkan berbentuk Document
   * @return     Mengembalikan true jika data berhasil ditambahkan
   */
  public boolean insert(Document data){
    try{
      collection.insertOne(data);
      return true;
    } catch(MongoException e){
      return false;
    }
  }
  
  /**
   * Menghapus data tertentu pada collection
   * 
   * @param id Id dari data yang akan dihapus berbentuk ObjectId
   * @return   Mengembalikan true jika data berhasil dihapus
   */
  public boolean delete(ObjectId id){
    Document query = new Document("_id", id);
    DeleteResult deleteResult = collection.deleteOne(query);

    // Mengembalikan true jika ada data yang dihapus
    return deleteResult.getDeletedCount() > 0;
  }
  
  /**
   * Mengubah data pada collection
   * 
   * @param data Data baru berupa Document
   * @param id   Id dari data yang akan diubah berupa ObjectId
   * @return     Mengembalikan true jika berhasil dan false jika gagal
   */
  public abstract boolean update(Document data, ObjectId id);
}
