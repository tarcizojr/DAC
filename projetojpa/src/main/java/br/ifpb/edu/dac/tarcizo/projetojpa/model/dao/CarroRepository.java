package br.ifpb.edu.dac.tarcizo.projetojpa.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.ifpb.edu.dac.tarcizo.projetojpa.model.entity.Carro;

@Repository
public interface CarroRepository extends PagingAndSortingRepository<Carro, Long>{
	
}
