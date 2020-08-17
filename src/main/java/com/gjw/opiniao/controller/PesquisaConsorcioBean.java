package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Consorcio;
import com.gjw.opiniao.service.ConsorcioService;
import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;

@Data
@Named
@ViewScoped
public class PesquisaConsorcioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ConsorcioService consorcioService;

	private List<Consorcio> consorcios;
	
	private Consorcio consorcioSelecionado;
	
	/**************************************** INICIALIZAR  ******************************************************************************/
	public PesquisaConsorcioBean() {
		consorcios = new ArrayList<Consorcio>();
	}
	
	public void limpar() {
		consorcios = consorcioService.listar();
	}
	
	@PostConstruct
	public void inicializar() {
		
		limpar();
		if(!FacesUtil.isPostback()){
			limpar();
		}
	}
	/**************************************** INICIALIZAR  ******************************************************************************/
	
	public void excluir(Long consorcioId) {
		consorcioService.excluir(consorcioId);
		limpar();
	}
}
