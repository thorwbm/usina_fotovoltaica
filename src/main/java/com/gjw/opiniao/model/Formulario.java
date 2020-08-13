package com.gjw.opiniao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the formulario database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="formulario")
@NamedQuery(name="Formulario.findAll", query="SELECT f FROM Formulario f")
public class Formulario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_assinatura")
	private Date dataAssinatura;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_finalizacao")
	private Date dataFinalizacao;

	private String observacao;

	private String responsavel;

	private String situacao;

	//bi-directional many-to-one association to Documento
	@ManyToOne
	private Documento documento;

	//bi-directional many-to-one association to Usina
	@ManyToOne
	private Usina usina;

	
}