package br.unit.pe.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unit.pe.store.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

}
