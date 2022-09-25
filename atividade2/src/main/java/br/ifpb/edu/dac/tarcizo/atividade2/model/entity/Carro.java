package br.ifpb.edu.dac.tarcizo.atividade2.model.entity;


import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carro{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String marca;
	private String modelo;
	
	
	@OneToMany(mappedBy = "vendedor")
	private List<Venda> vendas;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, marca, modelo, vendas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id) && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo)
				&& Objects.equals(vendas, other.vendas);
	}
	

	
	
	


	
	

}
