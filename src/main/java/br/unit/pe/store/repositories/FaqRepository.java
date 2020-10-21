package br.unit.pe.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unit.pe.store.domain.Faq;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer> {

}
