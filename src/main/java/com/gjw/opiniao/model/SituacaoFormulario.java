package com.gjw.opiniao.model;

public enum SituacaoFormulario {
	
	PRONTO    ( "Pronto"    ,"#008000"),
	AGUARDANDO( "Aguardando","#008000"),
	ASSINATURA( "Assinatura","#008000");
	
	private String descricao;
	private String cor;
	
	SituacaoFormulario(String descricao, String cor) {
		this.descricao = descricao;
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCor() {
		return cor;
	}
	
	
}
