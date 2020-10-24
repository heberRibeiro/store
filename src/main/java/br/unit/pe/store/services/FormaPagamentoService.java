package br.unit.pe.store.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.unit.pe.store.domain.FormaPagamento;
import br.unit.pe.store.repositories.FormaPagamentoRepository;
import br.unit.pe.store.services.exceptions.ObjectNotFoundException;

@Service
public class FormaPagamentoService {
	
	@Autowired
	private FormaPagamentoRepository repository;
	
	public List<FormaPagamento> findAll(Pageable pageable) {
		return repository.findAll(pageable).getContent();
	}
	
	public FormaPagamento findById(Integer id) {

		try {
			FormaPagamento formaPagamento = repository.findById(id).get();
			return formaPagamento;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Forma de Pagamento não encotrada na base de dados.");
		}
	}

	public FormaPagamento insert(FormaPagamento formaPagamento) {
		return repository.save(formaPagamento);
	}

	public FormaPagamento update(FormaPagamento formaPagamento, Integer id) {

		try {
			FormaPagamento obj = repository.getOne(id); // return a reference to the entity
			obj.setId(formaPagamento.getId());
			obj.setForma(formaPagamento.getForma());
			obj.setDescricao(formaPagamento.getDescricao());
			obj.setStatus(formaPagamento.getStatus());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Forma de Pagamento não encontrada na base de dados para atualização.");
		}

	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Forma de Pagamento não encontrada na base de dados para deleção.");
		}
	}
}
