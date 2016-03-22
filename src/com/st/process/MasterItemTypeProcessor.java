/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.process;

import com.st.beans.MasterItemTypeBean;
import com.st.db.MasterItemTypeDB;
import com.st.utils.Constants;
import com.st.utils.DBInfo;
import com.st.utils.Utilities;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author SANFON
 */
public class MasterItemTypeProcessor extends CoreProcessor
{
  private MasterItemTypeDB db = null;
  
  public MasterItemTypeProcessor() {}
  
  public MasterItemTypeBean[] getItemTypeList
  (
    String searchBy, 
    String searchByValue, 
    String orderBy
  )
  {
    //Objects
    MasterItemTypeBean[] beans;
    String addSQL;
    String defOrderBy = "";
    int begin = -1;
    int howMany = -1;

    
    
    //The serach base condition
    if(null!=searchBy)
    {  
      
      //System.out.println("Search base: " + searchBy);
      //System.out.println("Search value: " + searchByValue);
      addSQL = "WHERE ";
      if(
          null!=searchByValue &&
          searchBy.equals(Constants.ITEMTYPE_SEARCHBY_ITEMID)
        )
      {
        addSQL += DBInfo.COL_MASTER_ITEM_TYPE_ID +
                  " LIKE '%" + searchByValue + "%' ";
        defOrderBy = DBInfo.COL_MASTER_ITEM_TYPE_ID;
      }      
      else //Default search by item name
      {
        addSQL += DBInfo.COL_MASTER_ITEM_TYPE_NAME +
                  " LIKE '%" + searchByValue + "%' ";
        defOrderBy = DBInfo.COL_MASTER_ITEM_TYPE_NAME;
      }
    }
    else //If both search value and search by are nulls
    {
      addSQL = "";
      defOrderBy = DBInfo.COL_MASTER_ITEM_TYPE_NAME;
    }
    
    //System.out.println("SQL: " + addSQL);
    //Do the order by
    addSQL += "ORDER BY ";
    if(!Utilities.isEmpty(orderBy)) defOrderBy = orderBy;
    addSQL += defOrderBy;
       
    //Entering the data into the DB
    db = new MasterItemTypeDB(super.getConnection());

    //Start searching for the item info
    try
    {
      //Get the item info, but not the logo
      beans = db.list(begin,
                      howMany,                      
                      addSQL);
    }
    catch(SQLException sqle)
    {
      sqle.printStackTrace();
      beans = null;
    }

    return beans;
  }
  /**
   * Update master item type. 
   * @param bn
   * @return 
   */ 
  public boolean update(MasterItemTypeBean bn)
  {
    System.out.println("UPDATE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) { db = new MasterItemTypeDB(c); }
    
    try
    {
      res = db.update(bn);
      if(res<0) return false;
      else return true;
    }
    catch(Exception e)
    {e.printStackTrace(); return false;}
  }
  
  public boolean create(MasterItemTypeBean bn)
  {
    System.out.println("CREATE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) { db = new MasterItemTypeDB(c); }
    
    try
    {
      res = db.insert(bn);
      if(res<0) return false;
      else return true;
    }
    catch(Exception e)
    {e.printStackTrace(); return false;}
  }
  
  public boolean delete(String ID)
  {
    System.out.println("DELETE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) { db = new MasterItemTypeDB(c); }
    
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
