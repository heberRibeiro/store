package br.unit.pe.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unit.pe.store.domain.ItemVenda;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {

}
