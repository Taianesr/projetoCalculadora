package br.com.desafioCompasso.calculadora.exceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String mensagem) {
		super(mensagem);
	}

}
