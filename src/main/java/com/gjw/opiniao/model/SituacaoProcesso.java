package com.gjw.opiniao.model;

public enum SituacaoProcesso {
	APROVADO  ("Aprovado"  ,"#008000"),
	ATIVO     ("Ativo"     ,"#008000"),
	CANCELADO ("Cancelado" ,"#008000"),
	REENVIADO ("Reenviado" ,"#008000"),
	REPROVADO ("Reprovado" ,"#008000");
	
	private String descricao;

	private String cor;
	
	SituacaoProcesso(String descricao, String cor){
		
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
