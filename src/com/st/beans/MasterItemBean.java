/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.beans;

import java.util.Date;

/**
 *
 * @author SANFON
 */
public class MasterItemBean 
{
  private String Id = null;
  private String Name = null;
  private String ItemType = null;
  private double SalesPrice = 0;
  private double PurchasePrice = 0;
  private String EntryUser = null;
  private Date EntryDate = null;
  
  /** Default Constructor. */
  public MasterItemBean(){}
  
  /** Set */
  public void setId(String val) { Id = val; }
  /** Get */
  public String getId() { return Id; }
  
  /** Set */
  public void setName(String val) { Name = val; }
  /** Get */
  public String getName() { return Name; }  

  /** Set */
  public void setItemType(String val) { ItemType = val; }
  /** Get */
  public String getItemType() { return ItemType; }
  
  /** Set */
  public void setSalesPrice(double val) { SalesPrice = val; }
  /** Get */
  public double getSalesPrice() { return SalesPrice; }
  
  /** Set */
  public void setPurchasePrice(double val) { PurchasePrice = val; }
  /** Get */
  public double getPurchasePrice() { return PurchasePrice; }
  
  /** Set */
  public void setEntryUser(String val) { EntryUser = val; }
  /** Get */
  public String getEntryUser() { return EntryUser; }
  
  /** Set */
  public void setEntryDate(Date val) { EntryDate = val; }
  /** Get */
  public Date getEntryDate() { return EntryDate; }
}
