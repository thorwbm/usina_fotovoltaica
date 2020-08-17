package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Empresa;
import com.gjw.opiniao.service.EmpresaService;
import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;

@Data
@Named
@ViewScoped
public class PesquisaEmpresaBean  implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Inject
	private EmpresaService empresaService;
	
	private List<Empresa> empresas;
	private Empresa empresaSelecionada;
	
	/**************************************** INICIALIZAR  ******************************************************************************/
	public PesquisaEmpresaBean() {
		
		empresas = new ArrayList<Empresa>();
	}
	
	@PostConstruct
	public void inicializar() {
		
		limpar(); 
		if(!FacesUtil.isPostback()){
			limpar();
		}
	}
	
	public void limpar() {
		empresas = empresaService.listar();
	}
	/**************************************** INICIALIZAR  ******************************************************************************/
	
	public void excluir(Long empresaId) {
		empresaService.excluir(empresaId);
		limpar();
	}
		
}
