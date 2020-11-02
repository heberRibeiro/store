package br.unit.pe.store.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The Class Produto.
 */
@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Double precoUnitario;
	private String unidade;

	@ManyToOne
	@JoinColumn(name = "categoriaId")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "fornecedorId")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name = "marcaId")
	private Marca marca;
	
	@OneToMany(mappedBy = "produto")
	private List<Faq> faqs = new ArrayList<>();
	
	@OneToMany(mappedBy = "produto")
	private List<ItemVenda> itensVenda = new ArrayList<>();

	/**
	 * Instantiates a new produto.
	 */
	public Produto() {

	}

	/**
	 * Instantiates a new produto.
	 *
	 * @param id            the id
	 * @param nome          nome do produto
	 * @param descricao     descricao do produto
	 * @param precoUnitario preco unitario do produto
	 * @param unidade       unidade do produto
	 * @param fornecedorId  fornecedor id do fornecedor
	 * @param marcaId       marca id
	 */
	public Produto(Integer id, String nome, String descricao, Double precoUnitario, String unidade, Integer marcaId) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.unidade = unidade;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public Marca getMarca() {
		return marca;
	}

	public List<Faq> getFaqs() {
		return faqs;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public void setFaqs(List<Faq> faqs) {
		this.faqs = faqs;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
