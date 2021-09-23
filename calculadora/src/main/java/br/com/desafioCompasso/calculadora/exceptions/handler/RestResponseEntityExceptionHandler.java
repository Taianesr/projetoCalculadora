package br.com.desafioCompasso.calculadora.exceptions.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.desafioCompasso.calculadora.exceptions.NotFoundException;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundIdException;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundNameException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value 
      = { ServiceException.class })
    protected ResponseEntity<Object> handleConflict(
      ServiceException ex) {
        String bodyOfResponse = "" + ex.getLocalizedMessage();
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.FAILED_DEPENDENCY, null);
    }
    
    
    @ExceptionHandler(value 
    		= NotFoundIdException.class)
    protected ResponseEntity<Object> handlerNorFount(
    		NotFoundIdException ex) {
    	String bodyOfResponse = "" + ex.getLocalizedMessage();
    	return handleExceptionInternal(ex, ex.getLocalizedMessage(), 
    			new HttpHeaders(), HttpStatus.NOT_FOUND, null);
    }
    

    @ExceptionHandler(value 
      = {NotFoundNameException.class })
    protected ResponseEntity<Object> handleConflict(
    		NotFoundNameException ex) {
        String bodyOfResponse = "" + ex.getLocalizedMessage();
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.FAILED_DEPENDENCY, null);
    }
    
    
}