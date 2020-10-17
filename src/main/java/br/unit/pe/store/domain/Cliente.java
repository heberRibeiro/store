package br.unit.pe.store.domain;

import java.util.Date;

/**
 * The Class Cliente.
 */
public class Cliente {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	private Date dataNascimento;
	private String sexo;
	private String nomeSocial;
	private String telefone;
	
	/**
	 * Instantiates a new cliente.
	 */
	public Cliente() {
		
	}

	/**
	 * Instantiates a new cliente.
	 *
	 * @param nome nome do Cliente
	 * @param cpf cpf do Cliente
	 * @param email email do Cliente
	 * @param dataNascimento data nascimento do Cliente
	 * @param sexo sexo do Cliente
	 * @param nomeSocial nome social do Cliente
	 * @param telefone telefone do Cliente
	 */
	public Cliente(String nome, String cpf, String email, Date dataNascimento, String sexo, String nomeSocial,
			String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.nomeSocial = nomeSocial;
		this.telefone = telefone;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
