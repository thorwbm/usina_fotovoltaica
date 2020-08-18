package com.gjw.opiniao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the protocolo database table.
 * 
 */
@Entity
@Table(name="protocolo")
@NamedQuery(name="Protocolo.findAll", query="SELECT p FROM Protocolo p")
public class Protocolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long codigo;

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

	public Protocolo() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataAbertura() {
		return this.dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNotaServico() {
		return this.notaServico;
	}

	public void setNotaServico(String notaServico) {
		this.notaServico = notaServico;
	}

	public long getNroInstalacao() {
		return this.nroInstalacao;
	}

	public void setNroInstalacao(long nroInstalacao) {
		this.nroInstalacao = nroInstalacao;
	}

	public String getNroProtocolo() {
		return this.nroProtocolo;
	}

	public void setNroProtocolo(String nroProtocolo) {
		this.nroProtocolo = nroProtocolo;
	}

	public String getNroProtocoloEntrada() {
		return this.nroProtocoloEntrada;
	}

	public void setNroProtocoloEntrada(String nroProtocoloEntrada) {
		this.nroProtocoloEntrada = nroProtocoloEntrada;
	}

	public String getNroProtocoloFechamento() {
		return this.nroProtocoloFechamento;
	}

	public void setNroProtocoloFechamento(String nroProtocoloFechamento) {
		this.nroProtocoloFechamento = nroProtocoloFechamento;
	}

	public String getRecebido() {
		return this.recebido;
	}

	public void setRecebido(String recebido) {
		this.recebido = recebido;
	}

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Set<AndamentoProtocolo> getAndamentoProtocolos() {
		return this.andamentoProtocolos;
	}

	public void setAndamentoProtocolos(Set<AndamentoProtocolo> andamentoProtocolos) {
		this.andamentoProtocolos = andamentoProtocolos;
	}

	public AndamentoProtocolo addAndamentoProtocolo(AndamentoProtocolo andamentoProtocolo) {
		getAndamentoProtocolos().add(andamentoProtocolo);
		andamentoProtocolo.setProtocolo(this);

		return andamentoProtocolo;
	}

	public AndamentoProtocolo removeAndamentoProtocolo(AndamentoProtocolo andamentoProtocolo) {
		getAndamentoProtocolos().remove(andamentoProtocolo);
		andamentoProtocolo.setProtocolo(null);

		return andamentoProtocolo;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usina getUsina() {
		return this.usina;
	}

	public void setUsina(Usina usina) {
		this.usina = usina;
	}

}