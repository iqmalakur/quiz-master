/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package app.models;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.LinkedList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author iakba
 */
public class QuizTest {
  private final Quiz quiz;
  
  public QuizTest(){
    quiz = new Quiz();
  }
  
  @Test
  public void testGet() {
    LinkedList<Document> quizzes = quiz.get();
    
    ObjectId expectedId = quizzes.get(0).getObjectId("_id");
    ObjectId actualId = new ObjectId("6465d43c7399c00748b823d6");
    
    Document quizById = quiz.get(expectedId);
    
    assertEquals(quizzes.get(0), quizById);
    assertEquals(expectedId, actualId);
    
//    assertEquals()
  }
  
  @Test
  public void testCrud(){
//    m.insert(
//      new Document()
//        .append("name", "Test")
//        .append("questions", questions)
//        .append("respondents", respondents)
//        .append("code", "ABCDE")
//        .append("optField", "NIM")
//    );
    
//    System.out.println(m.update(
//      new Document()
//        .append("name", "Test Lagi")
//        .append("questions", questions)
//        .append("respondents", respondents)
//        .append("code", "EDCBA")
//        .append("optField", "NID"),
//      d.get(1).getObjectId("_id")
//    ));
  }
}

