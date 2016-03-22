/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.utils;

/**
 *
 * @author SANFON
 */
public class Constants 
{
  /** Application ID. */
  public static final String APPID_PARAM = "CASHIERPHONE";
  public static final String APP_ID = "CASHIERPHONE";
  
  /** Config File Path. */
  public static String CONFIGFILEPATH = "";
  
  /** Config file constants for confidential info. */
  public static final String CONF_SETTINGS = "CONF_SETTINGS";
  
  /** Constants for LogManager. */
  public static final String LOG_INIT_STATUS = "LOG_INIT_STATUS";
  public static final String LOG_MIN_PRINT_LEVEL = "LOG_MIN_PRINT_LEVEL";
  public static final String LOG_FILE_PATH = "LOG_FILE_PATH";
  public static final String LOG_FILE_PREFIX = "LOG_FILE_PREFIX";
  public static final String LOG_FILE_SUFFIX = "LOG_FILE_SUFFIX";
  public static final String LOG_FILE_PATTERN = "LOG_FILE_PATTERN";
  public static final String LOG_BUFFER_SIZE = "LOG_BUFFER_SIZE";
  public static final String LOG_FILE_MAX_SIZE = "LOG_FILE_MAX_SIZE";
  public static final String LOG_FILE_COUNT = "LOG_FILE_COUNT";
  public static final String LOG_ROLL_TIME = "LOG_ROLL_TIME";
  
  public static final String CASHIERPRINTOUT_HEADER = "CASHIERPRINTOUT_HEADER";
  public static final String CASHIERPRINTOUT_FOOTER = "CASHIERPRINTOUT_FOOTER";
  
  /** Item info search category - by id. */
  public static String ITEMTYPE_SEARCHBY_ITEMID = "sritmid";
  /** Item info search category - by name. */
  public static String ITEMTYPE_SEARCHBY_ITEMNAME = "sritmnm";
  
  /** Supplier info search category - by id. */
  public static String SUPPLIER_SEARCHBY_SUPPID = "srsuppid";
  /** Supplier info search category - by name. */
  public static String SUPPLIER_SEARCHBY_SUPPNM = "srsuppnm";
  /** Supplier info search category - by phone number. */
  public static String SUPPLIER_SEARCHBY_PHONE_NUMBER = "srcphonenumb";
  
  /** User info search category - by user name. */
  public static String USER_SEARCHBY_USERNAME = "srcusrnm";
  /** User info search category - by user login. */
  public static String USER_SEARCHBY_USERLOGIN = "srcusrlgn";
  
  /** customer info search category - by customer id. */
  public static String CUSTOMER_SEARCHBY_ID = "srcid"; 
  /** customer info search category - by customer name. */
  public static String CUSTOMER_SEARCHBY_NAME = "srcnm"; 
  /** customer info search category - by customer id. */
  public static String CUSTOMER_SEARCHBY_PHONE_NUMBER = "srcphnno"; 
  
  /** card info search category - by card code. */
  public static String CARD_SEARCHBY_CODE = "srccd"; 
  
  /** Module COnstants. */
  public static final int MOD_LOGIN = 0;
  public static final int MOD_ITEM_TYPE = 2;
  public static final int MOD_ITEM = 3;
  public static final int MOD_SUPPLIER = 4;
  public static final int MOD_USER = 5;
  public static final int MOD_CUSTOMER = 6;
  public static final int MOD_CARD = 7;
  public static final int MOD_HOME = 1;
}
