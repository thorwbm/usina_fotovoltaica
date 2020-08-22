package com.gjw.opiniao.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the consorcio database table.
 * 
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="consorcio")
@NamedQuery(name="Consorcio.findAll", query="SELECT c FROM Consorcio c")
public class Consorcio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long codigo;
	
	private String nome;

	@Column(name="cpf_cnpj")
	private String cpfCnpj;

	private long identificador;

	private String logradouro;

	private String numero;
	
	private String cep;
	
	private String complemento;
	
	private String bairro;
	
	private String contato;
	
	private String email;

	private String site;

	private String telefone;
	
	//bi-directional many-to-one association to Responsavel
	@ManyToOne
	private Responsavel responsavel;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	private Cidade cidade = new Cidade();

	//bi-directional many-to-one association to Usina
	@OneToMany(mappedBy="consorcio")
	private Set<Usina> usinas = new HashSet<Usina>();

	public Consorcio() {
	}

	
}