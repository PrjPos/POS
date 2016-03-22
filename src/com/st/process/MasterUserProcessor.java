/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.process;

import com.st.beans.MasterUserBean;
import com.st.db.MasterUserDB;
import com.st.utils.Constants;
import com.st.utils.DBInfo;
import com.st.utils.Utilities;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Timothy_Fab
 */
public class MasterUserProcessor extends CoreProcessor
{
  private MasterUserDB db = null;
  
  public MasterUserProcessor() {}
 
  /**
   * get all Master User List, and search by 
   * @param searchBy
   * @param searchByValue
   * @param orderBy
   * @return 
   */
  public MasterUserBean[] getUserList
  (
   String searchBy,
   String searchByValue,
   String orderBy
  )
  {
    MasterUserBean [] beans = null;
    String addSQL;
    String defOrderBy = "";
    int begin = -1;
    int howMany = -1;
    
    //The serach base condition
    if(null!=searchBy)
    {  
      addSQL = "WHERE ";  
      if(
         null!=searchByValue &&
         searchBy.equals(Constants.USER_SEARCHBY_USERLOGIN)
        )
      {
         addSQL += DBInfo.COL_MASTER_USER_LOGIN+
                   " LIKE '%" + searchByValue + "%' ";
        defOrderBy = DBInfo.COL_MASTER_USER_LOGIN; 
      }
      else 
      {
        addSQL += DBInfo.COL_MASTER_USER_NAME +
                  " LIKE '%" + searchByValue + "%' ";
        defOrderBy = DBInfo.COL_MASTER_USER_NAME;  
      }        
    }
    else
    {
      addSQL = "";
      defOrderBy = DBInfo.COL_MASTER_USER_NAME;   
    }    
    
    addSQL += "ORDER BY ";
    if(!Utilities.isEmpty(orderBy)) defOrderBy = orderBy;
    addSQL += defOrderBy;
    
    //Entering the data into the DB
    db = new MasterUserDB(super.getConnection());
    System.out.println("sql : " + addSQL);
    
    //Start searching for the item info
    try
    {
      beans = db.list(begin, howMany, addSQL);
    }    
    catch(SQLException e)
    {
      e.printStackTrace();
      beans = null;
    }    
   return beans;
  }      
  
  public MasterUserBean validateLogin(String UserName, String UserPass)
  {
    MasterUserBean bn = null;
   try
   {
     db = new MasterUserDB(super.getConnection());
     bn = db.validate(UserName, UserPass);
     
   }
   catch(Exception e)
   {e.printStackTrace();}
   
   return bn;
  }
  
  /**
   * update data Master User
   * @param bn
   * @return 
   */
  public boolean update(MasterUserBean bn)
  {
    System.out.println("UPDATE");
    int res; 
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) 
    { db = new MasterUserDB(c); }  
      
    try 
    {
      res = db.update(bn);
      System.out.println("hasil res_______" + res);
      if(res<0)return false;  
      else return true;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;  
    }      
  }
  
  /**
   * insert data to Master User
   * @param bn
   * @return 
   */
  public boolean create(MasterUserBean bn)
  {
    System.out.println("CREATE");
    int res;
    Connection c = super.getConnection();   
    if(null==db) 
    {db = new MasterUserDB(c); }
    
      try 
      {
        //call method insert from db  
        res = db.insert(bn);
        if(res<0) return false;
        else return true;  
      }
      catch (Exception e)
      {
        e.printStackTrace();
        return false;  
      }
  }
  
  public boolean delete(String Name)
  {
    System.out.println("DELETE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db)
    { db = new MasterUserDB(c); }  
    
    try 
    {
      res = db.delete(Name);
      if(res<0) 
      return false;
      else   
      return true;     
    }
    catch (Exception e) 
    {
     e.printStackTrace();
     return false;
    }
  }  
  
   /** 
   * Finalize this class. 
   * Should be called by garbage collector or caller class.
   */ 
  public void finalize()
  {
    //DB
    if(null!=db) db.finalize();
    
    //Call super
    super.finalize();
  }
}
