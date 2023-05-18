/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package app.models;

import java.util.LinkedList;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iakba
 */
public class QuestionTest {
  private final Question question;
  
  public QuestionTest(){
    question = new Question();
  }
  
  @Test
  public void testGet() {
    LinkedList<Document> questions = question.get();
    
    ObjectId expectedId = new ObjectId("6464ed8cecc0509f20f62420");
    ObjectId actualId = questions.get(0).getObjectId("_id");
    
    Document questionById = question.get(actualId);
    
    assertEquals(questions.get(0), questionById);
    assertEquals(expectedId, actualId);
    
    String expectedQuestion = "Bahasa pemrograman untuk web";
    String actualQuestion = questions.get(0).getString("question");
    assertEquals(expectedQuestion, actualQuestion);
    
    int expectedTime = 30;
    int actualTime = questions.get(0).getInteger("time");
    assertEquals(expectedTime, actualTime);
    
    int expectedGrade = 2;
    int actualGrade = questions.get(0).getInteger("grade");
    assertEquals(expectedGrade, actualGrade);
    
    String expectedType = "SingleChoise";
    String actualType = questions.get(0).getString("type");
    assertEquals(expectedType, actualType);
  }
}


