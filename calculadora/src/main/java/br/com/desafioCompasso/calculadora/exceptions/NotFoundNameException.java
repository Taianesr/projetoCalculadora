package br.com.desafioCompasso.calculadora.exceptions;

public class NotFoundNameException extends RuntimeException{

	private static final long serialVersionUID = 1L;


	public NotFoundNameException(String mensagem) {
		super(mensagem);
	}

	
}
