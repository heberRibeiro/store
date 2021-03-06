package br.unit.pe.store.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The Class Faq.
 */
@Entity
public class Faq implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String texto;
	private Date dataHora;
	
	@ManyToOne
	@JoinColumn(name = "produtoId")
	private Produto produto;
	
	/**
	 * Instantiates a new faq.
	 */
	public Faq() {
		
	}

	/**
	 * Instantiates a new faq.
	 *
	 * @param texto texto do faq
	 * @param dataHora data hora do faq
	 * @param produtoId id do Produto
	 */
	public Faq(Integer id, String texto, Date dataHora, Integer produtoId) {
		this.id = id;
		this.texto = texto;
		this.dataHora = dataHora;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
		Faq other = (Faq) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
