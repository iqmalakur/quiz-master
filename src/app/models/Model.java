/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

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
      e.printStackTrace();
    }
  }
  
  protected MongoCollection<Document> getCollection(){
    return collection;
  }
  
  public abstract Document get(ObjectId id);
  public abstract LinkedList<Document> get();
  
  public boolean insert(Document data){
    try{
      collection.insertOne(data);
      return true;
    } catch(MongoException e){
      return false;
    }
  }
  
  public boolean delete(ObjectId id){
    Document query = new Document("_id", id);
    DeleteResult deleteResult = collection.deleteOne(query);

    return deleteResult.getDeletedCount() > 0;
  }
  
  public abstract boolean update(Document data, ObjectId id);
}
