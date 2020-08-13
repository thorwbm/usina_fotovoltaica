package com.gjw.opiniao.filter;

import java.io.Serializable;

import com.gjw.opiniao.model.Estado;

import lombok.Data;

@Data
public class CidadeFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Estado estado;
	
	private String nome;
	
	private int codigoIbge;
}
