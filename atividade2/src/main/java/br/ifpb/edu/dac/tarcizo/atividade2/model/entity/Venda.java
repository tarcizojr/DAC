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
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private float valorDaVenda;
	
	@Temporal(TemporalType.DATE)	
	private Date dataDaVenda;
	
	@ManyToOne
	@JoinColumn(name = "ID_Vendedor")
	private Vendedor vendedor;
	
	@ManyToOne
	@JoinColumn(name = "ID_Carro")
	private Carro carro;

	public float getValorDaVenda() {
		return valorDaVenda;
	}

	public void setValorDaVenda(float valorDaVenda) {
		this.valorDaVenda = valorDaVenda;
	}

	public Date getDataDaVenda() {
		return dataDaVenda;
	}

	public void setDataDaVenda(Date dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carro, dataDaVenda, id, valorDaVenda, vendedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(carro, other.carro) && Objects.equals(dataDaVenda, other.dataDaVenda)
				&& Objects.equals(id, other.id)
				&& Float.floatToIntBits(valorDaVenda) == Float.floatToIntBits(other.valorDaVenda)
				&& Objects.equals(vendedor, other.vendedor);
	}
	
	
}
