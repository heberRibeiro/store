package br.unit.pe.store.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.unit.pe.store.domain.Marca;
import br.unit.pe.store.repositories.MarcaRepository;
import br.unit.pe.store.services.exceptions.ObjectNotFoundException;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository repository;

	public List<Marca> findAll() {
		return repository.findAll();
	}

	public Marca findById(Integer id) {

		try {
			Marca marca = repository.findById(id).get();
			return marca;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Marca não encotrada na base de dados.");
		}
	}

	public Marca insert(Marca marca) {
		return repository.save(marca);
	}

	public Marca update(Marca marca, Integer id) {

		try {
			Marca obj = repository.getOne(id); // return a reference to the entity
			obj.setId(marca.getId());
			obj.setNome(marca.getNome());
			obj.setDescricao(marca.getDescricao());

			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Marca não encontrada na base de dados para atualização.");
		}

	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Marca não encontrado na base de dados para deleção.");
		}
	}

}
