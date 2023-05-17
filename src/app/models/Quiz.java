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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author iakba
 */

public class Quiz extends Model {

  public Quiz() {
    super("Quiz");
  }
  
  private Document convertQuiz(Document data){
    Model quiz = new Quiz();
    List<ObjectId> quizzesId = data.getList("quizzes", ObjectId.class);
    Document[] quizzes = new Document[3];
    
    for(int i = 0; i < quizzesId.size(); i++){
      quizzes[i] = quiz.get(quizzesId.get(i));
    }
    
    data.append("quizzes", quizzes);
    
    return data;
  }
  
  @Override
  public Document get(ObjectId id){
    Document query = new Document("_id", id);
    Document data = convertQuiz(getCollection().find(query).first());
    
    return data;
  }
  
  @Override
  public LinkedList<Document> get(){
    MongoCursor<Document> cursor = getCollection().find().iterator();
    LinkedList<Document> data = new LinkedList<>();


    while(cursor.hasNext()){
      data.add(convertQuiz(cursor.next()));
    }

    return data;
  }
  
  @Override
  public boolean update(Document data, ObjectId id){
    Document query = new Document("_id", id);
    Document existingDoc = getCollection().find(query).first();
    
    if (existingDoc != null) {
      String username = query.containsKey("username") ?
        query.getString("username") : existingDoc.getString("username");
      
      String password = query.containsKey("password") ?
        query.getString("password") : existingDoc.getString("password");
      
      String email = query.containsKey("email") ?
        query.getString("email") : existingDoc.getString("email");
      
      String name = query.containsKey("name") ?
        query.getString("name") : existingDoc.getString("name");
      
      
      UpdateResult updateResult = getCollection().updateOne(
        query,
        Updates.combine(
          Updates.set("username", username),
          Updates.set("password", password),
          Updates.set("email", email),
          Updates.set("name", name)
//          Updates.set("quizzes", quizzes)
        )
      );


      return updateResult.getModifiedCount() > 0;
    }
    
    return false;
  }
}
