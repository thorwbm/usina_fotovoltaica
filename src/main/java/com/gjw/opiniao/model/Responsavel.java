package com.gjw.opiniao.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;


/**
 * The persistent class for the responsavel database table.
 * 
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="responsavel")
@NamedQuery(name="Responsavel.findAll", query="SELECT r FROM Responsavel r")
public class Responsavel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long codigo;

	@Column(name="cpf_cnpj")
	private String cpfCnpj;

	@Column(name="endereco_id")
	private long enderecoId;

	@Column(name="estado_civil")
	private String estadoCivil;

	private String identidade;

	private String nome;

	//bi-directional many-to-one association to Consorcio
	@OneToMany(mappedBy="responsavel")
	private Set<Consorcio> consorcios;

	//bi-directional one-to-one association to Endereco
	@OneToOne
	@JoinColumn(name="id")
	private Endereco endereco;

	

}