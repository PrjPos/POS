/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.db;

import com.st.beans.MasterItemTypeBean;
import com.st.beans.MasterSupplierBean;
import com.st.utils.DBInfo;
import gdi.gds.appserver.db.SvrDB;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Timothy_Fab
 */
public class MasterSupplierDB extends SvrDB
{
   /** Default Constructor with DB Connection. */
  public MasterSupplierDB(Connection cnctn) {
   super(cnctn);
  }  

    public MasterSupplierDB() {
        super(null);
    }
  
  /**
   * Get Supplier Info.
   * @param ID
   * @return
   * @throws SQLException 
   */
   public MasterSupplierBean get(String ID)
   throws SQLException        
   {
     /* Container Object. */  
     MasterSupplierBean bean = null;
     SQL = " WHERE " + DBInfo.COL_MASTER_SUPPLIER_ID + " = '" + ID + "'; ";
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
  public MasterSupplierBean[] list(int begin, int howMany, String addSQL)
  throws SQLException
  {
    MasterSupplierBean[] beans=null;
    String limit = super.formLimit(begin, howMany);  
    
    //Check Add SQL
    if(null==addSQL) addSQL = "";
    
    //Search Data
    search(DBInfo.TABLE_MASTER_SUPPLIER, addSQL + limit);
    beans = new MasterSupplierBean[super.getFoundNumberOfRecords()];
    
        //Iterate
    for (int i = 0; i < beans.length; i++) 
    {
      MasterSupplierBean bean = this.next();
      if(null!=bean)
      { beans[i] = bean; }
      else
      { break; }
    }
    
    return beans;
  }
   
   public MasterSupplierBean next()
   throws SQLException  
   {
     MasterSupplierBean bn = null;
     
     if(null!=rs && rs.next())
     {
       bn = new MasterSupplierBean();
       bn.setID(rs.getString(DBInfo.COL_MASTER_SUPPLIER_ID));
       bn.setName(rs.getString(DBInfo.COL_MASTER_SUPPLIER_NAME));
       bn.setAddress(rs.getString(DBInfo.COL_MASTER_SUPPLIER_ADDRESS));
       bn.setPhoneNumber(rs.getString(DBInfo.COL_MASTER_SUPPLIER_PHONE_NUMBER));
       bn.setEntryDate(rs.getString(DBInfo.COL_MASTER_SUPPLIER_ENTRY_DATE));
       bn.setEntryUser(rs.getString(DBInfo.COL_MASTER_SUPPLIER_ENTRY_USER));
     }
     
     return bn;
   } 
   
   /**
   * Create Master Supplier
   * @param bn
   * @return
   * @throws SQLException 
   */
  public int insert(MasterSupplierBean bn) throws SQLException
  {
     SQL = "INSERT INTO " + DBInfo.TABLE_MASTER_SUPPLIER +
     "(" +
     DBInfo.COL_MASTER_SUPPLIER_ID+ ", " +
     DBInfo.COL_MASTER_SUPPLIER_NAME + ", " +
     DBInfo.COL_MASTER_SUPPLIER_ADDRESS +", " + 
     DBInfo.COL_MASTER_SUPPLIER_PHONE_NUMBER +", " +  
     DBInfo.COL_MASTER_SUPPLIER_ENTRY_DATE +", " +       
     DBInfo.COL_MASTER_SUPPLIER_ENTRY_USER +          
     ") "+
     "VALUES (?,?,?,?,?,?);";
     
     stat = conn.prepareStatement(SQL);
     stat.setString(1, bn.getID());
     stat.setString(2, bn.getName());
     stat.setString(3, bn.getAddress());
     stat.setString(4, bn.getPhoneNumber());
     stat.setString(5, bn.getEntryDate());
     stat.setString(6, bn.getEntryUser());
     
     result = stat.executeUpdate();
     return result;
  }
   
  /** Update Master Supplier. */
  public int update(MasterSupplierBean bn) throws SQLException
  {
    SQL = "UPDATE " + DBInfo.TABLE_MASTER_SUPPLIER + " " +
          "SET " +
          DBInfo.COL_MASTER_SUPPLIER_NAME + "=?, " +
          DBInfo.COL_MASTER_SUPPLIER_ADDRESS + "=?, " +
          DBInfo.COL_MASTER_SUPPLIER_PHONE_NUMBER + "=?, " +
          DBInfo.COL_MASTER_SUPPLIER_ENTRY_DATE + "=?, " +
          DBInfo.COL_MASTER_SUPPLIER_ENTRY_USER + "=?" +
          " WHERE " + 
          DBInfo.COL_MASTER_SUPPLIER_ID + "=?; ";  
    
          stat = conn.prepareStatement(SQL);
          stat.setString(1, bn.getName());
          stat.setString(2, bn.getAddress());
          stat.setString(3, bn.getPhoneNumber());
          stat.setString(4, bn.getEntryDate());
          stat.setString(5, bn.getEntryUser());
          stat.setString(6, bn.getID());
         // System.out.println("QUERY UPDATE: " + stat.toString());
          result = stat.executeUpdate();
   return result;        
  }
  
  /** Delete more data Master Supplier  */
  public int delete(String[] ops) throws SQLException
  {
    SQL = "DELETE FROM " +
           DBInfo.TABLE_MASTER_SUPPLIER +
           " WHERE " +
           DBInfo.COL_MASTER_SUPPLIER_ID + "=?;";
    
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
    SQL = "DELETE FROM " + DBInfo.TABLE_MASTER_SUPPLIER + " WHERE " +
          DBInfo.COL_MASTER_SUPPLIER_ID + "=?;";
    stat = conn.prepareStatement(SQL);
    stat.clearParameters();
    stat.setString(1, ops);
    result = stat.executeUpdate();
    
    return result;
  }
}
