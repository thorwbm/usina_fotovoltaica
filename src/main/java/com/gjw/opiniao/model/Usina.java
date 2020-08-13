package com.gjw.opiniao.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the usina database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="usina")
@NamedQuery(name="Usina.findAll", query="SELECT u FROM Usina u")
public class Usina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String art;

	@Column(name="data_inicio")
	private Timestamp dataInicio;

	@Column(name="data_termino")
	private Timestamp dataTermino;

	@Column(name="endereco_id")
	private long enderecoId;

	@Column(name="localizacao_gms")
	private String localizacaoGms;

	@Column(name="localizacao_utm")
	private String localizacaoUtm;

	private String nome;

	private int potencia;

	private String situacao;

	//bi-directional many-to-one association to Documentacao
	@OneToMany(mappedBy="usina")
	private Set<Documentacao> documentacaos;

	//bi-directional many-to-one association to Formulario
	@OneToMany(mappedBy="usina")
	private Set<Formulario> formularios;

	//bi-directional many-to-one association to Protocolo
	@OneToMany(mappedBy="usina")
	private Set<Protocolo> protocolos;

	//bi-directional many-to-one association to Consorcio
	@ManyToOne
	private Consorcio consorcio;

	//bi-directional one-to-one association to Endereco
	@OneToOne
	@JoinColumn(name="id")
	private Endereco endereco;

	//bi-directional many-to-one association to Usina
	@ManyToOne
	@JoinColumn(name="origem_usina_id")
	private Usina usina;

	//bi-directional many-to-one association to Usina
	@OneToMany(mappedBy="usina")
	private Set<Usina> usinas;

	
}