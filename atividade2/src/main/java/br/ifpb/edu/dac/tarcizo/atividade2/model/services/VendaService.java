package br.ifpb.edu.dac.tarcizo.atividade2.model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.edu.dac.tarcizo.atividade2.controler.CarroControler;
import br.ifpb.edu.dac.tarcizo.atividade2.controler.VendedorController;
import br.ifpb.edu.dac.tarcizo.atividade2.model.dao.CarroDAO;
import br.ifpb.edu.dac.tarcizo.atividade2.model.dao.VendaDAO;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Carro;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Venda;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Vendedor;

@Service
public class VendaService {

	@Autowired
	private VendaDAO vendaDAO;
	
	@Autowired
	private CarroControler carroControler;
	
	@Autowired 
	private VendedorController vendedorControler;
	
	public void save(Long idCarro, Long idVendedor, float valorVenda, String dataDaVenda) throws ParseException {
		Venda venda = new Venda();
		
		Carro carro = carroControler.buscarPorId(idCarro);
		Vendedor vendedor = vendedorControler.buscarPorId(idVendedor);
		venda.setValorDaVenda(valorVenda);
		venda.setCarro(carro);
		venda.setVendedor(vendedor);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date data = formato.parse(dataDaVenda);		
		venda.setDataDaVenda(data);
		
		vendaDAO.save(venda);
		System.out.println("Vendedor criado...");
				
	}
	
	public void update(Long id, Long idCarro, Long idVendedor, float valorVenda, String dataDaVenda) throws ParseException {
		Venda venda = buscaPorId(id);
		if(venda != null) {
			Carro carro = carroControler.buscarPorId(idCarro);
			Vendedor vendedor = vendedorControler.buscarPorId(idVendedor);
			venda.setValorDaVenda(valorVenda);
			venda.setCarro(carro);
			venda.setVendedor(vendedor);
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			Date data = formato.parse("20/20/2010");		
			venda.setDataDaVenda(data);
			
			vendaDAO.save(venda);
			System.out.println("Venda atualizada...");
		}else {
			System.out.println("Venda não encontrada");
		}
	}
	
	public void deletaById(Long id) {
		Venda venda = buscaPorId(id);
		if(venda != null) {
			vendaDAO.deleteById(id);
			System.out.println("Venda deletada...");
		}else {
			System.out.println("Venda não encontrado");
		}
	}
	
	public void deletarTodos() {
		vendaDAO.deleteAll();
		System.out.println("Todas as Vendas foram deletada...");

	}
	
	public List<Venda> listaTodasVendas(){
		return (List<Venda>) vendaDAO.findAll();
	}
	
	public Venda buscaPorId(Long id) {
		Optional<Venda> venda = vendaDAO.findById(id);
		if(venda.isPresent()) {
			return venda.get();
		}else {
			return null;
		}
	}
}
