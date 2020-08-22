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
	private Long codigo;
	
	private String nome;
	
	@Column(name="cpf_cnpj")
	private String cpfCnpj;
	
	@Column(name="estado_civil")
	private String estadoCivil;
	
	private String identidade;

	private String logradouro;

	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	//bi-directional many-to-one association to Cidade
	@ManyToOne
	private Cidade cidade;

	//bi-directional many-to-one association to Consorcio
	@OneToMany(mappedBy="responsavel")
	private Set<Consorcio> consorcios;

	public Responsavel() {
	}
	
}