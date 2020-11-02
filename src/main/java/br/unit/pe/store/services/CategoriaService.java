package br.unit.pe.store.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.unit.pe.store.domain.Categoria;
import br.unit.pe.store.repositories.CategoriaRepository;
import br.unit.pe.store.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Categoria findById(Integer id) {

		try {
			Categoria patient = repository.findById(id).get();
			return patient;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Categoria não encaontrada na base de dados.");
		}
	}

	public Categoria insert(Categoria patient) {
		return repository.save(patient);
	}

	public Categoria update(Categoria categoria, Integer id) {

		try {
			Categoria obj = repository.getOne(id); // return a reference to the entity
			obj.setId(categoria.getId());
			obj.setNome(categoria.getNome());
			obj.setStatus(categoria.getStatus());
			

			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Categoria a ser atualizada não encontrada na base de dados.");
		}

	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Categoria não encaontrada na base de dados.");
		}
	}


}
