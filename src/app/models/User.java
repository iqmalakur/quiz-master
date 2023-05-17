/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author iakba
 */
public class User extends BaseModel {
  private String username;
  private String password;
  private String email;
  private String name;
  private Quiz[] quizzes;
  
  public User(Document data){
    super("User");
    init(data);
  }
  
  public User(ObjectId id){
    super("User");
    
    FindIterable<Document> data = collection.find();
    init(data.first());
  }
  
  private void init(Document data){
    username = data.getString("username");
    password = data.getString("password");
    email = data.getString("email");
    name = data.getString("name");
    
    List<ObjectId> users = data.getList("quizzes", ObjectId.class);
    quizzes = new Quiz[3];
    
    for(int i = 0; i < quizzes.length; i++){
      quizzes[i] = new Quiz(users.get(i));
    }
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }
  
  public void addQuiz(Quiz quiz){
    new Model("Quiz").add(new Document());
  }
  
  public void removeQuiz(int index){
    
  }
  
  @Override
  public void save(){
    // Cari dokumen yang ingin diubah
    Document query = new Document("_id", this.getId());
    Document existingDoc = collection.find(query).first();

    if (existingDoc != null) {
        ObjectId[] quizzes = new ObjectId[3];
        
        for(int i = 0; i < this.quizzes.length; i++){
          quizzes[i] = this.quizzes[i].getId();
        }
      
        // Ubah data pada dokumen yang sudah ada
        UpdateResult updateResult = collection.updateOne(
          query,
          Updates.combine(
            Updates.set("username", username),
            Updates.set("password", password),
            Updates.set("email", email),
            Updates.set("name", name),
            Updates.set("quizzes", quizzes)
          )
        );

        if (updateResult.getModifiedCount() > 0) {
            System.out.println("Data berhasil diubah!");
        } else {
            System.out.println("Data gagal diubah.");
        }
    } else {
        System.out.println("Data tidak ditemukan.");
    }
  }
  
  public boolean checkPassword(String password){
    return this.password.equals(password);
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public Quiz[] getQuizzes() {
    return quizzes;
  }
  
}
