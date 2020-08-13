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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long codigo;

	@Column(name="alterado_em")
	private Timestamp alteradoEm;

	@Column(name="criado_em")
	private Timestamp criadoEm;

	private String email;

	private String login;
	
	private String nome;

	private String senha;

	private String status;

	private String telefone;

	@Column(name="ultimo_acesso")
	private Timestamp ultimoAcesso;

	//bi-directional many-to-one association to Endereco
	@ManyToOne
	private Endereco endereco;

	//bi-directional many-to-many association to Grupo
	@ManyToMany
	@JoinTable(
		name="usuario_grupo"
		, joinColumns={
			@JoinColumn(name="usuario_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="grupo_id")
			}
		)
	private Set<Grupo> grupos;
	
}