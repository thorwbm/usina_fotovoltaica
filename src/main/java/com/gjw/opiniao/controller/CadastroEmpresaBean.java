package com.gjw.opiniao.controller;

import java.io.Serializable;

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
public class CadastroEmpresaBean  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaService empresaService;
	
	private Empresa empresa;

	String situacao = null;
	
	public CadastroEmpresaBean() {
		empresa = new Empresa(); 
	}

	public String salvar() {
		String situacao = "adicionada";
		
		if (isEditando()) {
			situacao = "editada";
		}
		
		empresa = empresaService.salvar(empresa);
		FacesUtil.addInfoMessage("A empresa [" + empresa.getNome() + "] foi " + situacao + " com sucesso.");
		return "pesquisaEmpresa.xhtml?faces-redirect=true";
	}
	
	public boolean isEditando() {		
		boolean teste = (empresa) != null;
		situacao = "inserido";
		
		if(teste) {
			teste =  ((Object) empresa.getCodigo()) != null;
			if(teste) {
				situacao = "editado";
			}
		}
		return teste;
	}
}
