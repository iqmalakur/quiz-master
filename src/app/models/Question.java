/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.models;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author User
 */
public class Question extends BaseModel {
  private String question;
  private int time;
  private int grade;
  private String type;
  
  public Question(Document data){
    super("Question");
  }
  
  public Question(ObjectId id){
    
  }
  
  public Question setQuestion(String question){
    this.question = question;
    return this;
  }
  
  public Question setTime(int time){
    this.time = time;
    return this;
  }
  
  public Question setGrade(int grade){
    this.grade = grade;
    return this;
  }
  
  public Question setAnswer(Answer answer){
    
  }
  
  @Override
  public void save(){
    
  }
  
  public String getQuestion(){
    return question;
  }
  
  public int getTime(){
    return time;
  }
  
  public int getGrade(){
    return grade;
  }
  
  public String getType(){
    return type;
  }
}
