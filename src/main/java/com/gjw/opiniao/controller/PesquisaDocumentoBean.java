package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Documento;
import com.gjw.opiniao.service.DocumentoService;
import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;

@Data
@Named
@ViewScoped
public class PesquisaDocumentoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DocumentoService documentoService;
	
	private List<Documento> documentos;
	
	private Documento documentoSelecionado;
	
	/**************************************** INICIALIZAR  ******************************************************************************/
	public PesquisaDocumentoBean() {
		documentos = new ArrayList<Documento>();
	}
	
	public void limpar() {
		documentos = documentoService.listar();
	}
	
	@PostConstruct
	public void inicializar() {
		
		limpar();
		if(!FacesUtil.isPostback()){
			limpar();
		}
	}
	/**************************************** INICIALIZAR  ******************************************************************************/
	
	public void excluir(Long documentoId) {
		documentoService.excluir(documentoId);
		limpar();
	}

}
