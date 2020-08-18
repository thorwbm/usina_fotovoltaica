package com.gjw.opiniao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@Table(name="grupo")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long codigo;

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

	public Grupo() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Permissao> getPermissoes() {
		return this.permissoes;
	}

	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}