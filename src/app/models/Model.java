package app.models;

import com.mongodb.client.MongoCursor;
import java.util.LinkedList;
import org.bson.Document;
import org.bson.types.ObjectId;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Model extends Connection {
  private String collectionName;
  public Model(String collectionName) {
    super(collectionName);
    this.collectionName = collectionName;
  }
  
  public boolean add(Document data){
    try {
      collection.insertOne(data);
    } 
    catch (Exception e) {
      System.out.println(e);
      return false;
    }
    return true;
  }
  
  public boolean delete(ObjectId id){
    try {
      if(collection.deleteOne(new Document("_id", id)).getDeletedCount()>0)
        return true;
    } 
    catch (Exception e) {
      System.out.println(e);
    }
      return false;
  }
  
  public LinkedList<BaseModel> get(){
    MongoCursor<Document> cursor = collection.find().iterator();
    LinkedList<BaseModel> data = new LinkedList<>();
    while(cursor.hasNext()){
     switch(collectionName){
       case "User" -> data.add(new User(cursor.next()));
     }
    }
    return data;
  }
  
}
