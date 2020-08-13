package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Cidade;
import com.gjw.opiniao.service.CidadeService;

import lombok.Data;


@Data
@Named
@ViewScoped
public class PesquisaCidadeBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CidadeService cidadeService;
	
	private List<Cidade> cidades;
	
	//******************************************  INICIALIZAR  *************************************************************************
		public PesquisaCidadeBean() {
			
		}
	
		@PostConstruct
		public void inicializar(){
			cidades = cidadeService.listar();
		}
		
		public void  limpar(){
			cidades = cidadeService.listar();
		}

		public List<Cidade> getCidades() {
			return cidades;
		}

		public void setCidades(List<Cidade> cidades) {
			this.cidades = cidades;
		}
		
		
		
}
