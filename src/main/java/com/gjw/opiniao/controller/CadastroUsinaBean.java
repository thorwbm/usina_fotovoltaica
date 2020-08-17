package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Consorcio;
import com.gjw.opiniao.model.SituacaoProcesso;
import com.gjw.opiniao.model.TipoDocumento;
import com.gjw.opiniao.model.Usina;
import com.gjw.opiniao.service.ConsorcioService;
import com.gjw.opiniao.service.UsinaService;
import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;

@Data
@Named
@ViewScoped
public class CadastroUsinaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private UsinaService usinaService;
	
	@Inject
	private ConsorcioService consorcioService;
	
	private Usina usina; 
	private List<Consorcio> consorcios;
	private List<Usina> usinas;
	private List<SituacaoProcesso> situacoesPprocesso;

	String situacao = null;
	
	public CadastroUsinaBean() {
		
	}
	
	@PostConstruct
	public void inicializar() {
		if(!FacesUtil.isPostback()) {
			usina = new Usina();
			consorcios = consorcioService.listar();
			usinas = usinaService.listar();
			situacoesPprocesso =  Arrays.asList(SituacaoProcesso.values());
			
		}
	}
	
	public boolean isEditando() {		
		boolean teste = (usina) != null;
		situacao = "inserido";
		
		if(teste) {
			teste =  ((Object) usina.getCodigo()) != null;
			if(teste) {
				situacao = "editado";
			}
		}
		return teste;
	}
	
	public String salvar() {
		usina = usinaService.salvar(usina);
		FacesUtil.addInfoMessage("A usina [" + usina.getNome() + "] foi " + situacao + " com sucesso.");
		return "pesquisaEmpresa.xhtml?faces-redirect=true";
	}
}
