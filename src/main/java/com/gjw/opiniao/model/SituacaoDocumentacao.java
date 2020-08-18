package com.gjw.opiniao.model;


public enum SituacaoDocumentacao {
	
	AGUARDANDO   ("Aguardando"   ,"#FFE4B5"),//  laranja - orange  #FFE4B5
	APROVADO     ("Aprovado"     ,"#3CB371"), // verde _ medium sea green  #F5F5DC
	ENVIADO      ("Enviado"      ,"#87CEEB"), // azul - sky blue  -- #F0F8FF
	NAO_SE_APLICA("Não se Aplica","#F8F8FF"),  
	PENDENTE     ("Pendente"     ,"#F0E68C"), // amarelo - khaki  #FFFFE0
	REPROVADO    ("Reprovado"    ,"#FA8072"); // vermelho - salmon  #FFDAB9
	
	private String descricao;
	private String cor;
	
	SituacaoDocumentacao( String descricao, String cor){
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
