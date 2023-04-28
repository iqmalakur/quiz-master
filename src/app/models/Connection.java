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
import org.bson.Document;

/**
 *
 * @author iakba
 */
public abstract class Connection {
  protected MongoCollection<Document> collection;

  public Connection(String collectionName) {
    String connectionString = "mongodb+srv://iqmalak21:iqmalakur@coba.igwchel.mongodb.net/?retryWrites=true&w=majority";

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
      MongoDatabase database = mongoClient.getDatabase("Quiz");
      collection = database.getCollection(collectionName);
    } catch (MongoException e) {
      e.printStackTrace();
    }
  }
}
