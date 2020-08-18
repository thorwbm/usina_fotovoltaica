package com.gjw.opiniao.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;


/**
 * The persistent class for the documento database table.
 * 
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="documento")
@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long codigo;

	private String descricao;

	private String nome;

	private int obrigatorio;

	@Enumerated(EnumType.STRING)
	private TipoDocumento tipo;

	//bi-directional many-to-one association to Documentacao
	@OneToMany(mappedBy="documento")
	private Set<Documentacao> documentacoes;

	//bi-directional many-to-one association to Formulario
	@OneToMany(mappedBy="documento")
	private Set<Formulario> formularios;

	public Documento() {
	}

}