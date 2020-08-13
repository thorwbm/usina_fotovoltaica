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
	
	public CadastroEmpresaBean() {
		empresa = new Empresa(); 
	}

	public String salvar() {
		empresa = empresaService.salvar(empresa);
		FacesUtil.addInfoMessage("A empresa " + empresa.getNome() + " foi cadastrada com sucesso.");
		return "pesquisaEmpresa.xhtml?faces-redirect=true";
	}
	
	public boolean isEditando() {
		
		boolean teste = (empresa) != null;
			if(teste) {
				teste =  ((Object) empresa.getCodigo()) != null;
			}
		return teste;
	}
}
