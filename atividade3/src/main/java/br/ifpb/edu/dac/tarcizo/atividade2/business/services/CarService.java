package br.ifpb.edu.dac.tarcizo.atividade2.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Car;
import br.ifpb.edu.dac.tarcizo.atividade2.model.repository.CarRepository;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO.CarDTO;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carDAO;
	
	
	public Car saveCar(Car car) {		
		return carDAO.save(car);
		
	
		
	}
	
	public Car updateCar(Long id, CarDTO car) {
		Car car1 = findCarById(id);
			car1.setBrand(car.getBrand());
			car1.setModel(car.getModel());			
				
			return carDAO.save(car1);
				
	}
	
	public void deleteCarById(Long id) {
		carDAO.deleteById(id);
	}
	
	
	public List<Car> listCar(Car filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return carDAO.findAll(example);
		
	}
	
	public Car findCarById(Long id) { 
		Optional<Car> car = carDAO.findById(id);
		if(car.isPresent()) {
			return car.get();
		}
		else {
			return null;
		}
	}

	
}
