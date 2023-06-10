/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
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
public class QuizTest {
  private final Quiz model;
  
  public QuizTest() {
    model = new Quiz();
  }
  
  @Test
  public void testInsert(){
    JSONObject newData = new JSONObject("""
                                        {
                                          "name": "Percobaan Quiz",
                                          "questions": ["QST001", "QST002"],
                                          "respondents": ["RES001"],
                                          "code": "AAAAAA",
                                          "optField": "Profesi"
                                        }
                                        """);
    assertNotNull(model.insert(newData));
    
    LinkedList<JSONObject> data = model.get();
    JSONObject lastData = data.getLast();
    
    assertEquals("Percobaan Quiz", lastData.getString("name"));
    assertEquals("Profesi", lastData.getString("optField"));
  }

  @Test
  public void testGet() {
    LinkedList<JSONObject> data = model.get();
    JSONObject lastData = data.getLast();
    
    assertEquals("Percobaan Quiz", lastData.getString("name"));
    assertEquals("Profesi", lastData.getString("optField"));
  }
  
  @Test
  public void testGetByKeyValue() {
    JSONObject dataByQuizCode = model.get("code", "AAAAAA");
    
    assertEquals("Percobaan Quiz", dataByQuizCode.getString("name"));
    assertEquals("Profesi", dataByQuizCode.getString("optField"));
    
    JSONObject faultData = model.get("code", "ZZZ");
    assertNull(faultData);
  }
  
  @Test
  public void testGetByQuery() {
    JSONObject query = new JSONObject("""
                                      {
                                        "name": "Percobaan Quiz",
                                        "code": "AAAAAA"
                                      }
                                      """);
    JSONObject data = model.get(query);
    
    assertEquals("Percobaan Quiz", data.getString("name"));
    assertEquals("Profesi", data.getString("optField"));
    
    JSONObject faultQuery = new JSONObject("""
                                      {
                                        "name": "Percobaan Quiz",
                                        "code": "ZZZ"
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
      int id = idFile.getInt("Quiz");
      
      JSONObject data = model.get(String.format("QUZ%03d", id));
    
      assertEquals("Percobaan Quiz", data.getString("name"));
      assertEquals("Profesi", data.getString("optField"));

      JSONObject faultData = model.get("QUZ000");
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
      int id = idFile.getInt("Quiz");
      
      JSONObject beforeUpdate = model.get(String.format("QUZ%03d", id));
      assertEquals("Percobaan Quiz", beforeUpdate.getString("name"));
      assertEquals("Profesi", beforeUpdate.getString("optField"));
      
      assertNotNull(model.update(
              new JSONObject("""
                             {
                                "name": "Ini Percobaan Quiz",
                                "optField": "NIM"
                             }
                             """),
              String.format("QUZ%03d", id))
      );
      
      JSONObject afterUpdate = model.get(String.format("QUZ%03d", id));
      assertEquals("Ini Percobaan Quiz", afterUpdate.getString("name"));
      assertEquals("NIM", afterUpdate.getString("optField"));
    } catch(IOException e){
      System.out.println(e);
    }
  }
  
  @Test
  public void testDelete(){
    try(InputStream dataRead = new FileInputStream("data/IdCount.json")) {
      byte[] rawData = dataRead.readAllBytes();
      
      JSONObject idFile = new JSONObject(new String(rawData));
      int id = idFile.getInt("Quiz");
      
      assertNotNull(model.get(String.format("QUZ%03d", id)));
      assertTrue(model.delete(String.format("QUZ%03d", id)));
      assertNull(model.get(String.format("QUZ%03d", id)));
      
      try (OutputStream dataWrite = new FileOutputStream("data/IdCount.json")){
        idFile.put("Quiz", idFile.getInt("Quiz") - 1);
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

