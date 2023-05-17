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
public class Respondent extends BaseModel {
  private String name;
  private String optFieldValue;
  private int score;
  private int answerTime;
  private  String[] quizAnswer;
  
  public Respondent(Document data){
    super("Respondent");
  }
  
  public Respondent(ObjectId id){
    
  }
  
  public Respondent setScore(int score){
    this.score = score;
    return this;
  }
  
  public Respondent setAnswerTime(int answerTime){
    this.answerTime = answerTime;
    return this;
  }
  
  @Override
  public void save(){
    
  }
  
  public void addAnswer(String answer){
    
  }
  
  public String getName(){
    return this.name;
  }
  
  public String getOptField(){
    return this.optFieldValue;
  }
  
  public int getScore(){
    return score;
  }
  
  public int getAnswerTime(){
    return answerTime;
  }
  
  public String[] getQuizAnswer(){
    return quizAnswer;
  }
  
}
