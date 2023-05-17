/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author iakba
 */
public class Quiz extends BaseModel {
  private String name;
//  private Question[] question;
  private String code;
  private String optField;
  
  public Quiz(Document data){
    super("Quiz");
  }
  
  public Quiz(ObjectId id){
    super("Quiz");
  }

  public Quiz setName(String name) {
    this.name = name;
    return this;
  }

  public Quiz setOptField(String optField) {
    this.optField = optField;
    return this;
  }

//  public void addQuestion(Question question){
//    
//  }
  
  public void removeQuestion(int index){
    
  }
  
  @Override
  public void save(){
    
  }
  
  public String getName() {
    return name;
  }

//  public Question[] getQuestion() {
//    return question;
//  }

  public String getCode() {
    return code;
  }

  public String getOptField() {
    return optField;
  }
  
}
