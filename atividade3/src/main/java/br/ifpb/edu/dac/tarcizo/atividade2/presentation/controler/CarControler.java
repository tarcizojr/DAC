package br.ifpb.edu.dac.tarcizo.atividade2.presentation.controler;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ifpb.edu.dac.tarcizo.atividade2.business.services.CarService;
import br.ifpb.edu.dac.tarcizo.atividade2.business.services.converter.ConverterEntity;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Car;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO.CarDTO;



@RestController
@RequestMapping("/api/car")
public class CarControler {
	
	@Autowired
	private CarService carService;	
	
	@Autowired
	private ConverterEntity converterEntity;
	
	@PostMapping
	public ResponseEntity saveCar(@RequestBody CarDTO carDto) {
		try {
			Car car = converterEntity.converterCarDtoToCar(carDto);
			car = carService.saveCar(car);
			carDto = converterEntity.converterCarToCarDto(car);
			
			return new ResponseEntity(carDto, HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity updateCar(@PathVariable("id")Long id, @RequestBody CarDTO carDto) {
		try {
			Car	car = carService.updateCar(id, carDto);
			carDto = converterEntity.converterCarToCarDto(car);
			
			return new ResponseEntity(carDto, HttpStatus.CREATED);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity  deleteCarById(@PathVariable("id") Long id) {
		try {
			carService.deleteCarById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	

	
	@GetMapping
	public ResponseEntity listCar(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "model", required = false) String model,
			@RequestParam(value = "brand", required = false) String brand){
		try {
						
			Car  filter =  new Car();
			filter.setId(id);
			filter.setModel(model);
			filter.setBrand(brand);
			
			List<Car> cars = carService.listCar(filter);
			List<CarDTO> dtos = converterEntity.converterCarToCarDto(cars);
			return ResponseEntity.ok(dtos);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());		
			
		}

	}
	
	public Car findCarById(String id) {
		return carService.findCarById(Long.parseLong(id));
	}
	

}
