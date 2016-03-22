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
public class MasterCardBean 
{
  private String Code = null;   
  private String Card = null;   
  
  /**Sets Code*/
  public void setCode(String val){Code = val;}
  /**Gets Code*/
  public String getCode(){return Code;}      
  
  /**Sets Card*/
  public void setCard(String val){Card = val;}
  /**Gets Card*/
  public String getCard(){return Card;}    
}
