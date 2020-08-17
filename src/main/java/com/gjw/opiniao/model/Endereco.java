package com.gjw.opiniao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="endereco")
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long codigo;

	private String cep;

	private String complemento;

	private String logradouro;

	private String numero;

	private String bairro;
	
	//bi-directional many-to-one association to Consorcio
	@OneToMany(mappedBy="endereco")
	private Set<Consorcio> consorcios = new HashSet<Consorcio>();

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	private Cidade cidade = new Cidade();

	//bi-directional one-to-one association to Responsavel
	@OneToOne(mappedBy="endereco")
	private Responsavel responsavel;

	//bi-directional one-to-one association to Usina
	@OneToOne(mappedBy="endereco")
	private Usina usina;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="endereco")
	private Set<Usuario> usuarios;

	
}