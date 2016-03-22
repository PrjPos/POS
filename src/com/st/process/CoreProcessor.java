/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.process;

import com.st.utils.Constants;
import com.st.utils.SessionManager;
import gdi.gds.db.ConnectionAgent;
import gdi.gds.log.LogAgent;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author SANFON
 */
public class CoreProcessor 
{
  /** Object. */
  protected Connection conn;
  protected LogAgent la = LogAgent.getInstance(Constants.APP_ID);
  protected SessionManager sesMgr = SessionManager.getInstance();
  
  /** Locks for synchronization. */
  private static final Object lock = new Object();
  
  /** Default Constructor. */
  public CoreProcessor(){}
  
  /** For setting the connection. */
  public void setConnection(Connection nconn)
  { this.conn = nconn; }
  
  /**
   * For getting the connection.
   * Always set the connection's autocommit to false.
   */
  public Connection getConnection()
  {
    String fromWhere = "existing";
    //Check if connection already closed or old
    try
    {
      if(null!=conn && (conn.isClosed()||conn.isValid(0)))
      { this.returnConnection(); }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      la.warning(
        this.getClass().getName(),
        "Fail getting connection: " + e.getMessage() +
        ", creating a new one.");
      conn = null;
    }
    
    if(null==conn)
    {
      synchronized(lock)
      {
        if(null==conn)
        {
          fromWhere = "connection pool";
          la.info(this.getClass().getName(), "OPENING NEW CONNECTION!");
          conn = ConnectionAgent.getInstance().getDefaultConnection();
        }
      }
    }

    //Setting autocommit - IMPORTANT FOR ROLLBACK ACTION!!!
    try
    { conn.setAutoCommit(false); }
    catch(SQLException e)
    { 
      la.error(
        this.getClass().getName(), 
        "FAILED SETTING AUTO COMMIT: " + e.getMessage());
      
      //Should never go to here
      this.setAutoCommit(false);
    }
    
    la.info(
      this.getClass().getName(),
      "GOT CONNECTION FOR " + fromWhere + ": " + conn);
       
    return conn;
  }
  
  /** For returning connection. */
  public void returnConnection()
  {
    ConnectionAgent.getInstance().returnDefaultConnection(conn);
    conn = null;
  }
  
  /** Sets the autocommit Status. */
  public void setAutoCommit(boolean status)
  {
    if(null==conn)
    {
      synchronized(lock) { if(null==conn) getConnection(); }
      //{ if(null==conn) conn = ConnectionAgent.getConnection(); }
    }
    
    try
    {
      conn.setAutoCommit(status);
    }
    catch (SQLException e)
    {
      //Error Setting autocommit
      e.printStackTrace();
    }
  }
  
  /** Gets the autocommit Status. */
  public boolean getAutoCommit()
  {
    if(null==conn)
    { return false; }
    
    try
    {
      return conn.getAutoCommit();
    }
    catch (SQLException e)
    {
      //Error Getting autocommit
      e.printStackTrace();
    }
    
    return false;
  }
  
  /** Commit all transaction. */
  public boolean commitTransaction()
  {
    try
    {
      if(!this.getAutoCommit())
      {
        conn.commit();
        la.info(this.getClass().getName(), "Committing transactions.");
      }
      return true;
    }
    catch(Exception e)
    {
      //Fail to commit
      la.warning(this.getClass().getName(),
        "Fail committing transaction:" + e.getMessage());
      return false;
    }
  }
  
  /** Rollback all transaction. */
  public boolean rollbackTransaction()
  {
    try
    {
      if(!this.getAutoCommit())
      {
        conn.rollback();
        la.info(this.getClass().getName(), "Transaction rolled back.");
      }
      else
      {
        throw new Exception(
          "Cannot rollback transaction since auto-rollback is set to true.");
      }
      return true;
    }
    catch(Exception e)
    {
      //Fail to rollback
      la.warning(this.getClass().getName(),
        "Fail rolling back transaction: " + e.getMessage());
      return false;
    }
  }
  
  /**
   * For finalizing the processor process.
   * Also automatically commit all open transaction. \
   */
  public void finalize()
  {
    if(null!=conn)
    {
      //Commit all open transaction first
      this.commitTransaction();
      
      try
      { if(!conn.getAutoCommit()) conn.setAutoCommit(true); }
      catch(Exception e)
      { la.warning(this.getClass().getName(), e.getMessage()); }
      
      la.info(this.getClass().getName(), "RETURNED CONNECTION: " + conn);
      //ConnectionAgent.returnConnection(conn);
      this.returnConnection();
      
      //Final disconnecting the reference to the processor
      conn = null;
    }
    
    this.clearMemory();
  }
  
  /** For running memory clearing and garbage collector. */
  public void clearMemory()
  {
    //Make sure connection is set to null;
    conn = null;
    //System.runFinalization();
    //System.gc();
  }
}
