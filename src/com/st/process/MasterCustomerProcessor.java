/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.process;

import com.st.beans.MasterCustomerBean;
import com.st.db.MasterCustomerDB;
import com.st.utils.Constants;
import com.st.utils.DBInfo;
import com.st.utils.Utilities;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Timothy_Fab
 */
public class MasterCustomerProcessor extends CoreProcessor
{
   private MasterCustomerDB db = null;
   
   public MasterCustomerProcessor(){}
   
   /**
    * get all list Master Customer
    * @param searchBy
    * @param searchByValue
    * @param orderBy
    * @return 
    */
   public MasterCustomerBean[] getCustomerList
   (
    String searchBy, 
    String searchByValue, 
    String orderBy
   )        
   {
     //Objects
    MasterCustomerBean[] beans;
    String addSQL = "";
    String defOrderBy = "";
    int begin = -1;
    int howMany = -1;
    
    //The serach base condition
    if(null!=searchBy)
    {  
      addSQL = " WHERE "; 
      
      if(null!=searchByValue && searchBy.equals(Constants.CUSTOMER_SEARCHBY_ID))
      {
        addSQL += DBInfo.COL_MASTER_CUSTOMER_ID +
                  " LIKE '%" + searchByValue + "%' ";
        defOrderBy = DBInfo.COL_MASTER_CUSTOMER_ID; //sort id   
      }
      else if(null!=searchByValue && searchBy.equals(Constants.CUSTOMER_SEARCHBY_NAME))
      {
        addSQL += DBInfo.COL_MASTER_CUSTOMER_NAME +
                  " LIKE '%" + searchByValue + "%' ";
        defOrderBy = DBInfo.COL_MASTER_CUSTOMER_NAME; //sort nm             
      }   
      else
      {
        addSQL += DBInfo.COL_MASTER_CUSTOMER_PHONE_NUMBER +
                  " LIKE '%" + searchByValue + "%' ";
        defOrderBy = DBInfo.COL_MASTER_CUSTOMER_PHONE_NUMBER; //sort phn number          
      }
      
      //Do the order by
      addSQL += "ORDER BY ";
      if(!Utilities.isEmpty(orderBy)) defOrderBy = orderBy;
      addSQL += defOrderBy;
      
      //Entering the data into the DB
      db = new MasterCustomerDB(super.getConnection());
      System.out.println("sql : " + addSQL);
    }
    
    //Start searching for the item info
    try
    {
      //Get the item info, but not the logo
      beans = db.list(begin,
                      howMany,                      
                      addSQL);
     // System.out.println("get id proc__" + beans[0].getId());
    }
    catch(SQLException sqle)
    {
      sqle.printStackTrace();
      beans = null;
    }
       
    return beans;   
   }  
   
   /**
   * Update master Customer
   * @param bn
   * @return 
   */ 
  public boolean update(MasterCustomerBean bn)
  {
    System.out.println("UPDATE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) { db = new MasterCustomerDB(c); }
    
    try
    {
      res = db.update(bn);
      if(res<0) return false;
      else return true;
    }
    catch(Exception e)
    {e.printStackTrace(); return false;}
  }

    /**
   * create Data Master Customer
   * @param bn
   * @return 
   */
  public boolean create(MasterCustomerBean bn)
  {
    System.out.println("CREATE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) { db = new MasterCustomerDB(c); }
    
    try
    {
      res = db.insert(bn);
        System.out.println("HASIL RES MASTER ITEM TYPE :__" + res);
      if(res<0) return false;
      else return true;
    }
    catch(Exception e)
    {e.printStackTrace(); return false;}
  }

  /**
   * delete data master Customer where ID
   * @param ID
   * @return 
   */
  public boolean delete(String ID)
  {
    System.out.println("DELETE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) { db = new MasterCustomerDB(c); }
    
    try
    {
      res = db.delete(ID);
      if(res<0) return false;
      else return true;
    }
    catch(Exception e)
    {e.printStackTrace(); return false;}
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
