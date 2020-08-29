package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Empresa;
import com.gjw.opiniao.model.Protocolo;
import com.gjw.opiniao.service.EmpresaService;
import com.gjw.opiniao.service.ProtocoloService;
import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;

@Data
@Named
@ViewScoped
public class CadastroProtocoloBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ProtocoloService protocoloService;
	
	@Inject
	private EmpresaService empresaService;
	
	private Protocolo protocolo;
	private Empresa empresaSelecionada;
	
	private List<Empresa> empresas;
	
	public CadastroProtocoloBean() {
		
	}
	

	@PostConstruct
	public void inicializar() {
		if(!FacesUtil.isPostback()) {
			protocolo = new Protocolo();
			empresaSelecionada = new Empresa();
			empresas = empresaService.listar();
		}
	}
	
	public String salvar() {
		protocolo = protocoloService.salvar(protocolo);
		
		return "/usina/usina/cadastroUsina.xhtml?usina=" + protocolo.getUsina().getCodigo() + "&faces-redirect=true";
	}
}
