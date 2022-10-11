package br.ifpb.edu.dac.tarcizo.atividade2.model.enums;

public enum Sex {
	HOMEM("Homem"),
	MULHER("Mulher");
	
	private String sexo;
	
	private Sex(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}
}
