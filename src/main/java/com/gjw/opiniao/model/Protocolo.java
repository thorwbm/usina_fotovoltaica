package com.gjw.opiniao.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the protocolo database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="protocolo")
@NamedQuery(name="Protocolo.findAll", query="SELECT p FROM Protocolo p")
public class Protocolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_abertura")
	private Date dataAbertura;

	private String descricao;

	@Column(name="nota_servico")
	private String notaServico;

	@Column(name="nro_instalacao")
	private long nroInstalacao;

	@Column(name="nro_protocolo")
	private String nroProtocolo;

	@Column(name="nro_protocolo_entrada")
	private String nroProtocoloEntrada;

	@Column(name="nro_protocolo_fechamento")
	private String nroProtocoloFechamento;

	private String recebido;

	private String responsavel;

	//bi-directional many-to-one association to AndamentoProtocolo
	@OneToMany(mappedBy="protocolo")
	private Set<AndamentoProtocolo> andamentoProtocolos;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	private Empresa empresa;

	//bi-directional many-to-one association to Usina
	@ManyToOne
	private Usina usina;



}