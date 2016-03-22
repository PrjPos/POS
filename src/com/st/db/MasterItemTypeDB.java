/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.db;

import com.st.beans.MasterItemTypeBean;
import com.st.utils.DBInfo;
import gdi.gds.appserver.db.SvrDB;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author SANFON
 */
public class MasterItemTypeDB extends SvrDB
{
  /** Default Constructor with DB Connection. */
  public MasterItemTypeDB(Connection cnctn) {
    super(cnctn);
  }
  
  /**
   * Get Item Type Info.
   * @param ID
   * @return
   * @throws SQLException 
   */
  public MasterItemTypeBean get(String ID) 
  throws SQLException
  {
    /* Container Object. */
    MasterItemTypeBean bean;
    SQL = " WHERE " + DBInfo.COL_MASTER_ITEM_TYPE_ID + "= '"+ID+"'; ";
    /* Search Table. */
    search(DBInfo.TABLE_MASTER_ITEM_TYPE, SQL);
    bean = this.next();
    
    return bean;
  }
  
  /**
   * Get Item Type List.
   * @param begin
   * @param howMany
   * @param addSQL
   * @return
   * @throws SQLException 
   */
  public MasterItemTypeBean[] list(int begin, int howMany, String addSQL)
  throws SQLException
  {
    MasterItemTypeBean[] beans;
    String limit = super.formLimit(begin, howMany);
    
    //Check Add SQL
    if(null==addSQL) addSQL = "";
    
    //Search Data
    search(DBInfo.TABLE_MASTER_ITEM_TYPE, addSQL + limit);
    beans = new MasterItemTypeBean[super.getFoundNumberOfRecords()];
    
    //Iterate
    for (int i = 0; i < beans.length; i++) 
    {
      MasterItemTypeBean bean = this.next();
      if(null!=bean)
      { beans[i] = bean; }
      else
      { break; }
    }
    
    return beans;
  }
  
  /**
   * This method used to get next data from database.
   * @return
   * @throws SQLException 
   */
  public MasterItemTypeBean next() throws SQLException
  {
    MasterItemTypeBean bean = null;
    
    if(null!=rs & rs.next())
    {
      bean = new MasterItemTypeBean();
      bean.setID(rs.getString(DBInfo.COL_MASTER_ITEM_TYPE_ID));
      bean.setName(rs.getString(DBInfo.COL_MASTER_ITEM_TYPE_NAME));
      bean.setNote(rs.getString(DBInfo.COL_MASTER_ITEM_TYPE_NOTE));
    }
    
    return bean;
  }
  
  /**
   * Create Master Item Type.
   * @param bn
   * @return
   * @throws SQLException 
   */
  public int insert(MasterItemTypeBean bn) throws SQLException
  {
    SQL = "INSERT INTO " + DBInfo.TABLE_MASTER_ITEM_TYPE +
          "(" +
          DBInfo.COL_MASTER_ITEM_TYPE_ID + ", " +
          DBInfo.COL_MASTER_ITEM_TYPE_NAME + ", " +
          DBInfo.COL_MASTER_ITEM_TYPE_NOTE + 
          ") "+
          "VALUES (?,?,?);";
    
    stat = conn.prepareStatement(SQL);
    stat.setString(1, bn.getID());
    stat.setString(2, bn.getName());
    stat.setString(3, bn.getNote());
    result = stat.executeUpdate();
    
    return result;
  }
  
  /** Update Master Item Type. */
  public int update(MasterItemTypeBean bn) throws SQLException
  {
    SQL = "UPDATE " + DBInfo.TABLE_MASTER_ITEM_TYPE + " " +
          "SET " +
          DBInfo.COL_MASTER_ITEM_TYPE_NAME + "=?, " +
          DBInfo.COL_MASTER_ITEM_TYPE_NOTE + "=? " +
          "WHERE " + 
          DBInfo.COL_MASTER_ITEM_TYPE_ID + "=?; ";
    
    stat = conn.prepareStatement(SQL);
    stat.setString(1, bn.getName());
    stat.setString(2, bn.getNote());
    stat.setString(3, bn.getID());
    System.out.println("QUERY UPDATE: " + stat.toString());
    result = stat.executeUpdate();
    
    return result;
  }
  
  /** Delete Master Item Type. */
  public int delete(String[] ops) throws SQLException
  {
    SQL = "DELETE FROM " + DBInfo.TABLE_MASTER_ITEM_TYPE + " WHERE " +
          DBInfo.COL_MASTER_ITEM_TYPE_ID + "=?;";
    stat = conn.prepareStatement(SQL);

    for(int i=0; i<ops.length; i++)
    {
      stat.clearParameters();
      stat.setString(1, ops[i]);
      result = stat.executeUpdate();
    }

    return result;
  }
  
  /** Delete singgel data. */
  public int delete(String ops) throws SQLException
  {
    SQL = "DELETE FROM " + DBInfo.TABLE_MASTER_ITEM_TYPE + " WHERE " +
          DBInfo.COL_MASTER_ITEM_TYPE_ID + "=?;";
    stat = conn.prepareStatement(SQL);
    stat.clearParameters();
    stat.setString(1, ops);
    result = stat.executeUpdate();

    return result;
  }
}
