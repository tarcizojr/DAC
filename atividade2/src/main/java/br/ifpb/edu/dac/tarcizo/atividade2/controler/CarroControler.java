package br.ifpb.edu.dac.tarcizo.atividade2.controler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Carro;
import br.ifpb.edu.dac.tarcizo.atividade2.model.services.CarroService;



@Controller
public class CarroControler {
	
	@Autowired
	private CarroService carroService;

	
	public void save(String marca, String modelo) {
		carroService.save(marca, modelo);
	}
	
	public void update(Long id, String marca, String modelo) {
		carroService.update(id, marca, modelo);
	}
	
	public void deletById(Long id) {
		carroService.deletById(id);
	}
	
	public void deletarTodos() {
		carroService.deletarTodos();
	}
	
	public List<Carro> listarTodosCarros(){
		return carroService.listarTodosVendedores();
	}
	
	public Carro buscarPorId(Long id) {
		return carroService.buscarPorId(id);
	}
}
