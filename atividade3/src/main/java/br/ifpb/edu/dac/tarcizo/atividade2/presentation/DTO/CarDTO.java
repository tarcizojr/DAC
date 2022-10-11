package br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Sale;


public class CarDTO {
	private Long id;
	private String brand;
	private String model;
	
	
	@OneToMany(mappedBy = "saller")
	private List<Sale> sales;
	
	
	public CarDTO() {
	}

	public CarDTO(Long id, String brand, String model, List<Sale> sales) {		
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.sales = sales;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public List<Sale> getSales() {
		return sales;
	}


	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}


	@Override
	public int hashCode() {
		return Objects.hash(brand, id, model, sales);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarDTO other = (CarDTO) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(id, other.id) && Objects.equals(model, other.model)
				&& Objects.equals(sales, other.sales);
	}
	
	
}
