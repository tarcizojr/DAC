package br.ifpb.edu.dac.tarcizo.atividade2.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.edu.dac.tarcizo.atividade2.model.dao.CarroDAO;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Carro;

@Service
public class CarroService {
	
	@Autowired
	private CarroDAO carroDAO;
	public void save(String marca, String modelo) {
		Carro carro = new Carro();
		carro.setMarca(marca);
		carro.setModelo(modelo);		
		carroDAO.save(carro);
		System.out.println("Carro criado...");
	}
	
	public void update(Long id, String marca, String modelo) {
		Carro carro = buscarPorId(id);
		if(carro != null) {
			carro.setMarca(marca);
			carro.setModelo(modelo);
			carroDAO.save(carro);
			System.out.println("Carro atualizado...");
		}else {
			System.out.println("Carro não encontrado");
		}
		
	}
	
	public void deletById(Long id) {
		Carro carro = buscarPorId(id);
		if(carro != null) {
			carroDAO.deleteById(id);
			System.out.println("Carro deletado...");
		}else {
			System.out.println("Carro não encontrado");
		}
	}
	
	public void deletarTodos() {
		carroDAO.deleteAll();
		System.out.println("Todos os Carro foram deletados...");
	}
	
	public List<Carro> listarTodosVendedores(){
		return (List<Carro>) carroDAO.findAll();
	}
	
	public Carro buscarPorId(Long id) { 
		Optional<Carro> carro = carroDAO.findById(id);
		if(carro.isPresent()) {
			return carro.get();
		}
		else {
			return null;
		}
	}

	
}
