/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.utils;

import gdi.gds.log.LogAgent;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SANFON
 */
public class Utilities 
{
  /** Private log agent. */
  private static LogAgent la = LogAgent.getInstance(Constants.APP_ID);
  
  /** Variable to turn the debug on and off. */
  public static boolean debugOn = false;
  
  /** Checks for null or empty strings. */
  public static final boolean isEmpty(String val)
  {
    if(val==null || val.trim().length()<=0) return true;
    return false;
  }
  
  /**
   * For formatting date.
   */
  public static final String date2String(Date date, String pattern)
  {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);    
    
    try
    {
      return sdf.format(date); 
    }
    catch(Exception e)
    {
      if(debugOn)
      {
	      la.info(
	          "gdi.gds.itworks.re.cashier.utils.Utilities",
	          "Unable to format a date to a string: " + date);
      }
      return null;
    }
  }

  /**
   * For formatting string to date.
   */
  public static final Date string2Date(String date, String pattern)
  {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    try
    { return sdf.parse(date); }
    catch(Exception e)
    {
      if(debugOn)
      {
	      la.info(
	          "gdi.gds.ibs.main.utils.RootUtilities",
	          "Unable to parse a string to a date: " + date);
      }
      return null;
    }
  }
  
  /**
   * For parsing any String into a number of double type.
   * This function made for handle unpredictable numbers because of too
   * specific numbers from a math calculation.
   * @see RootUtilities.number2String()
   */
  public static double parseDouble(double value, int decLength)
  {
    return Math.round(value*Math.pow(10.0,decLength))/Math.pow(10.0,decLength);
  }
}
