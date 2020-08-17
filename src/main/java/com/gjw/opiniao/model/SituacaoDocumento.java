package com.gjw.opiniao.model;


public enum SituacaoDocumento {
	
	APROVADO  ("DOCUMENTACAO", "Aprovado"  ,"#008000"),
	REPROVADO ("DOCUMENTACAO", "Reprovado" ,"#008000"),
	PENDENTE  ("DOCUMENTACAO", "Pendente"  ,"#008000"),
	DISPENSADO("DOCUMENTACAO", "Dispensado","#008000"),
	PRONTO    ("FORMULARIO"  , "Pronto"    ,"#008000"),
	AGUARDANDO("FORMULARIO"  , "Aguardando","#008000"),
	ASSINATURA("FORMULARIO"  , "Assinatura","#008000");
	
	private String descricao;
	private String tipo;
	private String cor;
	
	SituacaoDocumento(String tipo, String descricao, String cor){
		this.descricao = descricao;
		this.tipo = tipo;
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public String getCor() {
		return cor;
	}
	
}
