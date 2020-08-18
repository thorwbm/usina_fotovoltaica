package com.gjw.opiniao.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Cidade;
import com.gjw.opiniao.model.Consorcio;
import com.gjw.opiniao.model.Estado;
import com.gjw.opiniao.service.CidadeService;
import com.gjw.opiniao.service.ConsorcioService;
import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;


@Data
@Named
@ViewScoped
public class CadastroConsorcioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ConsorcioService consorcioService;
	
	@Inject 
	private CidadeService cidadeService;
	
	private Consorcio consorcio;
	String situacao = null;
	
	private Cidade cidade;
	
	public CadastroConsorcioBean() {
			
	}
	
	@PostConstruct
	public void inicializar() {
		if(!FacesUtil.isPostback()) {
			consorcio = new Consorcio();
			cidade = new Cidade();
		}
	}

	public boolean isEditando() {		
		boolean teste = (consorcio) != null;
		situacao = "inserido";
		
		if(teste) {
			teste =  ((Object) consorcio.getCodigo()) != null;
			if(teste) {
				situacao = "editado";
			}
		}
		return teste;
	}
	
	public String salvar() {				
		if(consorcio.getCep() != null) {
			cidade = buscaCidade(consorcio.getCidade().getNome(), consorcio.getCidade().getEstado().getSigla());
			if (cidade == null) {
				FacesUtil.addErroMessage("O conjunto Estado / Cidade não é válido!");
				return null;
			} else {
				consorcio.setCidade(cidade);
			}
		} 
	
		consorcio = consorcioService.salvar(consorcio);
		FacesUtil.addInfoMessage("O Consórcio [" + consorcio.getNome() + "] foi " + situacao + " com sucesso.");
		return "pesquisaConsorcio.xhtml?faces-redirect=true";
		
	}
	
	public Cidade buscaCidade(String cidadeNome, String siglaEstado) {
		return cidadeService.buscaCidade( cidadeNome,  siglaEstado);
	}
}
