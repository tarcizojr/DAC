package br.ifpb.edu.dac.tarcizo.projetojpa.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.ifpb.edu.dac.tarcizo.projetojpa.model.dao.CarroRepository;
import br.ifpb.edu.dac.tarcizo.projetojpa.model.entity.Carro;



@Controller
public class CarroControler {
	
	@Autowired
	private CarroRepository carroRepository;
		
	private String marcas[] =  {"Volkswagen", "Ford", "Fiat","Chevrolet"};
	private String modelos[] =  {"Fusca", "Del Rey", "Uno", "Opala"};
	
	
	
	public void create() {
		for (int i =0;i <=3;i++) {
			Carro carro = new Carro();			
			carro.setMarca("Marca:" + marcas[i]);
			carro.setModelo("Modelo:" + modelos[i]);
			carroRepository.save(carro);
			System.out.println("Criando carro" + i);
		}
	}
	
	public void delet() {
		carroRepository.deleteAll();
	}
	
	public List<Carro> list(){
		return (List<Carro>) carroRepository.findAll();
	}
}
