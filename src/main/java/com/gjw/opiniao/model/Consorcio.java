package com.gjw.opiniao.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * The persistent class for the consorcio database table.
 * 
 */
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="consorcio")
@NamedQuery(name="Consorcio.findAll", query="SELECT c FROM Consorcio c")
public class Consorcio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long codigo;

	@Column(name="cpf_cnpj")
	private String cpfCnpj;

	private long identificador;

	private String nome;

	private String email;
	
	private String telefone;
	
	private String contato;	
	
	//bi-directional many-to-one association to Endereco
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Endereco endereco = new Endereco();

	//bi-directional many-to-one association to Responsavel
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Responsavel responsavel ;

	//bi-directional many-to-one association to Usina
	@OneToMany(mappedBy="consorcio")
	private Set<Usina> usinas ;


}