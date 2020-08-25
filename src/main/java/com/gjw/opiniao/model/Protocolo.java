package com.gjw.opiniao.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the protocolo database table.
 * 
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="protocolo")
@NamedQuery(name="Protocolo.findAll", query="SELECT p FROM Protocolo p")
public class Protocolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long codigo;

	private String descricao;
	
	@Column(name="nro_protocolo")
	private String nroProtocolo;

	@Column(name="nro_protocolo_entrada")
	private String nroProtocoloEntrada;
	
	@Column(name="nro_instalacao")
	private long nroInstalacao;
	
	@Column(name="nota_servico")
	private String notaServico;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_abertura")
	private Date dataAbertura;

	private String responsavel;

	private String recebido;

	//bi-directional many-to-one association to AndamentoProtocolo
	@OneToMany(mappedBy="protocolo")
	private Set<AndamentoProtocolo> andamentoProtocolos = new HashSet<AndamentoProtocolo>();

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	private Empresa empresa = new Empresa();

	//bi-directional many-to-one association to Usina
	@ManyToOne
	private Usina usina;

	public Protocolo() {
	}

}