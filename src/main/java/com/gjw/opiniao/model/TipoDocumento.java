package com.gjw.opiniao.model;

public enum TipoDocumento {
	FORMULARIO("Formulário"),
	DOCUMENTACAO("Documento"),
	OUTROS("Outros");
	
	private String descricao;
	
	TipoDocumento (String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
