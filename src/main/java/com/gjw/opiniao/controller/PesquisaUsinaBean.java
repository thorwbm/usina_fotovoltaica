package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.filter.UsinaFilter;
import com.gjw.opiniao.model.Consorcio;
import com.gjw.opiniao.model.Usina;
import com.gjw.opiniao.service.ConsorcioService;
import com.gjw.opiniao.service.UsinaService;
import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;

@Data
@Named
@ViewScoped
public class PesquisaUsinaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private UsinaService usinaService;
	
	@Inject
	private ConsorcioService consorcioService;
	
	private Usina usinaSelecionada;
	private UsinaFilter usinaFilter;
	
	private List<Usina> usinas;
	private List<Consorcio> consorcios;
	

	/**************************************** INICIALIZAR  ******************************************************************************/
	public PesquisaUsinaBean() {
		
		usinas = new ArrayList<Usina>();
	}
	
	@PostConstruct
	public void inicializar() {
		
		limpar(); 
		if(!FacesUtil.isPostback()){
			consorcios = consorcioService.listar();
			usinaFilter = new UsinaFilter();
			
		}
	}
	
	public void limpar() {
		usinas = usinaService.listar();
	}
	/**************************************** INICIALIZAR  ******************************************************************************/

	public void excluir(Long usinaId) {
		usinaService.excluir(usinaId);
		limpar();
	}
	
	public void pesquisar() {
		usinas = usinaService.pesquisar(usinaFilter);
	}
	
			
}
