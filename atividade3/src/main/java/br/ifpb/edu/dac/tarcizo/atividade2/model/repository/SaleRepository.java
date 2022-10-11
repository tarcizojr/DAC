package br.ifpb.edu.dac.tarcizo.atividade2.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.ifpb.edu.dac.tarcizo.atividade2.model.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

}
