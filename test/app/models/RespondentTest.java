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
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author iakba
 */
public class RespondentTest {
  private final Respondent model;
  
  public RespondentTest() {
    model = new Respondent();
  }
  
  @Test
  public void testInsert(){
    JSONObject newData = new JSONObject("""
                                        {
                                          "name": "Otong",
                                          "optFieldValue": "Mahasiswa"
                                        }
                                        """);
    assertTrue(model.insert(newData));
    
    LinkedList<JSONObject> data = model.get();
    JSONObject lastData = data.getLast();
    
    assertEquals("Otong", lastData.getString("name"));
    assertEquals("Mahasiswa", lastData.getString("optFieldValue"));
  }

  @Test
  public void testGet() {
    LinkedList<JSONObject> data = model.get();
    JSONObject lastData = data.getLast();
    
    assertEquals("Otong", lastData.getString("name"));
    assertEquals("Mahasiswa", lastData.getString("optFieldValue"));
  }
  
  @Test
  public void testGetByKeyValue() {
    JSONObject dataByName = model.get("name", "Otong");
    
    assertEquals("Otong", dataByName.getString("name"));
    assertEquals("Mahasiswa", dataByName.getString("optFieldValue"));
    
    JSONObject faultData = model.get("name", "oto ng");
    assertNull(faultData);
  }
  
  @Test
  public void testGetByQuery() {
    JSONObject query = new JSONObject("""
                                      {
                                        "name": "Otong",
                                        "optFieldValue": "Mahasiswa"
                                      }
                                      """);
    JSONObject data = model.get(query);
    
    assertEquals("Otong", data.getString("name"));
    assertEquals("Mahasiswa", data.getString("optFieldValue"));
    
    JSONObject faultQuery = new JSONObject("""
                                      {
                                        "name": "Otong",
                                        "optFieldValue": "Dosen"
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
      int id = idFile.getInt("Respondent");
      
      JSONObject data = model.get(String.format("RES%03d", id));
    
      assertEquals("Otong", data.getString("name"));
      assertEquals("Mahasiswa", data.getString("optFieldValue"));

      JSONObject faultData = model.get("RES000");
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
      int id = idFile.getInt("Respondent");
      
      JSONObject beforeUpdate = model.get(String.format("RES%03d", id));
      assertEquals("Otong", beforeUpdate.getString("name"));
      assertEquals("Mahasiswa", beforeUpdate.getString("optFieldValue"));
      
      assertTrue(model.update(
              new JSONObject("""
                             {
                               "name": "Otong Surotong",
                               "optFieldValue": "Dosen"
                             }
                             """),
              String.format("RES%03d", id))
      );
      
      JSONObject afterUpdate = model.get(String.format("RES%03d", id));
      assertEquals("Otong Surotong", afterUpdate.getString("name"));
      assertEquals("Dosen", afterUpdate.getString("optFieldValue"));
    } catch(IOException e){
      System.out.println(e);
    }
  }
  
  @Test
  public void testDelete(){
    try(InputStream dataRead = new FileInputStream("data/IdCount.json")) {
      byte[] rawData = dataRead.readAllBytes();
      
      JSONObject idFile = new JSONObject(new String(rawData));
      int id = idFile.getInt("Respondent");
      
      assertNotNull(model.get(String.format("RES%03d", id)));
      assertTrue(model.delete(String.format("RES%03d", id)));
      assertNull(model.get(String.format("RES%03d", id)));
      
      try (OutputStream dataWrite = new FileOutputStream("data/IdCount.json")){
        idFile.put("Respondent", idFile.getInt("Respondent") - 1);
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
