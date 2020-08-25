package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Empresa;
import com.gjw.opiniao.model.Protocolo;
import com.gjw.opiniao.model.Usina;
import com.gjw.opiniao.service.EmpresaService;
import com.gjw.opiniao.service.ProtocoloService;
import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;

@Data
@Named
@ViewScoped
public class ProtocoloUsinaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProtocoloService protocoloService;
	
	@Inject
	private EmpresaService empresaService;
	
	private Protocolo protocolo;
	private Usina usina;
	private List<Empresa> empresas;
	
	public ProtocoloUsinaBean() {
		
	}
	
	public void inicializar() {
		if (!FacesUtil.isPostback()) {
			protocolo = new Protocolo();
			empresas = empresaService.listar();
		}
		
	}
	
	public void adicionarPprotocolo() {
		protocolo.setUsina(usina);
		usina.getProtocolos().add(protocolo);
		protocolo = new Protocolo();
	}
	
	public void removerProtocolo(Protocolo protocolo) {
		usina.getProtocolos().remove(protocolo);
	}
	
	public String Salvar() {
		return null; 
	}

}
