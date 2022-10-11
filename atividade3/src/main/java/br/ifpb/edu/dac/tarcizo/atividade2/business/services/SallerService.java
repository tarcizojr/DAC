package br.ifpb.edu.dac.tarcizo.atividade2.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Saller;
import br.ifpb.edu.dac.tarcizo.atividade2.model.enums.Sex;
import br.ifpb.edu.dac.tarcizo.atividade2.model.repository.SallerRepository;
import br.ifpb.edu.dac.tarcizo.atividade2.presentation.DTO.SallerDTO;

@Service
public class SallerService {
	
	@Autowired
	private SallerRepository sallerDAO;
	
	public Saller saveSaller(Saller saller) {
		return sallerDAO.save(saller);
	

	}
	
	public Saller updateSaller(Long id, SallerDTO saller) {
		Saller saller1 = findSallerById(id);
			saller1.setCpf(saller.getCpf());
			saller1.setName(saller.getNome());
			
			if(saller.getSexoEnum().equals("Homem")) {
				saller1.setSex(Sex.HOMEM);
			}else {
				saller1.setSex(Sex.MULHER);
			}
			return sallerDAO.save(saller1);
		
	}
	
	public void deleteSallerById(Long id) {		
			sallerDAO.deleteById(id);
	
	}
	
	
	public List<Saller> findAllSaller(Saller filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return sallerDAO.findAll(example);
	}
	
	public Saller findSallerById(Long id) { 
		Optional<Saller> saller = sallerDAO.findById(id);
		if(saller.isPresent()) {
			return saller.get();
		}
		else {
			return null;
		}
	}

	
	

}
