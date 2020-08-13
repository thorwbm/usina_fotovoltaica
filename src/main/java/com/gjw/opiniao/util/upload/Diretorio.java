package com.gjw.opiniao.util.upload;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public enum Diretorio {
	
	IMAGEM("imagem"),
	GABARITOCANDIDATO("gabarito\\candidato"),
	GABARITOPROVA("gabarito\\prova"),
	GABARITORESPOSTA("gabarito\\resposta"),
	AVALICAO("avaliacao"),
	RECURSO("recurso"),
	INSCRICAO("inscricao"),
	RELATORIO("relatorio"),	
	RETORNO("retorno"),
	PROVA("prova"),
	EDITAL("edital"),
	VAGA("vaga");
	
	private String descricao;
	
	private Diretorio(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return recuperarCaminho() + descricao + File.separator;
	}
		
	private String recuperarCaminho() {
		Properties props = new Properties();
		
		try {
			props.load(getClass().getResourceAsStream("/caminho.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return props.getProperty("caminho").replace("\\", File.separator);
	}
	
}
