package br.unit.pe.store.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The Class Marca.
 */
@Entity
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	
	@OneToMany(mappedBy = "marca")
	private List<Produto> produtos = new ArrayList<>();
	
	/**
	 * Instantiates a new marca.
	 */
	public Marca() {
		
	}

	/**
	 * Instantiates a new marca.
	 *
	 * @param nome nome da marca
	 * @param descricao descricao da marca
	 */
	public Marca(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Marca(Integer id) {
		super();
		this.id = id;
	}
}
