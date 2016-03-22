package com.st.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Timothy_Fab
 */
public class MasterSupplierBean
{
   /** Object. */
  private String ID = null;
  private String Name = null;
  private String Address = null;  
  private String PhoneNumber = null;  
  private String EntryDate = null;  
  private String EntryUser = null;  
  
  /** default constructor */
  public MasterSupplierBean(){}
  
  /** Set ID. */
  public void setID(String val) { ID = val; }
  /** Get ID. */
  public String getID() { return ID; }
  
  /** Set Name. */
  public void setName(String val) { Name = val; }
  /** Get ID. */
  public String getName() { return Name; }
  
  /** Set Address. */
  public void setAddress(String val) { Address = val; }
  /** Get Address. */
  public String getAddress() { return Address; }
  
  /** Set PhoneNumber. */
  public void setPhoneNumber(String val) { PhoneNumber = val; }
  /** Get PhoneNumber. */
  public String getPhoneNumber() { return PhoneNumber; }
  
  /** Set EntryDate. */
  public void setEntryDate(String val) { EntryDate = val; }
  /** Get EntryDate. */
  public String getEntryDate() { return EntryDate; }
  
  /** Set EntryUser. */
  public void setEntryUser(String val) { EntryUser = val; }
  /** Get EntryUser. */
  public String getEntryUser() { return EntryUser; }
  
  
}
