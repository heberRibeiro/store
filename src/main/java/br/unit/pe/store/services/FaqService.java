package br.unit.pe.store.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.unit.pe.store.domain.Faq;
import br.unit.pe.store.repositories.FaqRepository;
import br.unit.pe.store.services.exceptions.ObjectNotFoundException;

@Service
public class FaqService {
	
	@Autowired
	private FaqRepository repository;
	
	public List<Faq> findAll(Pageable pageable) {
		return repository.findAll(pageable).getContent();
	}
	
	public Faq findById(Integer id) {

		try {
			Faq faq = repository.findById(id).get();
			return faq;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Faq não encotrado na base de dados.");
		}
	}

	public Faq insert(Faq faq) {
		return repository.save(faq);
	}

	public Faq update(Faq faq, Integer id) {

		try {
			Faq obj = repository.getOne(id); // return a reference to the entity
			obj.setId(faq.getId());
			obj.setTexto(faq.getTexto());
			obj.setDataHora(faq.getDataHora());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Faq não encontrada na base de dados para atualização.");
		}

	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Faq não encontrada na base de dados para deleção.");
		}
	}

}
