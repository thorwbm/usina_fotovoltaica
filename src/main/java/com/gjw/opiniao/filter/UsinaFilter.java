package com.gjw.opiniao.filter;

import java.io.Serializable;

import com.gjw.opiniao.model.Consorcio;
import com.gjw.opiniao.model.SituacaoProcesso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsinaFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Consorcio consorcio;
	private String nome;
	private SituacaoProcesso situacao;
	
}
