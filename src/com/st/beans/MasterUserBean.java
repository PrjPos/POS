/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.beans;

/**
 *
 * @author Timothy_Fab
 */
public class MasterUserBean 
{
  private String UserLogin = null;   
  private String Passowrd = null;   
  private String Name = null;   
  private String MasterAccess = null;   
  private String RecordAccess = null;   
  private String ReportAccess = null;   
//  
  /** default constructor*/
  public MasterUserBean(){}
  
  /**Sets UserLogin*/
  public void setUserLogin(String val){UserLogin = val;}
  /**Gets UserLogin*/
  public String getUserLogin(){return UserLogin;}      
  
  /**Sets Passowrd*/
  public void setPassowrd(String val){Passowrd = val;}
  /**Gets Passowrd*/
  public String getPassowrd(){return Passowrd;}      
  
  /**Sets Name*/
  public void setName(String val){Name = val;}
  /**Gets Name*/
  public String getName(){return Name;}    
  
  /**Sets MasterAccess*/
  public void setMasterAccess(String val){MasterAccess = val;}
  /**Gets MasterAccess*/
  public String getMasterAccess(){return MasterAccess;}    
  
  /**Sets RecordAccess*/
  public void setRecordAccess(String val){RecordAccess = val;}
  /**Gets RecordAccess*/
  public String getRecordAccess(){return RecordAccess;}    
  
  /**Sets MasterAccess*/
  public void setReportAccess(String val){ReportAccess = val;}
  /**Gets MasterAccess*/
  public String getReportAccess(){return ReportAccess;}    
  
  
}
