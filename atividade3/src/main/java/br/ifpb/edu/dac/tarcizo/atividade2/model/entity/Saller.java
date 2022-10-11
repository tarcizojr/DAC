package br.ifpb.edu.dac.tarcizo.atividade2.model.entity;



import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.ifpb.edu.dac.tarcizo.atividade2.model.enums.Sex;

@Entity
public class Saller{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String cpf;
	private Sex sex;
	
	@OneToMany(mappedBy = "saller")
	private List<Sale> saller;

	public Long getId() {
		return id;
	}
	
	

	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public List<Sale> getVendas() {
		return saller;
	}

	public void setVendas(List<Sale> vendas) {
		this.saller = vendas;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id, name, sex, saller);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Saller other = (Saller) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& sex == other.sex && Objects.equals(saller, other.saller);
	}

	
	
	
	

	
	

}
