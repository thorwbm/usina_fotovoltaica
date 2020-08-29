package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Documento;
import com.gjw.opiniao.model.TipoDocumento;
import com.gjw.opiniao.service.DocumentoService;
import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;

@Data
@Named
@ViewScoped
public class CadastroDocumentoBean  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DocumentoService documentoService;
	
	private Documento documento;
	private String situacao ;
	
	private List<TipoDocumento> tipoDocumentos;
	
	public CadastroDocumentoBean() {
		documento = new Documento();
	}
	
	@PostConstruct
	public void inicializar() {		
		if(!FacesUtil.isPostback()){
			tipoDocumentos  = Arrays.asList(TipoDocumento.values());	
			
		}
	}
			
	public boolean isEditando() {		
		boolean teste = (documento) != null;
		situacao = "adicionando";	
		
		if(teste) {
				teste =  ((Object) documento.getCodigo()) != null;
				situacao = "editando";
			}
		return teste;
	}
	
	public String salvar() {
				
		documento = documentoService.salvar(documento);
		FacesUtil.addInfoMessage("O documento [" + documento.getNome() + "] foi " + situacao + " com sucesso.");
		return "pesquisaDocumento.xhtml?faces-redirect=true";
	}
	

}
