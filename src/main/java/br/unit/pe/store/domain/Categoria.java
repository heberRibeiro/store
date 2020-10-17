package br.unit.pe.store.domain;

/**
 * The Class Categoria.
 */
public class Categoria {
	
	private Integer id;
	private String nome;
	private Integer status;
	
	/**
	 * Instantiates a new categoria.
	 */
	public Categoria() {
		
	}

	/**
	 * Instantiates a new categoria.
	 *
	 * @param id id da Categoria
	 * @param nome nome da Categoria
	 * @param status status da Categoria
	 */
	public Categoria(Integer id, String nome, Integer status) {
		this.nome = nome;
		this.status = status;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
