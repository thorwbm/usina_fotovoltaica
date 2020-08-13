package com.gjw.opiniao.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the cidade database table.
 * 
 */

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="cidade")
@NamedQuery(name="Cidade.findAll", query="SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long codigo;

	@Column(name="codigo_ibge")
	private int codigoIbge;

	private String nome;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	private Estado estado;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="cidade")
	private Set<Endereco> enderecos;

	
}