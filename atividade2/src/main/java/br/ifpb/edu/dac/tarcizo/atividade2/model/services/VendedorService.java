package br.ifpb.edu.dac.tarcizo.atividade2.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.edu.dac.tarcizo.atividade2.model.dao.VendedorDAO;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Vendedor;
import br.ifpb.edu.dac.tarcizo.atividade2.model.enums.Sexo;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorDAO vendedorDAO;
	
	public void save(String nome, String cpf, Sexo sexo) {
		Vendedor vendedor = new Vendedor();
		vendedor.setNome(nome);
		vendedor.setCpf(cpf);
		vendedor.setSexo(sexo);
		vendedorDAO.save(vendedor);
		System.out.println("Vendedor salvo...");

	}
	
	public void update(Long id, String nome, String cpf, Sexo sexo) {
		Vendedor vendedor = buscarPorId(id);
		if(vendedor != null) {
			vendedor.setNome(nome);
			vendedor.setCpf(cpf);
			vendedor.setSexo(sexo);
			vendedorDAO.save(vendedor);
			System.out.println("Vendedor atualizado...");

		}else {
			System.out.println("vendedor não encontrado");
		}
		
	}
	
	public void deletById(Long id) {
		Vendedor vendedor = buscarPorId(id);
		if(vendedor != null) {
			vendedorDAO.deleteById(id);
			System.out.println("Vendedor deletado...");

		}else {
			System.out.println("vendedor não encontrado");
		}
	}
	
	public void deletarTodos() {
		vendedorDAO.deleteAll();
		System.out.println("Todos os Vendedores foram deletado...");

	}
	
	public List<Vendedor> listarTodosVendedores(){
		return (List<Vendedor>) vendedorDAO.findAll();
	}
	
	public Vendedor buscarPorId(Long id) { 
		Optional<Vendedor> vendedor = vendedorDAO.findById(id);
		if(vendedor.isPresent()) {
			return vendedor.get();
		}
		else {
			return null;
		}
	}

	
	

}
