package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Empresa;
import com.gjw.opiniao.model.Protocolo;
import com.gjw.opiniao.model.Usina;
import com.gjw.opiniao.service.EmpresaService;
import com.gjw.opiniao.service.ProtocoloService;
import com.gjw.opiniao.service.UsinaService;
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
	
	@Inject
	private UsinaService usinaService;
	
	private Protocolo protocolo;
	private Usina usina;
	private Empresa empresaSelecionada;
	private List<Empresa> empresas;
	
	public ProtocoloUsinaBean() {
		 
	}
	
	@PostConstruct
	public void inicializar() {
		if (!FacesUtil.isPostback()) {
			protocolo = new Protocolo();
			empresas = empresaService.listar();
			empresaSelecionada = empresaService.buscarPorNome("CEMIG");
		}
		
	}
	
	public void adicionarProtocolo() {
		List<String> erros = new ArrayList<String>();
		
		erros = validarCadastroProtocolo(protocolo);
		
		if (erros.size() > 0) {
			for (String erro : erros) {
				FacesUtil.addErroMessage("O campo " + erro + " é obrigatorio.");
			}
			
		} else {
			protocolo.setEmpresa(empresaSelecionada);
			protocolo.setUsina(usina);
			protocolo.setDataAbertura(new Date());
			usina.getProtocolos().add(protocolo);
			protocolo = new Protocolo();
			empresaSelecionada = new Empresa();
		}
		
	}
	
	private List<String> validarCadastroProtocolo(Protocolo protocolo) {
		List<String> erros = new ArrayList<String>();
		
		if(protocolo.getEmpresa() == null) {
			erros.add("Empresa");
		}
		
		if(protocolo.getNotaServico().equals("")) {
			erros.add("Nota de serviço");
		}
		
		if(protocolo.getNroInstalacao() == 0) {
			erros.add("Número de Instalação");
		}
		
		if(protocolo.getNroProtocolo().equals("")) {
			erros.add("Número do Protocolo");
		}
		
		if(protocolo.getNroProtocoloEntrada().equals("")) {
			erros.add("Número do Protocolo de Entrada");
		}
		
			
		
		return erros;
	}
	
	
	public void removerProtocolo(Protocolo protocolo) {
		usina.getProtocolos().remove(protocolo);
	}
	
	public String salvar() {
		
		 usina = usinaService.salvar(usina);
		 FacesUtil.addInfoMessage("Os protocolos para a usina [" + usina.getNome() + "] foram atualizados com sucesso!");
		 return "cadastroUsina.xhtml?usina=" + usina.getCodigo().toString() + "&faces-redirect=true";
	}

}
