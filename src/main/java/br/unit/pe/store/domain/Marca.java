package br.unit.pe.store.domain;

import java.io.Serializable;

/**
 * The Class Marca.
 */
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String descricao;
	
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
	public Marca(String nome, String descricao) {
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
