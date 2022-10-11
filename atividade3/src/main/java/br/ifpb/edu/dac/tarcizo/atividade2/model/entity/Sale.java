package br.ifpb.edu.dac.tarcizo.atividade2.model.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private float saleValue;
	
		
	private String dateOfSale;
	
	@ManyToOne
	@JoinColumn(name = "ID_Saller")
	private Saller saller;
	
	@ManyToOne
	@JoinColumn(name = "ID_Car")
	private Car car;

	
	
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

	public Saller getSaller() {
		return saller;
	}

	public void setSaller(Saller saller) {
		this.saller = saller;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Long getId() {
		return id;
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
		Sale other = (Sale) obj;
		return Objects.equals(car, other.car) && Objects.equals(dateOfSale, other.dateOfSale)
				&& Objects.equals(id, other.id)
				&& Float.floatToIntBits(saleValue) == Float.floatToIntBits(other.saleValue)
				&& Objects.equals(saller, other.saller);
	}

	
	
}
