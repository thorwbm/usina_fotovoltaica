package com.gjw.opiniao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gjw.opiniao.service.UsinaService;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the usina database table.
 * 
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="usina")
@NamedQuery(name="Usina.findAll", query="SELECT u FROM Usina u")
public class Usina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long codigo;
	
	private String nome;
	
	@Column(name="localizacao_utm")
	private String localizacaoUtm;
	
	@Column(name="localizacao_gms")
	private String localizacaoGms;

	private String art;
	
	@Enumerated(EnumType.STRING)
	private SituacaoProcesso situacao;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;

	private String cep;
	
	private String telefone;

	private String contato;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_termino")
	private Date dataTermino;

	//bi-directional many-to-one association to Consorcio
	@ManyToOne
	private Consorcio consorcio = new Consorcio();
	
	//bi-directional many-to-one association to Consorcio
	@ManyToOne
	private Consorcio comodato = new Consorcio();

	//bi-directional many-to-one association to Potencia
	@ManyToOne
	private Potencia potencia;
	
	//bi-directional many-to-one association to Cidade
	@ManyToOne
	private Cidade cidade = new Cidade();
	
	//bi-directional many-to-one association to Usina
	@ManyToOne
	@JoinColumn(name="origem_usina_id")
	private Usina usina_origem;
	
	//bi-directional many-to-one association to Usina
	@OneToMany(mappedBy="usina_origem")
	private Set<Usina> usinas = new HashSet<Usina>();

	//bi-directional many-to-one association to Documentacao
	@OneToMany(mappedBy="usina", cascade = CascadeType.ALL)
	private Set<Documentacao> documentacoes = new HashSet<Documentacao>();

	//bi-directional many-to-one association to Protocolo
	@OneToMany(mappedBy="usina")
	private Set<Protocolo> protocolos = new HashSet<Protocolo>();

	public Usina() {
	}
}