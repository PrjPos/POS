/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.process;

import com.st.beans.MasterSupplierBean;
import com.st.db.MasterSupplierDB;
import com.st.utils.Constants;
import com.st.utils.DBInfo;
import com.st.utils.Utilities;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Timothy_Fab
 */
public class MasterSupplierProcessor extends CoreProcessor
{
  private MasterSupplierDB db = null; 
  
  public MasterSupplierProcessor() {}
  
  public MasterSupplierBean[] getSupplierList
  (
    String searchBy, 
    String searchByValue, 
    String orderBy
  )
  {
    //Objects
    MasterSupplierBean[] beans = null;
    String addSQL;
    String defOrderBy = "";
    int begin = -1;
    int howMany = -1;
  
    //The serach base condition
    if(null!=searchBy)
    {  
      addSQL = "WHERE ";
      
     if(null!=searchByValue &&
        searchBy.equals(Constants.SUPPLIER_SEARCHBY_SUPPID))
     {
         addSQL += DBInfo.COL_MASTER_SUPPLIER_ID +
                  " LIKE '%" + searchByValue + "%' ";
         defOrderBy = DBInfo.COL_MASTER_SUPPLIER_ID;
     }  
     else if(null!=searchByValue && 
             searchBy.equals(Constants.SUPPLIER_SEARCHBY_SUPPNM))//Default search by item name
     { 
         addSQL += DBInfo.COL_MASTER_SUPPLIER_NAME +
                " LIKE '%" + searchByValue + "%' ";
         defOrderBy = DBInfo.COL_MASTER_SUPPLIER_NAME; 
     }
     else 
     {
         addSQL += DBInfo.COL_MASTER_SUPPLIER_PHONE_NUMBER +
                   " LIKE '%" + searchByValue + "%' ";
         defOrderBy = DBInfo.COL_MASTER_SUPPLIER_PHONE_NUMBER;   
     }    
    }
    else 
    {
      addSQL = "";
      defOrderBy = DBInfo.COL_MASTER_SUPPLIER_NAME;  
    } 
    
    //Do the order by
    addSQL += "ORDER BY ";
    if(!Utilities.isEmpty(orderBy)) defOrderBy = orderBy;
    addSQL += defOrderBy;
    
    //Entering the data into the DB
    db = new MasterSupplierDB(super.getConnection());
    
    //Start searching for the item info
    try 
    {
      beans = db.list(begin, 
                      howMany,
                      addSQL);
    }
    catch (Exception e) 
    {
      e.printStackTrace();
      beans = null;
    }
      
    return beans;  
  }
  
 /**
   * Update master Supplier. 
   * @param bn
   * @return 
   */   
  public boolean update(MasterSupplierBean bn)
  {
    int res;
    Connection c = super.getConnection();
    
    if(null==db)
    { db = new MasterSupplierDB(c); }
        
      try 
      {
        res = db.update(bn);
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
   * Insert Master Supplier
   * @param bn
   * @return 
   */
  public boolean create(MasterSupplierBean bn)
  {
    System.out.println("CREATE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) { db = new MasterSupplierDB(c); } 
    
      try 
      {
        res = db.insert(bn);
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
   * Delete Master Supplier
   * @param ID
   * @return 
   */
  public boolean delete(String ID)
  {
    System.out.println("DELETE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) { db = new MasterSupplierDB(c); }
    
    try
    {
      res = db.delete(ID);
      if(res<0) 
        return false;
      else 
        return true;
    }
    catch(Exception e)
    {
      e.printStackTrace(); 
      return false;}  
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
