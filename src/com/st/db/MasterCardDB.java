/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.db;

import com.st.beans.MasterCardBean;
import com.st.utils.DBInfo;
import gdi.gds.appserver.db.SvrDB;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Timothy_Fab
 */
public class MasterCardDB extends SvrDB
{
  /** Default Constructor with DB Connection. */
  public MasterCardDB(Connection cnctn)
  {super(cnctn);}
  
  /**
   * Master Card
   * @param Code
   * @return 
   */
  public MasterCardBean get(String Code)
  throws SQLException
  {
    MasterCardBean bean;  
    SQL = " WHERE " + DBInfo.COL_MASTER_CARD_CODE + "='"+Code+"';";  
    
     search(DBInfo.TABLE_MASTER_CARD, SQL);
     bean = this.next();
    return bean;
  } 
  
  /**
   * get data from database
   * @return
   * @throws SQLException 
   */
  public MasterCardBean next()
  throws SQLException
  {
   MasterCardBean bean = null;
   if(null!=rs && rs.next())
   {
     bean = new MasterCardBean();
     bean.setCode(rs.getString(DBInfo.COL_MASTER_CARD_CODE));
     bean.setCard(rs.getString(DBInfo.COL_MASTER_CARD_CARD));
   }
   return bean;   
  }        
  
  /**
   * get all list data Master Card
   * @param begin
   * @param howMany
   * @param addSQL
   * @return
   * @throws SQLException 
   */
  public MasterCardBean[]list(int begin, int howMany, String addSQL)
  throws SQLException
  {
    
    MasterCardBean []beans; 
    String limit = super.formLimit(begin, howMany);
    
    //Check Add SQL
    if(null==addSQL) addSQL = "";
    
    //search data
    search(DBInfo.TABLE_MASTER_CARD, addSQL + limit);
    beans = new MasterCardBean[super.getFoundNumberOfRecords()];
    
    //Iterate
    for (int i = 0; i < beans.length; i++) 
    {
      MasterCardBean bean = this.next();
      if(null!=bean)
      { beans[i] = bean; }
      else
      { break; }
    }
    return beans;  
  }        
 
  /**
   * insert data Master Card
   * @param bn
   * @return
   * @throws SQLException 
   */
 public int insert(MasterCardBean bn)
 throws SQLException
 {
   
  SQL = "INSERT INTO " + DBInfo.TABLE_MASTER_CARD +
          "(" +
          DBInfo.COL_MASTER_CARD_CODE + ", " +
          DBInfo.COL_MASTER_CARD_CARD + 
          ") "+
          "VALUES (?,?);";   
    stat = conn.prepareStatement(SQL);
    stat.setString(1, bn.getCode());
    stat.setString(2, bn.getCard());
     System.out.println("INSERT CARD : " + stat.toString());
    result =  stat.executeUpdate();
    
  return result;     
 }
 
 /**
  * update data Master Card
  * @param bn
  * @return
  * @throws SQLException 
  */
 public int update(MasterCardBean bn) throws SQLException
 {  
    SQL = "UPDATE " + DBInfo.TABLE_MASTER_CARD + " " +
          "SET " +
          DBInfo.COL_MASTER_CARD_CARD + "=?" +
          "WHERE " + 
          DBInfo.COL_MASTER_CARD_CODE + "=?; ";
    
    stat = conn.prepareStatement(SQL);
    stat.setString(1, bn.getCard());
    stat.setString(2, bn.getCode());
    System.out.println("QUERY UPDATE: " + stat.toString());
    result = stat.executeUpdate();
    
    return result;  
 }
 
 /**
  * delete multiple data from Master Card 
  * @param ops
  * @return
  * @throws SQLException 
  */
  public int delete(String[] ops) throws SQLException
  {
    SQL = "DELETE FROM " + DBInfo.TABLE_MASTER_CARD + " WHERE " +
          DBInfo.COL_MASTER_CARD_CODE + "=?;";
    stat = conn.prepareStatement(SQL);

    for(int i=0; i<ops.length; i++)
    {
      stat.clearParameters();
      stat.setString(1, ops[i]);
      result = stat.executeUpdate();
    }

    return result;  
  }
  
  /**
   * delete singgle data from Master Card 
   * @param ops
   * @return
   * @throws SQLException 
   */
  public int delete(String ops) throws SQLException
  {
    SQL = "DELETE FROM " + DBInfo.TABLE_MASTER_CARD + " WHERE " +
          DBInfo.COL_MASTER_CARD_CODE + "=?;";
    stat = conn.prepareStatement(SQL);
    stat.clearParameters();
    stat.setString(1, ops);
    result = stat.executeUpdate();

    return result;
  }
}
