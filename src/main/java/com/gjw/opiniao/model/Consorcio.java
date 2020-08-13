package com.gjw.opiniao.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;


/**
 * The persistent class for the consorcio database table.
 * 
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="consorcio")
@NamedQuery(name="Consorcio.findAll", query="SELECT c FROM Consorcio c")
public class Consorcio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long codigo;

	@Column(name="cpf_cnpj")
	private String cpfCnpj;

	private long identificador;

	private String nome;

	//bi-directional many-to-one association to Endereco
	@ManyToOne
	private Endereco endereco;

	//bi-directional many-to-one association to Responsavel
	@ManyToOne
	private Responsavel responsavel;

	//bi-directional many-to-one association to Usina
	@OneToMany(mappedBy="consorcio")
	private Set<Usina> usinas;


}