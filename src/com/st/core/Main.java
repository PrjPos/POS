/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.core;

import com.st.beans.MasterItemTypeBean;
import com.st.ui.Home;
import com.st.ui.Login;
import com.st.ui.MasterCardList;
import com.st.ui.MasterCustomerList;
import com.st.ui.MasterItemList;
import com.st.ui.MasterItemTypeList;
import com.st.ui.MasterSupplierList;
import com.st.ui.MasterUserList;
import com.st.utils.Constants;
import com.st.utils.SessionManager;
import gdi.gds.db.ConnectionAgent;
import gdi.gds.db.ConnectionConstants;
import gdi.gds.db.ConnectionManager;

import gdi.gds.log.LogAgent;
import gdi.gds.log.LogLevel;
import gdi.gds.log.LogManager;
import gdi.gds.log.LogWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author SANFON
 */
public class Main 
{
  /** Log Object to log App. */
  private LogAgent la = null;
  private Thread logDaemon = null;
  private LogManager logMgr = null;
  
  /** Module. */
  private static Login l = null;
  private static MasterItemTypeList mit = null;
  private static MasterSupplierList msl = null;
  private static MasterUserList mul = null;
  private static MasterCustomerList mcl = null;
  private static Home h = null;
  private static MasterItemList itemList = null;
  private static MasterCardList mcard = null;
  
  /** Connection Object. */
  private ConnectionManager poolMgr = null;
  
  /** Session manager instance. */
  private SessionManager s = SessionManager.getInstance();

  /** Lock object. */
  private static final Object lock = new Object();
  
  /** Constructor used to starting all background process. */
  public Main(String propPath)
  {
    try
    {
      Constants.CONFIGFILEPATH = propPath;
      loadDefaultProperties();
      loadLogDaemon();
      loadCashierHeaderPrintout();
      loadCashierFooterPrintout();

      loadDBPool(); //CONN HERE
      
      /* Load modul login. */
      this.callModule(0); //1 artinya panggil modul login.
      System.out.println("ALL IMPORTANT ELEMENT HAS BEEN LOADED!!!");
    }
    catch(Exception e)
    {e.printStackTrace();}
  }
  
  /** Loading default properties. */
  private void loadDefaultProperties() throws Exception
  {
    FileInputStream fis = new FileInputStream(Constants.CONFIGFILEPATH);

    s.getProps().load(fis);
    fis.close();
    System.out.println("Initial Config File Loaded!");
  }
  
  /**
   * Loading log daemon. With my own custom class.
   */
  private void loadLogDaemon() throws Exception
  {
    //Objects
    LogWriter console;
    LogLevel pl;
    String temp;

    //Initiating the log agent first
    la = LogAgent.getInstance(Constants.APP_ID);

    //Adding the console log
    console = new LogWriter();
    la.addWriter(console);

    //Check if we should turn the log on or off
    if(
        s.getProp(Constants.LOG_INIT_STATUS).equalsIgnoreCase(
          "OFF")
      )
    {
      la.writeln(LogLevel.SYSTEM,
                 this.getClass().getName(),
                 "Server file logging is disabled by the system " +
                 "admin! Only console logging available.");
      la.removeWriter(console);
      return;
    }

    //Setting the minimum log level to print
    temp = s.getProp(Constants.LOG_MIN_PRINT_LEVEL);
    if(null!=temp && temp.equals(LogLevel.INFO.getLevel()))
    { pl = LogLevel.INFO; }
    else if(null!=temp && temp.equals(LogLevel.WARNING.getLevel()))
    { pl = LogLevel.WARNING; }
    else if(null!=temp && temp.equals(LogLevel.SEVERE.getLevel()))
    { pl = LogLevel.SEVERE; }
    else if(null!=temp && temp.equals(LogLevel.SYSTEM.getLevel()))
    { pl = LogLevel.SYSTEM; }
    else
    { pl = LogLevel.ERROR; }

    //Adding the file log
    logMgr = new LogManager(
                     Constants.APP_ID,
                     s.getProp(Constants.LOG_FILE_PATH),
                     s.getProp(Constants.LOG_FILE_PREFIX),
                     s.getProp(Constants.LOG_FILE_SUFFIX),
                     s.getProp(Constants.LOG_FILE_PATTERN),
                     Integer.parseInt(s.getProp(Constants.LOG_BUFFER_SIZE)),
                     Integer.parseInt(s.getProp(Constants.LOG_FILE_MAX_SIZE)),
                     Integer.parseInt(s.getProp(Constants.LOG_FILE_COUNT)),
                     Integer.parseInt(s.getProp(Constants.LOG_ROLL_TIME)),
                     pl);

    //Run the log daemon
    logDaemon = new Thread(logMgr);
    logDaemon.start();

    la.writeln(
      LogLevel.SYSTEM,
      this.getClass().getName(),
      "Log daemon loaded with level: " + pl.getLevel());
  }
  
