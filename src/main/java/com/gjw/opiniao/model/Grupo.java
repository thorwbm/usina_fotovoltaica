package com.gjw.opiniao.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="grupo")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long codigo;

	private String descricao;

	private String nome;

	//bi-directional many-to-many association to Permissao
	@ManyToMany
	@JoinTable(
		name="grupo_permissao"
		, joinColumns={
			@JoinColumn(name="grupo_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="permissao_id")
			}
		)
	private Set<Permissao> permissoes;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="grupos")
	private Set<Usuario> usuarios;

	

}