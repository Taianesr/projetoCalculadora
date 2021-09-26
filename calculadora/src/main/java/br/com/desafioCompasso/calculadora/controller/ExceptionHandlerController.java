package br.com.desafioCompasso.calculadora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.desafioCompasso.calculadora.controller.dto.DefaultErrorDto;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundIdException;
import br.com.desafioCompasso.calculadora.exceptions.NotFoundNameException;
import br.com.desafioCompasso.calculadora.exceptions.ServiceException;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(value = { NotFoundIdException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public DefaultErrorDto NotFoundIdException(NotFoundIdException ex, WebRequest request) {
		DefaultErrorDto message = new DefaultErrorDto();
		message.setErrorMessage(ex.getMessage());
		return message;
	}

	@ExceptionHandler(value = { NotFoundNameException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public DefaultErrorDto NotFoundNameException(NotFoundNameException ex, WebRequest request) {
		DefaultErrorDto message = new DefaultErrorDto();
		message.setErrorMessage(ex.getMessage());
		return message;
	}

	@ExceptionHandler(value = { ServiceException.class })
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public DefaultErrorDto ServiceException(ServiceException ex, WebRequest request) {
		DefaultErrorDto message = new DefaultErrorDto();
		message.setErrorMessage(ex.getMessage());
		return message;
	}

}
