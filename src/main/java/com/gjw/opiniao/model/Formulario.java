package com.gjw.opiniao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the formulario database table.
 * 
 */
@Entity
@Table(name="formulario")
@NamedQuery(name="Formulario.findAll", query="SELECT f FROM Formulario f")
public class Formulario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long codigo;

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

	public Formulario() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataAssinatura() {
		return this.dataAssinatura;
	}

	public void setDataAssinatura(Date dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public Date getDataFinalizacao() {
		return this.dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Usina getUsina() {
		return this.usina;
	}

	public void setUsina(Usina usina) {
		this.usina = usina;
	}

}