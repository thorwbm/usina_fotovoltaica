package com.gjw.opiniao.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the documento database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="documento")
@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long codigo;

	private String descricao;

	private String nome;

	private int obrigatorio;

	private String tipo;

	//bi-directional many-to-one association to Documentacao
	@OneToMany(mappedBy="documento")
	private Set<Documentacao> documentacaos;

	//bi-directional many-to-one association to Formulario
	@OneToMany(mappedBy="documento")
	private Set<Formulario> formularios;

	
}