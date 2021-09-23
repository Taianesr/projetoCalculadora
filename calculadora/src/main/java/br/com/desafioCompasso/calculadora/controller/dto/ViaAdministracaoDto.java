package br.com.desafioCompasso.calculadora.controller.dto;




import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ViaAdministracaoDto {
	
	private Long id;
	private String nome;
	

	public ViaAdministracaoDto(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}


	
	

}
