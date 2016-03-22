/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.beans;

import gdi.gds.msg.beans.MessageBean;

/**
 *
 * @author SANFON
 */
public class MasterItemTypeBean 
{
  /** Object. */
  private String ID = null;
  private String Name = null;
  private String Note = null;
  
  /** msg. */
  
  /** Default Constructor. */
  public MasterItemTypeBean() {}
  
  /** Set ID. */
  public void setID(String val) { ID = val; }
  /** Get ID. */
  public String getID() { return ID; }
  
  /** Set Name. */
  public void setName(String val) { Name = val; }
  /** Get Name. */
  public String getName() { return Name; }
  
  /** Set Note. */
  public void setNote(String val) { Note = val; }
  /** Get Note. */
  public String getNote() { return Note; }
  
}
