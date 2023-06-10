/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import app.Controller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author iakba
 */

public abstract class Model {
  private final String fileName;
  private final String idPrefix;

  /**
   * Menginisialisasi objek dari Model <br>
   * Membaca data dari file JSON
   * 
   * @param fileName Nama file JSON yang akan digunakan
   * @param idPrefix Prefix dari ID untuk model
   */
  public Model(String fileName, String idPrefix) {
    this.fileName = fileName;
    this.idPrefix = idPrefix;
  }

  /**
   * Mengambil semua data untuk model pada file JSON
   * 
   * @return LinkedList dari data yang berbentuk LinkedList dari JSONObject
   */
  public LinkedList<JSONObject> get() {
    try(InputStream dataRead = new FileInputStream("data/" + fileName + ".json")) {
      byte[] byteData = dataRead.readAllBytes();
      
      JSONArray data = new JSONArray(new String(byteData));
      LinkedList<JSONObject> result = new LinkedList<>();

      // Mengisi linked list dengan data pada file JSON
      data.forEach(item -> result.add((JSONObject) item));

      return result;
    } catch(IOException e){
      Controller.showErrorDialog("Terjadi error saat mengambil data!");
      return null;
    }
  }

  /**
   * Mengambil data spesifik berdasarkan Id pada file JSON
   * 
   * @param id Id dari data yang dicari berupa String
   * @return   Data yang dicari, berupa JSONObject
   */
  public JSONObject get(String id) {
    LinkedList<JSONObject> data = get();
    
    for(JSONObject item : data){
      if(item.get("_id").equals(id)){
        return item;
      } 
    }
    
    return null;
  }
  
  /**
   * Mengambil data spesifik berdasarkan key dan value tertentu pada file JSON
   * 
   * @param key   Key pada file JSON
   * @param value Nilai dari key
   * @return      Data yang dicari, berupa JSONObject
   */
  public JSONObject get(String key, Object value) {
    LinkedList<JSONObject> data = get();
    
    for(JSONObject item : data){
      if(item.get(key).equals(value)){
        return item;
      } 
    }
    
    return null;
  }
  
  /**
   * Mengambil data spesifik berdasarkan query JSON tertentu <br>
   * Digunakan untuk mencari data dengan menggunakan
   * lebih dari satu key dan value
   * 
   * @param query Object JSONObject yang berisi key - value untuk query pencarian
   * @return      Data yang dicari, berupa JSONObject
   */
  public JSONObject get(JSONObject query) {
    LinkedList<JSONObject> data = get();
    Set<String> keys = query.keySet();
    
    for(JSONObject item : data){
      boolean same = true;
      
      for(String key : keys) {
        if(!query.get(key).equals(item.get(key))){
          same = false;
        }
      }
      
      if(same) return item;
    }
    
    return null;
  }
  
  /**
   * Menulis ke file JSON
   * 
   * @param data Data yang akan ditulis berbentuk JSONObject
   * @return     Mengembalikan true jika data berhasil ditulis
   */
  protected boolean write(JSONArray data){
    try (OutputStream dataWrite = new FileOutputStream("data/" + fileName + ".json")){
      byte[] byteData = data.toString().getBytes();
      dataWrite.write(byteData);

      return true;
    } catch(IOException e){
      Controller.showErrorDialog("Terjadi error saat menulis data!");
      return false;
    }
  }
  
  /**
   * Menambahkan data baru pada file JSON
   * 
   * @param data Data yang akan ditambahkan berbentuk JSONObject
   * @return     Mengembalikan data jika berhasil ditambahkan dan null jika gagal
   */
  public JSONObject insert(JSONObject data){
    JSONArray jsonData = new JSONArray(get());
    
    try(InputStream dataRead = new FileInputStream("data/IdCount.json")) {
      byte[] rawData = dataRead.readAllBytes();
      
      JSONObject idFile = new JSONObject(new String(rawData));
      int id = idFile.getInt(fileName);
      
      try (OutputStream dataWrite = new FileOutputStream("data/IdCount.json")){
        idFile.put(fileName, idFile.getInt(fileName) + 1);
        
        byte[] byteData = idFile.toString().getBytes();
        dataWrite.write(byteData);
      } catch(IOException e){
        Controller.showErrorDialog("Terjadi error saat menulis data!");
        return null;
      }
      
      data.put("_id", idPrefix + String.format("%03d", id + 1));
      jsonData.put(data);
      
      if(write(jsonData)) return data;
    } catch(IOException e){
      Controller.showErrorDialog("Terjadi error saat mengambil data!");
    }
    
    return null;
  }
  
  /**
   * Menghapus data tertentu pada file JSON
   * 
   * @param id Id dari data yang akan dihapus berbentuk String
   * @return   Mengembalikan true jika data berhasil dihapus
   */
  public boolean delete(String id){
    LinkedList<JSONObject> data = get();
    JSONArray jsonData = new JSONArray(data);
    int i = 0;
    
    for(JSONObject item : data){
      if(item.getString("_id").equals(id)){
        jsonData.remove(i);
        return write(jsonData);
      }
      
      i++;
    }
    
    return false;
  }
  
  /**
   * Mengubah data pada file JSON
   * 
   * @param data Data baru berupa JSONObject
   * @param id   Id dari data yang akan diubah berupa String
   * @return     Mengembalikan true jika berhasil dan false jika gagal
   */
  public JSONObject update(JSONObject data, String id) {
    LinkedList<JSONObject> allData = get();
    JSONObject target = get("_id", id);
    
    Set<String> keys = target.keySet();
    
    keys.forEach(key -> {
      if(!key.equals("_id")){
        target.put(key, data.has(key) ?
                   data.get(key) : target.get(key));
      }
    });
    
    // Set data yang diubah
    for(int i = 0; i < allData.size(); i++){
      if(allData.get(i).getString("_id")
                .equals(target.getString("_id"))){
        allData.set(i, target);
        return write(new JSONArray(allData)) ? target : null;
      }
    }
    
    return null;
  }
}
