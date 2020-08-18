package com.gjw.opiniao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name="empresa")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long codigo;

	private String nome;

	//bi-directional many-to-one association to Protocolo
	@OneToMany(mappedBy="empresa")
	private Set<Protocolo> protocolos;

	public Empresa() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Protocolo> getProtocolos() {
		return this.protocolos;
	}

	public void setProtocolos(Set<Protocolo> protocolos) {
		this.protocolos = protocolos;
	}

	public Protocolo addProtocolo(Protocolo protocolo) {
		getProtocolos().add(protocolo);
		protocolo.setEmpresa(this);

		return protocolo;
	}

	public Protocolo removeProtocolo(Protocolo protocolo) {
		getProtocolos().remove(protocolo);
		protocolo.setEmpresa(null);

		return protocolo;
	}

}