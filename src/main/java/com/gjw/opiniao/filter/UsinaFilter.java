package com.gjw.opiniao.filter;

import java.io.Serializable;

import com.gjw.opiniao.model.Consorcio;

import lombok.Data;

@Data
public class UsinaFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Consorcio consorcio;
	private String nome;
	
}
