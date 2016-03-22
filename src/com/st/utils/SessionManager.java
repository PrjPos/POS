/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.utils;

import java.util.Properties;

/**
 * This is singleton class for holding setting variable.
 * @author SANFON
 */
public class SessionManager 
{
  /** Actual Instance of session manager.*/
  private static SessionManager sm = new SessionManager();
  /** Lock for the current pool. */
  private final static Object lock = new Object();
  
  /** Application Properties. */
  private Properties props = new Properties();
  /** Confidential Properties. */
  private Properties confProps = new Properties();
  
  /** The header for the cashier printout. */
  private String cashierPrintoutHeader = "";
  /** The footer for the cashier printout. */
  private String cashierPrintoutFooter = "";
  
  
  /** Get the only one instance of session manager. */
  public static final synchronized SessionManager getInstance()
  {
    synchronized(lock)
    {
      if(null==sm) sm = new SessionManager();
    }
    return sm;
  }
  
  /** Sets the application properties. */
  public void setProps(Properties p) { synchronized(lock) { props = p; } }
  /** Gets the complete application properties. */
  public Properties getProps() { return props; }
  
  /** Sets a single value to the application properties. */
  public void setProp(String param, String value)
  { synchronized(lock) { props.setProperty(param, value); } }
  /** Gets a single value to the application properties. */
  public String getProp(String param)
  { return props.getProperty(param); }
  /** Removes a property from the parameter. 
   * @return String - the previous value if any.
   */
  public void removeProp(String param)
  { synchronized(lock) { props.remove(param); } }
  
  /** Sets the confidential properties. */
  public void setConfProps(Properties p) 
  { synchronized(lock) { confProps = p; } }
  /** Gets the complete confidential properties. */
  public Properties getConfProps() { return confProps; }
  
  /** Store ID of the cashier. */
  private String storeID;

  /** Terminal ID for the cashier. */
  private String terminalID;
  
  /** Sets a single value to the confidential properties. */
  public synchronized void setConfProp(String param, String value)
  { 
    synchronized(lock) 
    { confProps.setProperty(param, value); } 
  }
  
  /** Gets a single value to the confidential properties. */
  public String getConfProp(String param)
  { return confProps.getProperty(param); }
  /** Removes a property from the parameter. 
   * @return String - the previous value if any.
   */
  public void removeConfProp(String param)
  { synchronized(lock) { confProps.remove(param); } }
  
  /** Sets the cashier printout header. */
  public void setCashierPrintoutHeader(String val) 
  { cashierPrintoutHeader = val; }
  /** Gets the cashier printout header. */
  public String getCashierPrintoutHeader() { return cashierPrintoutHeader; }

  /** Sets the cashier printout footer. */
  public void setCashierPrintoutFooter(String val)
  { cashierPrintoutFooter = val; }
  /** Gets the cashier printout footer. */
  public String getCashierPrintoutFooter() { return cashierPrintoutFooter; }
}
