/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.db;

import com.st.beans.MasterItemBean;
import com.st.utils.Constants;
import com.st.utils.DBInfo;
import com.st.utils.Utilities;
import gdi.gds.appserver.db.SvrDB;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author SANFON
 */
public class MasterItemDB extends SvrDB 
{
  /** Default Constructor with Connection. */
  public MasterItemDB(Connection cnctn) {
    super(cnctn);
  }
  
  /**
   * Get Item Type Info.
   * @param ID
   * @return
   * @throws SQLException 
   */
  public MasterItemBean get(String ID) 
  throws SQLException
  {
    /* Container Object. */
    MasterItemBean bean;
    SQL = " WHERE " + DBInfo.COL_MASTER_ITEM_ID + "= '"+ID+"'; ";
    /* Search Table. */
    search(DBInfo.TABLE_MASTER_ITEM, SQL);
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
  public MasterItemBean[] list(int begin, int howMany, String addSQL)
  throws SQLException
  {
    MasterItemBean[] beans;
    String limit = super.formLimit(begin, howMany);
    
    //Check Add SQL
    if(null==addSQL) addSQL = "";
    
    //Search Data
    search(DBInfo.TABLE_MASTER_ITEM, addSQL + limit);
    beans = new MasterItemBean[super.getFoundNumberOfRecords()];
    
    //Iterate
    for (int i = 0; i < beans.length; i++) 
    {
      MasterItemBean bean = this.next();
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
  public MasterItemBean next() throws SQLException
  {
    MasterItemBean bean = null;
    
    if(null!=rs & rs.next())
    {
      bean = new MasterItemBean();
      bean.setId(rs.getString(DBInfo.COL_MASTER_ITEM_ID));
      bean.setName(rs.getString(DBInfo.COL_MASTER_ITEM_NAME));
      bean.setItemType(rs.getString(DBInfo.COL_MASTER_ITEM_TYPE));
      bean.setSalesPrice(rs.getDouble(DBInfo.COL_MASTER_ITEM_SALES_PRICE));
      bean.setPurchasePrice(rs.getDouble(DBInfo.COL_MASTER_ITEM_PURCHASE_PRICE));
      bean.setEntryDate(Utilities.string2Date(rs.getString(DBInfo.COL_MASTER_ITEM_ENTRY_DATE), Constants.MYSQL_MEDIUM_DATE_TIME_PATTERN));
      bean.setEntryUser(rs.getString(DBInfo.COL_MASTER_ITEM_ENTRY_USER));
    }
    
    return bean;
  }
  
  /**
   * Create Master Item Type.
   * @param bn
   * @return
   * @throws SQLException 
   */
  public int insert(MasterItemBean bn) throws SQLException
  {
    SQL = "INSERT INTO " + DBInfo.TABLE_MASTER_ITEM +
          "(" +
          DBInfo.COL_MASTER_ITEM_ID + ", " +
          DBInfo.COL_MASTER_ITEM_NAME + ", " +
          DBInfo.COL_MASTER_ITEM_TYPE + ", " +
          DBInfo.COL_MASTER_ITEM_SALES_PRICE + ", " +
          DBInfo.COL_MASTER_ITEM_PURCHASE_PRICE + ", " +
          DBInfo.COL_MASTER_ITEM_ENTRY_DATE + ", " +
          DBInfo.COL_MASTER_ITEM_ENTRY_USER +
          ") "+
          "VALUES (?,?,?,?,?,?,?);";
    
    stat = conn.prepareStatement(SQL);
    stat.setString(1, bn.getId());
    stat.setString(2, bn.getName());
    stat.setString(3, bn.getItemType());
    stat.setDouble(4, bn.getSalesPrice());
    stat.setDouble(5, bn.getPurchasePrice());
    stat.setString(6, Utilities.date2String( bn.getEntryDate(), Constants.MYSQL_MEDIUM_DATE_TIME_PATTERN));
    stat.setString(7, bn.getEntryUser());
    System.out.println("QUERY INSERT: " + stat.toString());
    result = stat.executeUpdate();
    
    return result;
  }
  
  /** Update Master Item Type. */
  public int update(MasterItemBean bn) throws SQLException
  {
    SQL = "UPDATE " + DBInfo.TABLE_MASTER_ITEM + " " +
          "SET " +
          DBInfo.COL_MASTER_ITEM_NAME + "=?, " +
          DBInfo.COL_MASTER_ITEM_TYPE + "=?, " +
          DBInfo.COL_MASTER_ITEM_SALES_PRICE + "=?, " +
          DBInfo.COL_MASTER_ITEM_PURCHASE_PRICE + "=?, " +
          DBInfo.COL_MASTER_ITEM_ENTRY_DATE + "=?, " +
          DBInfo.COL_MASTER_ITEM_ENTRY_USER + "=? " +
          "WHERE " + 
          DBInfo.COL_MASTER_ITEM_ID + "=?; ";
    
    stat = conn.prepareStatement(SQL);
    stat.setString(1, bn.getName());
    stat.setString(2, bn.getItemType());
    stat.setDouble(3, bn.getSalesPrice());
    stat.setDouble(4, bn.getPurchasePrice());
    stat.setString(5, Utilities.date2String( bn.getEntryDate(), Constants.MYSQL_MEDIUM_DATE_TIME_PATTERN));
    stat.setString(6, bn.getEntryUser());
    stat.setString(7, bn.getId());
    System.out.println("QUERY UPDATE: " + stat.toString());
    result = stat.executeUpdate();
    
    return result;
  }
  
  /** Delete Master Item Type. */
  public int delete(String[] ops) throws SQLException
  {
    SQL = "DELETE FROM " + DBInfo.TABLE_MASTER_ITEM + " WHERE " +
          DBInfo.COL_MASTER_ITEM_ID + "=?;";
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
    SQL = "DELETE FROM " + DBInfo.TABLE_MASTER_ITEM + " WHERE " +
          DBInfo.COL_MASTER_ITEM_ID + "=?;";
    stat = conn.prepareStatement(SQL);
    stat.clearParameters();
    stat.setString(1, ops);
    result = stat.executeUpdate();

    return result;
  }
}
