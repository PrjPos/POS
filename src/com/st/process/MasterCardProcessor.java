/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.process;

import com.st.beans.MasterCardBean;
import com.st.db.MasterCardDB;
import com.st.utils.Constants;
import com.st.utils.DBInfo;
import com.st.utils.Utilities;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Timothy_Fab
 */
public class MasterCardProcessor extends CoreProcessor
{
  public MasterCardProcessor(){}
  
  private MasterCardDB db = null;
  
  /**
   * get all list data from Master Card
   * @param searchBy
   * @param searchByValue
   * @param orderBy
   * @return 
   */
  public MasterCardBean[]getCardList
  (
    String searchBy, 
    String searchByValue, 
    String orderBy
  )   
  {
        //Objects
    MasterCardBean[] beans;
    String addSQL;
    String defOrderBy = "";
    int begin = -1;
    int howMany = -1;  
    
    //The serach base condition
    if(null!=searchBy)
    {  
      addSQL = "WHERE ";   
      if(null!=searchByValue &&
         searchBy.equals(Constants.CARD_SEARCHBY_CODE)
        )
      {
       addSQL += DBInfo.COL_MASTER_CARD_CODE +
                  " LIKE '%" + searchByValue + "%' ";
        defOrderBy = DBInfo.COL_MASTER_CARD_CODE;
      }     
    }
    else //If both search value and search by are nulls
    {
      addSQL = "";
      defOrderBy = DBInfo.COL_MASTER_CARD_CODE;
    }
    
    //Do the order by
    addSQL += "ORDER BY ";
    if(!Utilities.isEmpty(orderBy)) defOrderBy = orderBy;
    addSQL += defOrderBy;
    
    db = new MasterCardDB(super.getConnection());
    try
    {
     //Get the item info, but not the logo
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
   * update data from Master Card 
   * @param bn
   * @return 
   */
  public boolean update(MasterCardBean bn)
  {
    System.out.println("UPDATE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) { db = new MasterCardDB(c); }
    
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
   * create Data Master Card
   * @param bn
   * @return 
   */
  public boolean create(MasterCardBean bn)
  {
    System.out.println("CREATE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) { db = new MasterCardDB(c); }
    
    try
    {
      res = db.insert(bn);
      if(res<0) return false;
      else return true;
    }
    catch(Exception e)
    {e.printStackTrace(); return false;}  
  }
  
  /**
   * delete data from Master Card
   * @param ID
   * @return 
   */
  public boolean delete(String ID)
  {
    System.out.println("DELETE");
    int res;
    Connection c = super.getConnection();
    //Check if db null, initial connection.
    if(null==db) { db = new MasterCardDB(c); }
    
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
