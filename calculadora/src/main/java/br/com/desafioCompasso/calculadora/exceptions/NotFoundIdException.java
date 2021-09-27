package br.com.desafioCompasso.calculadora.exceptions;

public class NotFoundIdException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundIdException(String mensagem) {
		super(mensagem);
	}

}
