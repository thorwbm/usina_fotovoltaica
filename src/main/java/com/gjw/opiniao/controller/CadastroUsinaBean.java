package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Cidade;
import com.gjw.opiniao.model.Consorcio;
import com.gjw.opiniao.model.Estado;
import com.gjw.opiniao.model.Potencia;
import com.gjw.opiniao.model.SituacaoProcesso;
import com.gjw.opiniao.model.Usina;
import com.gjw.opiniao.service.CidadeService;
import com.gjw.opiniao.service.ConsorcioService;
import com.gjw.opiniao.service.DocumentoService;
import com.gjw.opiniao.service.EstadoService;
import com.gjw.opiniao.service.PotenciaService;
import com.gjw.opiniao.service.UsinaService;
import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;

@Data
@Named
@ViewScoped
public class CadastroUsinaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private UsinaService usinaService;
	
	@Inject
	private ConsorcioService consorcioService;
	
	@Inject
    private PotenciaService potenciaService;
	
	@Inject
	private CidadeService cidadeService;
	
	@Inject
	private DocumentoService documentoService;
	
	@Inject
	private EstadoService	estadoService;
	
	private Usina usina; 
	private Cidade cidade;
	private Estado estadoSelecionado;
	
	private List<Estado> estados;
	private List<Consorcio> consorcios;
	private List<Consorcio> comodatos;
	private List<Usina> usinas;
	private List<SituacaoProcesso> situacoesPprocesso;
	private List<Potencia> potencias;

	String situacao = null;
	
	public CadastroUsinaBean() {
		
	}
	
	@PostConstruct
	public void inicializar() {
		
		if(!FacesUtil.isPostback()) {
			estadoSelecionado = new Estado();
			usina = new Usina();
			estados = new ArrayList<Estado>();
			
			estadoSelecionado = estadoService.pesquisarPorCodigo(13L);
			
			usina.setSituacao(SituacaoProcesso.ATIVO);
			usina.getCidade().setEstado(estadoSelecionado);
			
			consorcios = consorcioService.listar();
			comodatos = consorcioService.listar();
			usinas = usinaService.listar();
			situacoesPprocesso =  Arrays.asList(SituacaoProcesso.values());
			potencias = potenciaService.listar();
			estados = estadoService.listar();
			
		}
	}
	
	public boolean isEditando() {		
		boolean teste = (usina) != null;
		situacao = "inserido";
		
		if(teste) {
			teste =  ((Object) usina.getCodigo()) != null;
			if(teste) {
				situacao = "editado";
			}
		}
		return teste;
	}
	
	public String salvar() {
		cidade = cidadeService.buscaCidade(usina.getCidade().getNome(), usina.getCidade().getEstado().getSigla());
		
		try {
			if (cidade !=null) {			
				usina.setDataInicio(new Date());
				usina.setCidade(cidade);
				usina = usinaService.salvar(usina);
				if(situacao == "inserido") {
					documentoService.cadastrarDocomentos(usina.getCodigo());
				}
				
				FacesUtil.addInfoMessage("A usina [" + usina.getNome() + "] foi " + situacao + " com sucesso.");
				return "pesquisaUsina.xhtml?faces-redirect=true";
			} else {
				FacesUtil.addErroMessage("O par Cidade / Estado não existe cadastrado neste sistema.");
				return null;
			}
		} catch (Exception e) {
			FacesUtil.addErroMessage("Ocorreu um problema durante o cadastro.");
			return null;
		}
	}
	
	public boolean isUsinaParticionada() {
		return usina.getUsinas().size() > 0;
	}
	
	public boolean isUsinaTemProtocolo() {
		return usina.getProtocolos().size() > 0;
	}
}
