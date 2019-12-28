package com.guoyw.storemanagement.exception.handler;
import com.guoyw.storemanagement.exception.StoreManagementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
/**
  * @author: guoyw
  * created: 2019-12-24 17:36
  */

@RestControllerAdvice
public class StoreManagementExceptionHandler{
  
  @Autowired(required = false)
  protected MessageSource messageSource;
  
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final String codeName;
  private final String msgName;
  
  public StoreManagementExceptionHandler(){
    this.codeName = "codeName";
    this.msgName = "msgName";
  }
  
  @ResponseBody
  @ExceptionHandler(StoreManagementException.class)
  public ResponseEntity<Object> storeManagementExceptionHandler(StoreManagementException exception) {
    Map<String, Object> result = new HashMap<>();
    logger.warn(exception.getClass().getName());
    logger.warn(exception.getMessage());
    
    String code = exception.getMessage();
    String msgKey = exception.getClass().getSimpleName() + "." + code;
    
    String msg;
    if (messageSource != null) {
      msg = messageSource.getMessage(msgKey, exception.getParams(), code, LocaleContextHolder.getLocale());
    } else {
      msg = code;
    }
    result.put(codeName, code);
    result.put(msgName, msg);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
  
  
}
