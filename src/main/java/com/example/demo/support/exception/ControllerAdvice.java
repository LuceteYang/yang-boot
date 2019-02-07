package com.example.demo.support.exception;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


import lombok.extern.slf4j.Slf4j;



/**
 * Exception handler advice class for all SpringMVC controllers.
 * @author norrisshelton
 * @see org.springframework.web.bind.annotation.ControllerAdvice
 */
@Slf4j
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    /**
     * Handles ResourceExceptions for the SpringMVC controllers.
     * @param e SpringMVC controller exception.
     * @return http response entity
     * @see ExceptionHandler
     */
	@Value("${custom.value}")
	String value;
    @ExceptionHandler(ResourceException.class)
	public ResponseEntity handleException(ResourceException e) {
    	log.error("staus :"+e.getHttpStatus()+" message : "+e.getMessage());
    	String message = "";
    	if(!value.equals("prod")) {
    		message=e.getMessage();
    	}
        return ResponseEntity.status(e.getHttpStatus()).body(message);
    }
    
}