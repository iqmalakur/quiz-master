/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import org.bson.types.ObjectId;

/**
 *
 * @author iakba
 */
public abstract class BaseModel extends Connection {
  private ObjectId id;
  
  public BaseModel(String collectionName){
    super(collectionName);
  }

  public ObjectId getId() {
    return id;
  }
  
  public abstract void save();
}
