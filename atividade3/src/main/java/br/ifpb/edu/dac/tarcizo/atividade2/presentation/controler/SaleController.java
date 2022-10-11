package br.ifpb.edu.dac.tarcizo.atividade2.presentation.controler;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ifpb.edu.dac.tarcizo.atividade2.business.services.SaleService;
import br.ifpb.edu.dac.tarcizo.atividade2.business.services.converter.ConverterEntity;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Car;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Sale;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Saller;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO.CarDTO;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO.SaleDTO;

@RestController
@RequestMapping("/api/saler")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private CarControler carController;
	
	@Autowired
	private ConverterEntity converterEntity;
	
	@PostMapping
	public ResponseEntity saveSale(@RequestBody  SaleDTO saleDto) {
		try {
			Sale sale = converterEntity.converterSaleDtoToSale(saleDto);
			sale = saleService.saveSale(sale);
			saleDto = converterEntity.converterSaleToSaleDto(sale);
			
			return new ResponseEntity(saleDto, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity updateSale(@PathVariable("id")Long id, @RequestBody SaleDTO saleDto) {
		try {
			Sale sale = saleService.updateSale(id, saleDto);
			saleDto = converterEntity.converterSaleToSaleDto(sale);
			
			return new ResponseEntity(saleDto, HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteSaleById(@PathVariable("id")Long id) {
		try {
			saleService.deleteSaleById(id);
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@GetMapping
	public ResponseEntity listAllSale(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "saller", required = false) String saller,
			@RequestParam(value = "car", required = false) String car,
			@RequestParam(value = "value", required = false) Float value){
		try {
			Sale  filter =  new Sale();
			filter.setId(id);			
			filter.setSaleValue(value);
			
			List<Sale> sales = saleService.listSale(filter);
			List<SaleDTO> dtos = converterEntity.converterSalesToSaleDto(sales);
			return ResponseEntity.ok(dtos);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	public Sale findSaleById(String id) {
		return saleService.findSaleById(Long.parseLong(id));
	}
}
