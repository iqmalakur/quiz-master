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
public class UserTest {
  private final User model;
  
  public UserTest() {
    model = new User();
  }
  
  @Test
  public void testInsert(){
    JSONObject newData = new JSONObject("""
                                        {
                                          "username": "udin",
                                          "password": "udin",
                                          "email": "udin@gmail.com",
                                          "quizzes": ["QUZ001"],
                                          "name": "Udin"
                                        }
                                        """);
    assertNotNull(model.insert(newData));
    
    LinkedList<JSONObject> data = model.get();
    JSONObject lastData = data.getLast();
    
    assertEquals("udin", lastData.getString("username"));
    assertEquals("Udin", lastData.getString("name"));
  }

  @Test
  public void testGet() {
    LinkedList<JSONObject> data = model.get();
    JSONObject lastData = data.getLast();
    
    assertEquals("udin", lastData.getString("username"));
    assertEquals("Udin", lastData.getString("name"));
  }
  
  @Test
  public void testGetByKeyValue() {
    JSONObject dataByUsername = model.get("username", "udin");
    
    assertEquals("udin", dataByUsername.getString("username"));
    assertEquals("Udin", dataByUsername.getString("name"));
    
    JSONObject faultData = model.get("username", "otong");
    assertNull(faultData);
  }
  
  @Test
  public void testGetByQuery() {
    JSONObject query = new JSONObject("""
                                      {
                                        "username": "udin",
                                        "password": "udin"
                                      }
                                      """);
    JSONObject data = model.get(query);
    
    assertEquals("udin", data.getString("username"));
    assertEquals("Udin", data.getString("name"));
    
    JSONObject faultQuery = new JSONObject("""
                                      {
                                        "username": "udin",
                                        "password": "otong"
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
      int id = idFile.getInt("User");
      
      JSONObject data = model.get(String.format("USR%03d", id));
    
      assertEquals("udin", data.getString("username"));
      assertEquals("Udin", data.getString("name"));

      JSONObject faultData = model.get("USR000");
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
      int id = idFile.getInt("User");
      
      JSONObject beforeUpdate = model.get(String.format("USR%03d", id));
      assertEquals("udin", beforeUpdate.getString("username"));
      assertEquals("Udin", beforeUpdate.getString("name"));
      
      assertTrue(model.update(
              new JSONObject("""
                             {
                                "name": "Otong"
                             }
                             """),
              String.format("USR%03d", id))
      );
      
      JSONObject afterUpdate = model.get(String.format("USR%03d", id));
      assertEquals("udin", afterUpdate.getString("username"));
      assertEquals("Otong", afterUpdate.getString("name"));
    } catch(IOException e){
      System.out.println(e);
    }
  }
  
  @Test
  public void testDelete(){
    try(InputStream dataRead = new FileInputStream("data/IdCount.json")) {
      byte[] rawData = dataRead.readAllBytes();
      
      JSONObject idFile = new JSONObject(new String(rawData));
      int id = idFile.getInt("User");
      
      assertNotNull(model.get(String.format("USR%03d", id)));
      assertTrue(model.delete(String.format("USR%03d", id)));
      assertNull(model.get(String.format("USR%03d", id)));
      
      try (OutputStream dataWrite = new FileOutputStream("data/IdCount.json")){
        idFile.put("User", idFile.getInt("User") - 1);
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
