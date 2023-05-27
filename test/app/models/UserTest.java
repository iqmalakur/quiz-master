/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package app.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iakba
 */
public class UserTest {
  private final User user;
  
  public UserTest(){
    user = new User();
  }
  
  @Test
  public void testGet() {
    LinkedList<Document> users = user.get();
    
    ObjectId expectedId = new ObjectId("6460cce5b0c6e24873d968a9");
    ObjectId actualId = users.get(0).getObjectId("_id");
    
    Document userById = user.get(actualId);
    
    assertEquals(users.get(0), userById);
    assertEquals(expectedId, actualId);
    
    String expectedUsername = "ucup";
    String actualUsername = users.get(0).getString("username");
    assertEquals(expectedUsername, actualUsername);
    
    String expectedPassword = "ucup";
    String actualPassword = users.get(0).getString("password");
    assertEquals(expectedPassword, actualPassword);
    
    String expectedName = "Ucup";
    String actualName = users.get(0).getString("name");
    assertEquals(expectedName, actualName);
    
    String expectedEmail = "ucup@gmail.com";
    String actualEmail = users.get(0).getString("email");
    assertEquals(expectedEmail, actualEmail);
    
    ObjectId expectedFirstQuizId = new ObjectId("6465d43c7399c00748b823d6");
    ObjectId actualFirstQuizId = users.get(0).getList("quizzes", ObjectId.class).get(0);
    assertEquals(expectedFirstQuizId, actualFirstQuizId);
  }
  
  @Test
  public void testCrud(){
    List<ObjectId> newUserQuizzes = new ArrayList<>();
    newUserQuizzes.add(new ObjectId("6465d43c7399c00748b823d6"));
    
    Document newUser = new Document()
      .append("username", "udin")
      .append("password", "udin")
      .append("email", "udin@gmail.com")
      .append("name", "Udin")
      .append("quizzes", newUserQuizzes)
    ;
    
    assertTrue(user.insert(newUser));
    assertEquals(user.get().get(1).getString("name"), "Udin");
    
    Document updateUser = new Document()
      .append("username", "udinaja")
      .append("password", "udin123")
      .append("email", "udinaja@gmail.com")
      .append("name", "Udin Markudin")
      .append("quizzes", newUserQuizzes)
    ;
    
    ObjectId id = user.get().get(1).getObjectId("_id");
    
    assertTrue(user.update(updateUser, id));
    assertEquals(user.get().get(1).getString("name"), "Udin Markudin");
    
    assertTrue(user.delete(id));
  }
  
}
