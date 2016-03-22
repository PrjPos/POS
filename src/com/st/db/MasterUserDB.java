/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.db;

import com.st.beans.MasterUserBean;
import com.st.utils.DBInfo;
import gdi.gds.appserver.db.SvrDB;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Timothy_Fab
 */
public class MasterUserDB extends  SvrDB
{
   /** Default Constructor with DB Connection. */
    public MasterUserDB(Connection cnctn)
    {
      super(cnctn);  
    }        
    
    /**
     * get single data 
     * @param userLogin
     * @return
     * @throws Exception 
     */
    public MasterUserBean get (String name)
    throws Exception
    {
      /* Container Object. */  
      MasterUserBean bean = null;  
      SQL = " WHERE " + DBInfo.COL_MASTER_USER_NAME  + "='"+name+"'; ";
      
      /* Search Table. */
      search(DBInfo.TABLE_MASTER_USER, SQL);
      bean = this.next();
      
     return bean;
    }
    
    public MasterUserBean validate(String userName, String userPass) 
    throws Exception
    {
      MasterUserBean bean = null;
      
      SQL = " WHERE " + DBInfo.COL_MASTER_USER_LOGIN + 
              "='"+userName+"' AND " + 
              DBInfo.COL_MASTER_USER_PASSWORD +
              "=" + super.formEncryptionSyntax("'" + userPass + "'");
      search(DBInfo.TABLE_MASTER_USER, SQL);
      bean = this.next();
      
      return bean;
    }
    
    /**
     * get all list data Master User
     * @param begin
     * @param howMany
     * @param addSQL
     * @return
     * @throws SQLException 
     */
    public MasterUserBean[]list(int begin, int howMany, String addSQL)
    throws SQLException        
    {
     MasterUserBean[] beans = null;
     String limit = super.formLimit(begin, howMany);   
     
     //Check Add SQL
     if(null==addSQL) addSQL = "";
     
         //Search Data
      search(DBInfo.TABLE_MASTER_USER, addSQL + limit);
      beans = new MasterUserBean[super.getFoundNumberOfRecords()];
     
      //iterate
      for (int i = 0; i < beans.length; i++) 
      {
         MasterUserBean bean = this.next();
         if(null!=bean)
         { beans[i] = bean; }
         else
         { break; }       
      }    
     return beans;
    }
    
    /**
     * next for get data from database
     * @return
     * @throws SQLException 
     */
    public MasterUserBean next()
    throws SQLException
    {
      MasterUserBean bean = null;
              
      if(null!=rs && rs.next()) 
      {
        bean = new MasterUserBean();
        bean.setUserLogin(rs.getString(DBInfo.COL_MASTER_USER_LOGIN));
        bean.setPassowrd(rs.getString(DBInfo.COL_MASTER_USER_PASSWORD));
        bean.setName(rs.getString(DBInfo.COL_MASTER_USER_NAME));
        bean.setMasterAccess(rs.getString(DBInfo.COL_MASTER_USER_MASTER_ACCESS));
        bean.setRecordAccess(rs.getString(DBInfo.COL_MASTER_USER_RECORD_ACCESS));
        bean.setReportAccess(rs.getString(DBInfo.COL_MASTER_USER_REPORT_ACCESS));     
      }       
      return bean;
    } 
    
    /**
     * Create Master User
     * @param bn
     * @return
     * @throws SQLException 
     */
    public int insert(MasterUserBean bn)
    throws SQLException
    {
      SQL = "INSERT INTO " + DBInfo.TABLE_MASTER_USER +
          "(" +
          DBInfo.COL_MASTER_USER_LOGIN + ", " +
          DBInfo.COL_MASTER_USER_PASSWORD + ", " +
          DBInfo.COL_MASTER_USER_NAME + ", " +
          DBInfo.COL_MASTER_USER_MASTER_ACCESS + ", " +
          DBInfo.COL_MASTER_USER_RECORD_ACCESS + ", " +
          DBInfo.COL_MASTER_USER_REPORT_ACCESS + 
          ") "+
          "VALUES (?," + super.formEncryptionSyntax("?") + ",?,?,?,?);";      
      
      stat = conn.prepareStatement(SQL);      
      stat.setString(1, bn.getUserLogin());
      stat.setString(2, bn.getPassowrd());
      stat.setString(3, bn.getName());
      stat.setString(4, bn.getMasterAccess());
      stat.setString(5, bn.getRecordAccess());
      stat.setString(6, bn.getReportAccess());   
      System.out.println("QUERY INSERT_timo : " + stat.toString());
      result = stat.executeUpdate();
          
      return result;
    }
    
    /**
     * Update data master user where name
     * @param bn
     * @return
     * @throws SQLException 
     */
    public int update(MasterUserBean bn)
    throws SQLException
    {
      SQL = "UPDATE " + DBInfo.TABLE_MASTER_USER + " " +
            "SET " +
            DBInfo.COL_MASTER_USER_NAME + "=?, " +
            DBInfo.COL_MASTER_USER_PASSWORD + "=" + 
            super.formEncryptionSyntax("?") + "," +
            DBInfo.COL_MASTER_USER_MASTER_ACCESS + "=?, " +
            DBInfo.COL_MASTER_USER_RECORD_ACCESS + "=?, " +
            DBInfo.COL_MASTER_USER_REPORT_ACCESS + "=? " +
            "WHERE " + 
            DBInfo.COL_MASTER_USER_LOGIN + "=?; ";   
      
      stat = conn.prepareStatement(SQL);
      stat.setString(1, bn.getUserLogin());
      stat.setString(2, bn.getPassowrd());
      stat.setString(3, bn.getMasterAccess());
      stat.setString(4, bn.getRecordAccess());
      stat.setString(5, bn.getReportAccess());
      stat.setString(6, bn.getName());
     
      result = stat.executeUpdate();
     return result;   
    }  
    
    /**
     * delete Master User multiple data
     * @param ops
     * @return
     * @throws SQLException 
     */
    public int delete(String[] ops) 
    throws SQLException
    {
      SQL = "DELETE FROM " + DBInfo.TABLE_MASTER_USER + " WHERE " +
            DBInfo.COL_MASTER_USER_NAME + "=?;";
      
           stat = conn.prepareStatement(SQL);  
           
           for (int i = 0; i < ops.length; i++)
           {
            stat.clearParameters();
            stat.setString(1, ops[i]);
            result = stat.executeUpdate();
           }
           
     return result;      
    }  
    
    /**
     * delete  master singgle data
     * @param ops
     * @return
     * @throws SQLException 
     */
    public int delete(String ops)
    throws SQLException
    {
      SQL = "DELETE FROM " + DBInfo.TABLE_MASTER_USER + " WHERE " +
            DBInfo.COL_MASTER_USER_NAME + "=?;";  
      
      stat = conn.prepareStatement(SQL);
      stat.clearParameters();
      stat.setString(1, ops);
      result = stat.executeUpdate();
      
      return result;
    }                        
}
