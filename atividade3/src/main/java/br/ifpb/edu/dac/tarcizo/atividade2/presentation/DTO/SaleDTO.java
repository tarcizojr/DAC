package br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO;

import java.util.Date;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Car;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Saller;

public class SaleDTO {
	
	private Long id;	
	private float saleValue;
	
	private String dateOfSale;
	
	
	private String saller;
	

	private String car;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(float saleValue) {
		this.saleValue = saleValue;
	}

	


	public String getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(String dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public String getSaller() {
		return saller;
	}

	public void setSaller(String saller) {
		this.saller = saller;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	@Override
	public int hashCode() {
		return Objects.hash(car, dateOfSale, id, saleValue, saller);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleDTO other = (SaleDTO) obj;
		return Objects.equals(car, other.car) && Objects.equals(dateOfSale, other.dateOfSale)
				&& Objects.equals(id, other.id)
				&& Float.floatToIntBits(saleValue) == Float.floatToIntBits(other.saleValue)
				&& Objects.equals(saller, other.saller);
	}

	
	


}
