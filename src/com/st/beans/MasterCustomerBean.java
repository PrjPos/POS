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
public class MasterCustomerBean
{
  private String Id = null; 
  private String Name = null; 
  private String Address = null; 
  private String PhoneNumber = null; 
  
  /**Sets id*/
  public void setId(String val){Id = val;}
  /**Gets id*/
  public String getId(){return Id;}    
  
  /**Sets Name*/
  public void setName(String val){Name = val;}
  /**Gets Name*/
  public String getName(){return Name;}  
  
  /**Sets Address*/
  public void setAddress(String val){Address = val;}
  /**Gets Address*/
  public String getAddress(){return Address;}  
  
   /**Sets Address*/
  public void setPhoneNumber(String val){PhoneNumber = val;}
  /**Gets Address*/
  public String getPhoneNumber(){return PhoneNumber;} 
  
}
