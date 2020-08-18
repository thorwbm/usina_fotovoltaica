package com.gjw.opiniao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the responsavel database table.
 * 
 */
@Entity
@Table(name="responsavel")
@NamedQuery(name="Responsavel.findAll", query="SELECT r FROM Responsavel r")
public class Responsavel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long codigo;

	private String cep;

	private String complemento;

	@Column(name="cpf_cnpj")
	private String cpfCnpj;

	@Column(name="endereco_id")
	private long enderecoId;

	@Column(name="estado_civil")
	private String estadoCivil;

	private String identidade;

	private String logradouro;

	private String nome;

	private String numero;

	//bi-directional many-to-one association to Consorcio
	@OneToMany(mappedBy="responsavel")
	private Set<Consorcio> consorcios;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	private Cidade cidade;

	public Responsavel() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpfCnpj() {
		return this.cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public long getEnderecoId() {
		return this.enderecoId;
	}

	public void setEnderecoId(long enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getIdentidade() {
		return this.identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Set<Consorcio> getConsorcios() {
		return this.consorcios;
	}

	public void setConsorcios(Set<Consorcio> consorcios) {
		this.consorcios = consorcios;
	}

	public Consorcio addConsorcio(Consorcio consorcio) {
		getConsorcios().add(consorcio);
		consorcio.setResponsavel(this);

		return consorcio;
	}

	public Consorcio removeConsorcio(Consorcio consorcio) {
		getConsorcios().remove(consorcio);
		consorcio.setResponsavel(null);

		return consorcio;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}