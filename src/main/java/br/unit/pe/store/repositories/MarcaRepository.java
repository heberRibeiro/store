package br.unit.pe.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unit.pe.store.domain.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
