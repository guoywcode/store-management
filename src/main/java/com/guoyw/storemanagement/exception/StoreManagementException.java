package com.guoyw.storemanagement.exception;

/**
 * @author: guoyw
 * created: 2019-12-24 17:36
 */
public class StoreManagementException extends RuntimeException{
  
  private String[] params;
  
  public StoreManagementException(String codeName) {
    super(codeName);
    this.params = new String[]{};
  }
  
  public StoreManagementException(String codeName, String[] params) {
    super(codeName);
    this.params = params;
  }
  
  public StoreManagementException(String codeName, String[] params, Throwable cause) {
    super(codeName, cause);
    this.params = params;
  }
  
  public String[] getParams() {
    return params;
  }
}
