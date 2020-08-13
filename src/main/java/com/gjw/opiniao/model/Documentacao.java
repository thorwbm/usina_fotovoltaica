package com.gjw.opiniao.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * The persistent class for the documentacao database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="documentacao")
@NamedQuery(name="Documentacao.findAll", query="SELECT d FROM Documentacao d")
public class Documentacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_postagem")
	private Date dataPostagem;

	@Column(name="documento_url")
	private String documentoUrl;

	private String observacao;

	private String situacao;

	//bi-directional many-to-one association to Documento
	@ManyToOne
	private Documento documento;

	//bi-directional many-to-one association to Usina
	@ManyToOne
	private Usina usina;

}