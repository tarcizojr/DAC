package br.ifpb.edu.dac.tarcizo.atividade2.business.services.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.edu.dac.tarcizo.atividade2.business.services.CarService;
import br.ifpb.edu.dac.tarcizo.atividade2.business.services.SallerService;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Car;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Sale;
import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Saller;
import br.ifpb.edu.dac.tarcizo.atividade2.model.enums.Sex;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO.CarDTO;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO.SaleDTO;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO.SallerDTO;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.controler.CarControler;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.controler.SallerController;

@Service
public class ConverterEntity {
	

	@Autowired
	private CarService carService;
	
	@Autowired
	private SallerService sallerService;
	
	
	public Car converterCarDtoToCar(CarDTO carDto) {
		Car car = new Car();
		
		car.setBrand(carDto.getBrand());
		car.setModel(carDto.getModel());
		return car;
		
	}
	
	public CarDTO converterCarToCarDto(Car car) {
		CarDTO carDto = new CarDTO();
		
		carDto.setId(car.getId());
		carDto.setBrand(car.getBrand());
		carDto.setModel(car.getModel());
		return carDto;
		
	}
	
	public List<CarDTO> converterCarToCarDto(List<Car> cars) {
		List<CarDTO> carDto = new ArrayList<>();
		
		for(Car car: cars ) {
			CarDTO dto = converterCarToCarDto(car);
			carDto.add(dto);
			
		}
		
		return carDto;
		
	}
	
	//=========================
	
	public Saller converterSallerDtoToSaller(SallerDTO sallerDto) {
		Saller saller = new Saller();
		
		saller.setCpf(sallerDto.getCpf());
		saller.setName(sallerDto.getNome());
		
		if(sallerDto.getSexoEnum().equals("Homem")) {
			saller.setSex(Sex.HOMEM);
		}else {
			saller.setSex(Sex.MULHER);
		}
		
		return saller;
		
	}
	
	public SallerDTO converterSallerToSallerDto(Saller saller) {
		SallerDTO sallerDto = new SallerDTO();
		
		sallerDto.setId(saller.getId());
		sallerDto.setCpf(saller.getCpf());
		sallerDto.setNome(saller.getName());
		
		sallerDto.setSexoEnum(saller.getSex().getSexo());
		
		return sallerDto;
		
	}
	
	public List<SallerDTO> converterSallerToSallerDto(List<Saller> sallers) {
		List<SallerDTO> sallersDto = new ArrayList<>();
		
		for (Saller saller : sallers) {
			SallerDTO dto = converterSallerToSallerDto(saller);			
			sallersDto.add(dto);
		}
		
		return sallersDto;
		
	}
	
	//===============
	
	public Sale converterSaleDtoToSale(SaleDTO saleDto) {
		Sale sale = new Sale();
		
		sale.setId(saleDto.getId());
		sale.setDateOfSale(saleDto.getDateOfSale());
		
		if(saleDto.getCar() != null) {
			sale.setCar(carService.findCarById(Long.parseLong(saleDto.getCar())));
		}
		
		if(saleDto.getCar() != null) {
			sale.setSaller(sallerService.findSallerById(Long.parseLong(saleDto.getSaller())));
		}
		
		sale.setSaleValue(saleDto.getSaleValue());
		
		return sale;
		
	}
	
	public SaleDTO converterSaleToSaleDto(Sale sale) {
		SaleDTO saleDto = new SaleDTO();
		
		saleDto.setId(sale.getId());
		saleDto.setDateOfSale(sale.getDateOfSale());
		saleDto.setSaleValue(sale.getSaleValue());
		
		if(saleDto.getCar() != null) {
			saleDto.setCar(Long.toString(sale.getCar().getId()));
		}
		
		if(saleDto.getSaller() != null) {
			saleDto.setSaller(Long.toString(sale.getSaller().getId()));
		}
		
		return saleDto;
		
	}
	
	public List<SaleDTO> converterSalesToSaleDto(List<Sale> sales) {
		List<SaleDTO> salesDto = new ArrayList<>();
		
		for (Sale sale : sales) {
			SaleDTO dto = converterSaleToSaleDto(sale);			
			salesDto.add(dto);
		}
		
		return salesDto;
		
	}
	

}