  /** Loads the header layout for the cashier printout. */
  private void loadCashierHeaderPrintout()
  {
    BufferedReader br = null;
    String header="", temp;
    String lnBreak = System.getProperty("line.separator");

    try
    {
      //Try to get the header
      br = new BufferedReader(
        new FileReader(s.getProp(Constants.CASHIERPRINTOUT_HEADER)));

      //Try to read all lines
      while(true)
      {
        temp = br.readLine();
        if(null==temp) break;
        header += temp + lnBreak;
      }

      System.out.println("Cashier printout header loaded!");
    }
    catch(Exception e)
    {
      e.printStackTrace();
      System.out.println(
        "Printout header not found, set to standard header.");

      header = "              Company Name             " + lnBreak +
               "             Company Address           " + lnBreak +
               "            Phone, Fax, Email          " + lnBreak +
               "            Other Information          " + lnBreak;
    }
    finally
    {
      //Always setting the header
      s.setCashierPrintoutHeader(header);

      try
      { if(null!=br) br.close(); }
      catch (IOException ex)
      { ex.printStackTrace(); }
    }
  }

  /** Loads the footer layout for the cashier printout. */
  private void loadCashierFooterPrintout()
  {
    BufferedReader br = null;
    String footer="", temp;
    String lnBreak = System.getProperty("line.separator");

    try
    {
      //Try to get the header
      br = new BufferedReader(
        new FileReader(s.getProp(Constants.CASHIERPRINTOUT_FOOTER)));

      //Try to read all lines
      while(true)
      {
        temp = br.readLine();
        if(null==temp) break;
        footer += temp + lnBreak;
      }

      System.out.println("Cashier printout footer loaded!");
    }
    catch(Exception e)
    {
      e.printStackTrace();
      System.out.println(
        "Printout footer not found, set to standard header.");

      footer = "                Thank You              " + lnBreak +
               "      For Purchasing At Our Shop       " + lnBreak;
    }
    finally
    {
      //Always setting the header
      s.setCashierPrintoutFooter(footer);

      try
      { if(null!=br) br.close(); }
      catch (IOException ex)
      { ex.printStackTrace(); }
    }
  }
  
  public void loadDBPool() throws Exception
  {
    String dbPoolAPI = s.getProp(ConnectionConstants.DBPOOL_API);
    String dbPoolCfgType = s.getProp(ConnectionConstants.DBPOOL_CFGTYPE);
    String dbPoolCfgObject = s.getProp(ConnectionConstants.DBPOOL_CFGOBJECT);

    String username = "root";
    String password = "mysql";

    la.writeln(LogLevel.SYSTEM,
      this.getClass().getName(),
      "Loading database pool API: " + dbPoolAPI);

    //Calling the database based on the chosen API
    ConnectionAgent.getInstance().initDB(
    dbPoolAPI, dbPoolCfgType, dbPoolCfgObject, username, password);
    la.writeln(
        LogLevel.SYSTEM,
        this.getClass().getName(),
        "Initialized GD Database Pool Daemon.");

    la.writeln(LogLevel.SYSTEM,
                 this.getClass().getName(),
                 "Database Pool daemon loaded.");
  }
  
  public static final void callModule(int Modul)
  {
    switch(Modul)
    {
      case Constants.MOD_ITEM_TYPE:
        mit = new MasterItemTypeList();
        mit.setVisible(true);
        mit.toFront();
        break;
      case Constants.MOD_HOME:
        h = new Home();
        h.setVisible(true);
        h.toFront();
        break;
      case Constants.MOD_ITEM:
        itemList = new MasterItemList();
        itemList.setVisible(true);
        itemList.toFront();
        break;
      case Constants.MOD_SUPPLIER:
        msl = new MasterSupplierList();
        msl.setVisible(true);
        msl.toFront();
        break;
      case Constants.MOD_USER:
        mul = new MasterUserList();
        mul.setVisible(true);
        mul.toFront();       
        break;
      case Constants.MOD_CUSTOMER:
        mcl = new MasterCustomerList();
        mcl.setVisible(true);
        mcl.toFront();       
        break;  
      case Constants.MOD_CARD:
        mcard = new MasterCardList();
        mcard.setVisible(true);
        mcard.toFront();       
        break;  
      default:
        l = new Login();
        l.setVisible(true);
        l.toFront();
        break;
        
    }
  }
  
  
  
  /** The application performer.
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    /*
    System.out.println("Argument Length: " + args.length);
    System.out.println("Arguments: " + args);

    for(int a=0; a<args.length; a++)
    {
      System.out.println("Arguments: " + args[a]);
    }
    */

    if(null==args||args.length!=1)
    {
      System.out.println("Error running syntax! Use Runme <properties path>");
      System.out.println("Ex: Runme C:/test/GDCashier/props/app.prop");
      System.out.println(args.length);
      return;
    }

    System.out.println("Got property: " + args[0]);
    Main m = new Main(args[0]);
  }
}
