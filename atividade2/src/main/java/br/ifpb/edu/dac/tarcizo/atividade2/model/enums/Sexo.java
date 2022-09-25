package br.ifpb.edu.dac.tarcizo.atividade2.model.enums;

public enum Sexo {
	HOMEM("Homem"),
	MULHER("Mulher");
	
	private String sexo;
	
	private Sexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}
}
