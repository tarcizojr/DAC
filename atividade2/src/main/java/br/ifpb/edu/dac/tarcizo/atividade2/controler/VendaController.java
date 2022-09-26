package br.ifpb.edu.dac.tarcizo.atividade2.controler;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Venda;
import br.ifpb.edu.dac.tarcizo.atividade2.model.services.VendaService;

@Controller
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	public void save(float valorVenda, Long IdVendedor, Long IdCarro, String dataDaVenda) throws ParseException {
		vendaService.save(IdCarro, IdVendedor, valorVenda, dataDaVenda);
	}
	
	public void update(Long id, Long idCarro, Long idVendedor, float valorVenda, String dataDaVenda) throws ParseException {
		vendaService.update(id, idCarro, idVendedor, valorVenda, dataDaVenda);
	}
	
	public void deletById(Long id) {
		vendaService.deletaById(id);
	}
	
	public void deletarTodos() {
		vendaService.deletarTodos();
	}
	public List<Venda> listarTodasVendas(){
		return vendaService.listaTodasVendas();
	}
	
	public Venda buscarPorId(Long id) {
		return vendaService.buscaPorId(id);
	}
}
