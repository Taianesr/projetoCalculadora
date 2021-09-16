package br.com.desafioCompasso.calculadora.controller.form;

import java.util.List;

public class MedicamentoForm {
	
	private Long grupo_medicamento_id;
	private Long laboratorio_id;
	private String nome;
	private List<DiluicaoConfiguracaoForm> diluicaoConfiguracaoForms; 
	
	public MedicamentoForm() {
		super();
	}
	

	public MedicamentoForm(Long grupo_medicamento_id, Long laboratorio_id, String nome) {
		super();
		this.grupo_medicamento_id = grupo_medicamento_id;
		this.laboratorio_id = laboratorio_id;
		this.nome = nome;
	}	
	

	
	public List<DiluicaoConfiguracaoForm> getDiluicaoConfiguracaoForms() {
		return diluicaoConfiguracaoForms;
	}


	public void setDiluicaoConfiguracaoForms(List<DiluicaoConfiguracaoForm> diluicaoConfiguracaoForms) {
		this.diluicaoConfiguracaoForms = diluicaoConfiguracaoForms;
	}


	public Long getGrupo_medicamento_id() {
		return grupo_medicamento_id;
	}


	public void setGrupo_medicamento_id(Long grupo_medicamento_id) {
		this.grupo_medicamento_id = grupo_medicamento_id;
	}


	public Long getLaboratorio_id() {
		return laboratorio_id;
	}


	public void setLaboratorio_id(Long laboratorio_id) {
		this.laboratorio_id = laboratorio_id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	

}
