package com.gjw.opiniao.model;


public enum SituacaoDocumentacao {
	
	AGUARDANDO   ("Aguardando"   ,"#ffdfba","cor_larajna"),//  laranja 
	APROVADO     ("Aprovado"     ,"#baffc9","cor_verde"), // verde 
	ENVIADO      ("Enviado"      ,"#bae1ff","cor_azul"), // azul 
	NAO_SE_APLICA("Não se Aplica","#F8F8FF","cor_neutra"),  
	PENDENTE     ("Pendente"     ,"#ffffba","cor_amarela"), // amarelo 
	REPROVADO    ("Reprovado"    ,"#ffb3ba","cor_vermelho"); // vermelho 
	
	private String descricao;
	private String cor;
	private String cor_css;
	
	SituacaoDocumentacao( String descricao, String cor, String cor_css){
		this.descricao = descricao;
		this.cor = cor;
		this.cor_css = cor_css;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCor() {
		return cor;
	}

	public String getCor_css() {
		return cor_css;
	}

	
}
