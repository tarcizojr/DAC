package br.ifpb.edu.dac.tarcizo.atividade2.business.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Car;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Sale;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Saller;
import br.ifpb.edu.dac.tarcizo.atividade2.model.repository.CarRepository;
import br.ifpb.edu.dac.tarcizo.atividade2.model.repository.SaleRepository;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO.SaleDTO;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.controler.CarControler;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.controler.SallerController;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleDAO;
	
	@Autowired
	private CarControler carControler;
	
	@Autowired 
	private SallerController sallerControler;
	
	public Sale saveSale(Sale sale) {
		return saleDAO.save(sale);
	}
	
	public Sale updateSale(Long id, SaleDTO saleDto) {
		Sale sale1 = findSaleById(id);
		
		sale1.setCar(carControler.findCarById(saleDto.getCar()));
		sale1.setDateOfSale(saleDto.getDateOfSale());
		sale1.setSaleValue(saleDto.getSaleValue());
		sale1.setSaller(sallerControler.findSallerById(saleDto.getSaller()));
		
		return saleDAO.save(sale1);
	}
	
	public void deleteSaleById(Long id) {
		saleDAO.deleteById(id);
	}
	
	
	public List<Sale> listSale(Sale filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return saleDAO.findAll();
	}
	
	public Sale findSaleById(Long id) {
		Optional<Sale> venda = saleDAO.findById(id);
		if(venda.isPresent()) {
			return venda.get();
		}else {
			return null;
		}
	}
}
