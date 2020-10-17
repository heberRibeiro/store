package br.unit.pe.store.domain;

/**
 * The Class Produto.
 */
public class Produto {
	
	private Integer id;
	private String nome;
	private String descricao;
	private Double precoUnitario;
	private String unidade;
	private Integer categoriaId;
	private Integer fornecedorId;
	private Integer marcaId;
	
	/**
	 * Instantiates a new produto.
	 */
	public Produto() {
		
	}

	/**
	 * Instantiates a new produto.
	 *
	 * @param id the id
	 * @param nome nome do produto
	 * @param descricao descricao do produto
	 * @param precoUnitario preco unitario do produto
	 * @param unidade unidade do produto
	 * @param categoriaId categoria id da categoria
	 * @param fornecedorId fornecedor id do fornecedor
	 * @param marcaId marca id
	 */
	public Produto(Integer id, String nome, String descricao, Double precoUnitario, String unidade, Integer categoriaId,
			Integer fornecedorId, Integer marcaId) {
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.unidade = unidade;
		this.categoriaId = categoriaId;
		this.fornecedorId = fornecedorId;
		this.marcaId = marcaId;
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

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Integer getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(Integer fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	public Integer getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Integer marcaId) {
		this.marcaId = marcaId;
	}

}
