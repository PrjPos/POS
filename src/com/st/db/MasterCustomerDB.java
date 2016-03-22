/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.db;

import com.st.beans.MasterCustomerBean;
import com.st.utils.DBInfo;
import gdi.gds.appserver.db.SvrDB;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Timothy_Fab
 */
public class MasterCustomerDB extends SvrDB
{
  /** Default Constructor with DB Connection. */
  public MasterCustomerDB(Connection cnctn)
  {super(cnctn);}      

  /**
   * get Customer Info
   * @param ID
   * @return
   * @throws SQLException 
   */
  public MasterCustomerBean get(String ID)
  throws SQLException        
  {
    /* Container Object. */   
    MasterCustomerBean bean;
    SQL = " WHERE " + DBInfo.COL_MASTER_CUSTOMER_ID + "='"+ID+"';";
    
    /* Search Table. */
    search(DBInfo.TABLE_MASTER_CUSTOMER, SQL);    
    bean = this.next();
    
    return bean;
  }   
  
  public  MasterCustomerBean next()
  throws SQLException
  {
    MasterCustomerBean bean = null;
    
    if(null!=rs && rs.next())
    {
      bean = new MasterCustomerBean();
      bean.setId(rs.getString(DBInfo.COL_MASTER_CUSTOMER_ID));
      bean.setName(rs.getString(DBInfo.COL_MASTER_CUSTOMER_NAME));
      bean.setAddress(rs.getString(DBInfo.COL_MASTER_CUSTOMER_ADDRESS));
      bean.setPhoneNumber(rs.getString(DBInfo.COL_MASTER_CUSTOMER_PHONE_NUMBER));
    } 
    
   return bean;
  }
  
  /**
   * Get Customer all list
   * @param begin
   * @param howMany
   * @param addSQL
   * @return
   * @throws SQLException 
   */
  public MasterCustomerBean[]list(int begin, int howMany, String addSQL)
  throws SQLException
  {
    MasterCustomerBean []beans; 
    String limit = super.formLimit(begin, howMany);
    
    //Check Add SQL
    if(null==addSQL) addSQL = "";
    
    //search data
    search(DBInfo.TABLE_MASTER_CUSTOMER, addSQL + limit);
    beans = new MasterCustomerBean[super.getFoundNumberOfRecords()];
    
    //Iterate
    for (int i = 0; i < beans.length; i++) 
    {
      MasterCustomerBean bean = this.next();
      // System.out.println("hasil bean db____dfdf "+ bean.getId());
      if(null!=bean)
      { beans[i] = bean; }
      else
      { break; }
    }
    
      System.out.println("list db__");
    return beans;
  }  
  
 /**
  * Create Data Master Customer
  * @param bn
  * @return
  * @throws SQLException 
  */ 
 public int insert(MasterCustomerBean bn)
 throws SQLException
 {
  SQL = "INSERT INTO " + DBInfo.TABLE_MASTER_CUSTOMER +
          "(" +
          DBInfo.COL_MASTER_CUSTOMER_ID + ", " +
          DBInfo.COL_MASTER_CUSTOMER_NAME + ", " +
          DBInfo.COL_MASTER_CUSTOMER_ADDRESS + ", " +
          DBInfo.COL_MASTER_CUSTOMER_PHONE_NUMBER + 
          ") "+
          "VALUES (?,?,?,?);";   
    stat = conn.prepareStatement(SQL);
    stat.setString(1, bn.getId());
    stat.setString(2, bn.getName());
    stat.setString(3, bn.getAddress());
    stat.setString(4, bn.getPhoneNumber());
    result =  stat.executeUpdate();
    
  return result;   
 }
 
  /** 
   * Update Data Master Customer
   * @param bn
   * @return
   * @throws SQLException 
   */
  public int update(MasterCustomerBean bn) throws SQLException
  {
    SQL = "UPDATE " + DBInfo.TABLE_MASTER_CUSTOMER + " " +
          "SET " +
          DBInfo.COL_MASTER_CUSTOMER_NAME + "=?, " +
          DBInfo.COL_MASTER_CUSTOMER_ADDRESS + "=?, " +
          DBInfo.COL_MASTER_CUSTOMER_PHONE_NUMBER + "=? " +
          "WHERE " + 
          DBInfo.COL_MASTER_CUSTOMER_ID + "=?; ";
    
    stat = conn.prepareStatement(SQL);
    stat.setString(1, bn.getName());
    stat.setString(2, bn.getAddress());
    stat.setString(3, bn.getPhoneNumber());
    stat.setString(4, bn.getId());
    System.out.println("QUERY UPDATE: " + stat.toString());
    result = stat.executeUpdate();
    
    return result;
  }
 
    /** 
     * Delete Multipe data  Master Customer 
     * @param ops
     * @return
     * @throws SQLException 
     */
  public int delete(String[] ops) throws SQLException
  {
    SQL = "DELETE FROM " + DBInfo.TABLE_MASTER_CUSTOMER + " WHERE " +
          DBInfo.COL_MASTER_CUSTOMER_ID + "=?;";
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
   * Delete singgle data  Master Customer 
   * @param ops
   * @return
   * @throws SQLException 
   */
  public int delete(String ops) throws SQLException
  {
    SQL = "DELETE FROM " + DBInfo.TABLE_MASTER_CUSTOMER + " WHERE " +
          DBInfo.COL_MASTER_CUSTOMER_ID + "=?;";
    stat = conn.prepareStatement(SQL);
    stat.clearParameters();
    stat.setString(1, ops);
    result = stat.executeUpdate();

    return result;
  }
  
}
