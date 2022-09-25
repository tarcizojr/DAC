package br.ifpb.edu.dac.tarcizo.atividade2.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Venda;

@Repository
public interface VendaDAO extends PagingAndSortingRepository<Venda, Long>{

}
