package br.ifpb.edu.dac.tarcizo.atividade2.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Vendedor;
import br.ifpb.edu.dac.tarcizo.atividade2.model.enums.Sexo;
import br.ifpb.edu.dac.tarcizo.atividade2.model.services.VendedorService;

@Controller
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService;
	
	public void save(String nome, String cpf, Sexo sexo) {
		vendedorService.save(nome, cpf, sexo);
	}
		
	public void uptade(Long id, String nome, String cpf, Sexo sexo) {
		vendedorService.update(id, nome, cpf, sexo);
	}
		
	public void deletById(Long id) {
		vendedorService.deletById(id);
	}
	
	public void deletarTodos() {
		vendedorService.deletarTodos();
	}
	public List<Vendedor> listarTodosVendedores(){
		return vendedorService.listarTodosVendedores();
	}
	
	public Vendedor buscarPorId(Long id) {
		return vendedorService.buscarPorId(id);
	}
}
