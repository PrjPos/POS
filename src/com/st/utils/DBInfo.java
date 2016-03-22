/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.st.utils;

/**
 *
 * @author Timothy_Fab
 */
public class DBInfo {
    
    //Master Item
    public static final String TABLE_MASTER_ITEM = "Master_Item";
    public static final String COL_MASTER_ITEM_ID = TABLE_MASTER_ITEM + ".Id";
    public static final String COL_MASTER_ITEM_NAME = TABLE_MASTER_ITEM + ".Name ";
    public static final String COL_MASTER_ITEM_TYPE = TABLE_MASTER_ITEM + ".Type";
    public static final String COL_MASTER_ITEM_SALES_PRICE = TABLE_MASTER_ITEM + ".Sales_Price";
    public static final String COL_MASTER_ITEM_PURCHASE_PRICE = TABLE_MASTER_ITEM + ".Purchase_Price";
    public static final String COL_MASTER_ITEM_ENTRY_DATE = TABLE_MASTER_ITEM + ".Entry_Date";
    public static final String COL_MASTER_ITEM_ENTRY_USER = TABLE_MASTER_ITEM + ".Entry_User";
    
    //Master Item Type 
    public static final String TABLE_MASTER_ITEM_TYPE = "Master_Item_Type";
    public static final String COL_MASTER_ITEM_TYPE_ID = TABLE_MASTER_ITEM_TYPE + ".Id";
    public static final String COL_MASTER_ITEM_TYPE_NAME = TABLE_MASTER_ITEM_TYPE + ".Name";
    public static final String COL_MASTER_ITEM_TYPE_NOTE = TABLE_MASTER_ITEM_TYPE + ".Note";   
    
    //Master Supplier
    public static final String TABLE_MASTER_SUPPLIER = "Master_Supplier";
    public static final String COL_MASTER_SUPPLIER_ID = TABLE_MASTER_SUPPLIER + ".Id";
    public static final String COL_MASTER_SUPPLIER_NAME = TABLE_MASTER_SUPPLIER + ".Name";
    public static final String COL_MASTER_SUPPLIER_ADDRESS = TABLE_MASTER_SUPPLIER + ".Address";
    public static final String COL_MASTER_SUPPLIER_PHONE_NUMBER = TABLE_MASTER_SUPPLIER + ".Phone_Number";
    public static final String COL_MASTER_SUPPLIER_ENTRY_DATE = TABLE_MASTER_SUPPLIER + ".Entry_Date";
    public static final String COL_MASTER_SUPPLIER_ENTRY_USER = TABLE_MASTER_SUPPLIER + ".Entry_User";
    
    //Master User
    public static final String TABLE_MASTER_USER = "Master_User";
    public static final String COL_MASTER_USER_LOGIN = TABLE_MASTER_USER + ".User_Login";
    public static final String COL_MASTER_USER_PASSWORD = TABLE_MASTER_USER + ".Password";
    public static final String COL_MASTER_USER_NAME = TABLE_MASTER_USER + ".Name";
    public static final String COL_MASTER_USER_MASTER_ACCESS = TABLE_MASTER_USER + ".Master_Access";
    public static final String COL_MASTER_USER_RECORD_ACCESS = TABLE_MASTER_USER + ".Record_Access";
    public static final String COL_MASTER_USER_REPORT_ACCESS = TABLE_MASTER_USER + ".Report_Access";
    
    //Master Card
    public static final String TABLE_MASTER_CARD = "Master_Card";
    public static final String COL_MASTER_CARD_CODE = TABLE_MASTER_CARD  + ".Code";
    public static final String COL_MASTER_CARD_CARD = TABLE_MASTER_CARD  + ".Card";
 
    //Master Customer
    public static final String TABLE_MASTER_CUSTOMER = "Master_Customer";
    public static final String COL_MASTER_CUSTOMER_ID = TABLE_MASTER_CUSTOMER  + ".Id";
    public static final String COL_MASTER_CUSTOMER_NAME = TABLE_MASTER_CUSTOMER  + ".Name";
    public static final String COL_MASTER_CUSTOMER_ADDRESS = TABLE_MASTER_CUSTOMER  + ".Address";
    public static final String COL_MASTER_CUSTOMER_PHONE_NUMBER = TABLE_MASTER_CUSTOMER  + ".Phone_Number";
    
    // Purchasi Record
    public static final String TABLE_PURCHASING = "Purchasing";
    public static final String COL_TABLE_PURCHASING_FAKTUR_ID = TABLE_PURCHASING  + ".Faktur_Id";
    public static final String COL_TABLE_PURCHASING_SUPPLIER_ID = TABLE_PURCHASING  + ".Supplier_Id";
    public static final String COL_TABLE_PURCHASING_DATE = TABLE_PURCHASING  + ".Date";
    
    // Purchasi Details Record
    public static final String TABLE_PURCHASING_DETAILS = "Purchasing_Details";
    public static final String COL_TABLE_PURCHASING_DETAILS_ITEM_CODE = TABLE_PURCHASING_DETAILS  + ".Item_Code";
}
