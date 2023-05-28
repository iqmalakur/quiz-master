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
      byte[] rawData = dataRead.readAllBytes();
      
      JSONArray data = new JSONArray(new String(rawData));
      LinkedList<JSONObject> result = new LinkedList<>();

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
    JSONObject result = null;
    
    for(JSONObject item : data){
      if(result == null){
        if(item.get("_id").equals(id)){
          result = item;
          break;
        }
      } 
    }
    
    return result;
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
    JSONObject result = null;
    
    for(JSONObject item : data){
      if(result == null){
        if(item.get(key).equals(value)){
          result = item;
          break;
        }
      } 
    }
    
    return result;
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
    JSONObject result = null;
    Set<String> keys = query.keySet();
    
    for(JSONObject item : data){
      if(result == null){
        boolean same = true;
        
        for(String key : keys) {
          if(!query.get(key).equals(item.get(key))){
            same = false;
          }
        }
        
        if(same){
          result = item;
          break;
        }
      } 
    }
    
    return result;
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
   * @return     Mengembalikan true jika data berhasil ditambahkan
   */
  public boolean insert(JSONObject data){
    LinkedList<JSONObject> allData = get();
    JSONArray jsonData = new JSONArray(allData);
    
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
      }
      
      data.put("_id", idPrefix + String.format("%03d", id + 1));
      jsonData.put(data);
      
      return write(jsonData);
    } catch(IOException e){
      Controller.showErrorDialog("Terjadi error saat mengambil data!");
      return false;
    }
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
  public boolean update(JSONObject data, String id) {
    LinkedList<JSONObject> allData = get();
    JSONObject target = get("_id", id);
    
    Set<String> keys = target.keySet();
    
    keys.forEach(key -> {
      if(!key.equals("_id")){
        target.put(key, data.has(key) ?
        data.get(key) : target.get(key));
      }
    });
    
    for(int i = 0; i <= allData.size(); i++){
      if(allData.get(i).getString("_id").equals(target.getString("_id"))){
        allData.set(i, target);
        break;
      }
    }
    
    JSONArray jsonData = new JSONArray(allData);

    return write(jsonData);
  }
}
