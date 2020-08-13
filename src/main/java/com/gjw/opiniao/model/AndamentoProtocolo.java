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
 * The persistent class for the andamento_protocolo database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="andamento_protocolo")
@NamedQuery(name="AndamentoProtocolo.findAll", query="SELECT a FROM AndamentoProtocolo a")
public class AndamentoProtocolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_detalhamento")
	private Date dataDetalhamento;

	private String detalhamento;

	//bi-directional many-to-one association to Protocolo
	@ManyToOne
	private Protocolo protocolo;

	

}