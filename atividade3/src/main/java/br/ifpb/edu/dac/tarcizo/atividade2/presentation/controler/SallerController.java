package br.ifpb.edu.dac.tarcizo.atividade2.presentation.controler;

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

import br.ifpb.edu.dac.tarcizo.atividade2.business.services.SallerService;
import br.ifpb.edu.dac.tarcizo.atividade2.business.services.converter.ConverterEntity;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Car;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Saller;
import br.ifpb.edu.dac.tarcizo.atividade2.model.enums.Sex;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO.CarDTO;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO.SallerDTO;

@RestController
@RequestMapping("/api/saller")
public class SallerController {
	
	@Autowired
	private SallerService sallerService;
	
	@Autowired
	private ConverterEntity converterEntity;
	
	
	@PostMapping
	public ResponseEntity saveSaller(@RequestBody SallerDTO sallerDto) {
		try {
			Saller saller = converterEntity.converterSallerDtoToSaller(sallerDto);
			saller = sallerService.saveSaller(saller);
			sallerDto = converterEntity.converterSallerToSallerDto(saller);
			
			return new ResponseEntity(sallerDto, HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
		
	@PutMapping("{id}")
	public ResponseEntity uptadeSaller(@PathVariable("id")Long id, @RequestBody SallerDTO sallerDto) {
		try {
			Saller	saller = sallerService.updateSaller(id, sallerDto);
			sallerDto = converterEntity.converterSallerToSallerDto(saller);
			
			return new ResponseEntity(sallerDto, HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteSallerById(@PathVariable("id") Long id) {
		try {
			sallerService.deleteSallerById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity listSallers(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "cpf", required = false) String cpf,
			@RequestParam(value = "sexo", required = false) String sexo){
		try {
			Saller filter = new Saller();
			filter.setId(id);
			filter.setName(nome);
			filter.setCpf(cpf);
			
			
			
			List<Saller> sallers = sallerService.findAllSaller(filter);
			List<SallerDTO> dtos = converterEntity.converterSallerToSallerDto(sallers);
			
			return ResponseEntity.ok(dtos);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	public Saller findSallerById(String id) {
		return sallerService.findSallerById(Long.parseLong(id));
	}
	


}
