package com.gjw.opiniao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
 * The persistent class for the documentacao database table.
 * 
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="documentacao")
@NamedQuery(name="Documentacao.findAll", query="SELECT d FROM Documentacao d")
public class Documentacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao")
	private Date dataCriacao;

	private String arquivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_assinatura")
	private Date dataAssinatura;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_postagem")
	private Date dataPostagem;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_finalizacao")
	private Date dataFinalizacao;

	private String responsavel;
	
	private String identificador;
	
	@Enumerated(EnumType.STRING)
	private SituacaoDocumentacao situacao;

	private String observacao;
	
	//bi-directional many-to-one association to Usina
	@ManyToOne
	private Usina usina;
	
	//bi-directional many-to-one association to Documento
	@ManyToOne
	private Documento documento = new Documento();

	public Documentacao() {
	}

}