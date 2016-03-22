/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.st.beans;

/**
 *
 * @author SANFON
 */
public class LoginBeans 
{
  /** Object Column. */
  private String UserLogin = null;
  private String Password = null; //This format in sha
  private String UserName = null;
  
  /** Default Constructor. */
  public LoginBeans() {}
  
  /** Set UserLogin*/
  public void setUserLogin(String val) { UserLogin = val; }
  /** Get UserLogin*/
  public String getUserLogin() { return UserLogin; }
  
  /** Set Password*/
  public void setpassword(String val) { Password = val; }
  /** Get Password*/
  
  /** Set UserName*/
  /** Get UserName*/
  
}
