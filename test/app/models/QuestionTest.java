/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package app.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author iakba
 */
public class QuestionTest {
  private final Question model;
  
  public QuestionTest() {
    model = new Question();
  }
  
  @Test
  public void testInsert(){
    JSONObject newData = new JSONObject("""
                                        {
                                          "question": "Apakah ini percobaan?",
                                          "time": 30,
                                          "grade": 2,
                                          "type": "SingleChoise",
                                          "answer": {
                                            "choises": ["satu", "dua", "tiga", "empat"],
                                            "correctAnswer": 1
                                          }
                                        }
                                        """);
    assertTrue(model.insert(newData));
    
    LinkedList<JSONObject> data = model.get();
    JSONObject lastData = data.getLast();
    
    assertEquals("Apakah ini percobaan?", lastData.getString("question"));
    assertEquals("SingleChoise", lastData.getString("type"));
  }

  @Test
  public void testGet() {
    LinkedList<JSONObject> data = model.get();
    JSONObject lastData = data.getLast();
    
    assertEquals("Apakah ini percobaan?", lastData.getString("question"));
    assertEquals("SingleChoise", lastData.getString("type"));
  }
  
  @Test
  public void testGetByKeyValue() {
    JSONObject dataByQuestion = model.get("question", "Apakah ini percobaan?");
    
    assertEquals("Apakah ini percobaan?", dataByQuestion.getString("question"));
    assertEquals("SingleChoise", dataByQuestion.getString("type"));
    
    JSONObject faultData = model.get("question", "?");
    assertNull(faultData);
  }
  
  @Test
  public void testGetByQuery() {
    JSONObject query = new JSONObject("""
                                      {
                                        "question": "Apakah ini percobaan?",
                                        "grade": 2,
                                        "time": 30
                                      }
                                      """);
    JSONObject data = model.get(query);
    
    assertEquals("Apakah ini percobaan?", data.getString("question"));
    assertEquals("SingleChoise", data.getString("type"));
    
    JSONObject faultQuery = new JSONObject("""
                                      {
                                        "question": "Apakah ini percobaan?",
                                        "grade": 3,
                                        "time": 30
                                      }
                                      """);
    JSONObject faultData = model.get(faultQuery);
    assertNull(faultData);
  }  
  
  @Test
  public void testGetById(){
    try(InputStream dataRead = new FileInputStream("data/IdCount.json")) {
      byte[] rawData = dataRead.readAllBytes();
      
      JSONObject idFile = new JSONObject(new String(rawData));
      int id = idFile.getInt("Question");
      
      JSONObject data = model.get(String.format("QST%03d", id));
    
      assertEquals("Apakah ini percobaan?", data.getString("question"));
      assertEquals("SingleChoise", data.getString("type"));

      JSONObject faultData = model.get("QST000");
      assertNull(faultData);
    } catch(IOException e){
      System.out.println(e);
    }
  }
  
  @Test
  public void testUpdate(){
    try(InputStream dataRead = new FileInputStream("data/IdCount.json")) {
      byte[] rawData = dataRead.readAllBytes();
      
      JSONObject idFile = new JSONObject(new String(rawData));
      int id = idFile.getInt("Question");
      
      JSONObject beforeUpdate = model.get(String.format("QST%03d", id));
      assertEquals("Apakah ini percobaan?", beforeUpdate.getString("question"));
      assertEquals(2, beforeUpdate.getInt("grade"));
      
      assertTrue(model.update(
              new JSONObject("""
                             {
                                "question": "Apakah ini percobaan ya?",
                                "grade": 5
                             }
                             """),
              String.format("QST%03d", id))
      );
      
      JSONObject afterUpdate = model.get(String.format("QST%03d", id));
      assertEquals("Apakah ini percobaan ya?", afterUpdate.getString("question"));
      assertEquals(5, afterUpdate.getInt("grade"));
    } catch(IOException e){
      System.out.println(e);
    }
  }
  
  @Test
  public void testDelete(){
    try(InputStream dataRead = new FileInputStream("data/IdCount.json")) {
      byte[] rawData = dataRead.readAllBytes();
      
      JSONObject idFile = new JSONObject(new String(rawData));
      int id = idFile.getInt("Question");
      
      assertNotNull(model.get(String.format("QST%03d", id)));
      assertTrue(model.delete(String.format("QST%03d", id)));
      assertNull(model.get(String.format("QST%03d", id)));
      
      try (OutputStream dataWrite = new FileOutputStream("data/IdCount.json")){
        idFile.put("Question", idFile.getInt("Question") - 1);
        byte[] byteData = idFile.toString().getBytes();
        dataWrite.write(byteData);
      } catch(IOException e){
        System.out.println(e);
      }
    } catch(IOException e){
      System.out.println(e);
    }
  }
}


