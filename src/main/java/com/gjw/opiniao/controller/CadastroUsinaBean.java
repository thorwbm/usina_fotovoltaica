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
import com.gjw.opiniao.model.Documentacao;
import com.gjw.opiniao.model.Documento;
import com.gjw.opiniao.model.Estado;
import com.gjw.opiniao.model.Potencia;
import com.gjw.opiniao.model.SituacaoDocumentacao;
import com.gjw.opiniao.model.SituacaoProcesso;
import com.gjw.opiniao.model.Usina;
import com.gjw.opiniao.service.CidadeService;
import com.gjw.opiniao.service.ConsorcioService;
import com.gjw.opiniao.service.DocumentacaoService;
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
	private DocumentacaoService documentacaoService;
	
	@Inject
	private EstadoService	estadoService;
	
	private Usina usina; 
	private Cidade cidade;
	private Estado estadoSelecionado;
	private Documento documentoSelecionado;
	
	private List<Documento> documentos;
	private List<Estado> estados;
	private List<Consorcio> consorcios;
	private List<Consorcio> comodatos;
	private List<Usina> usinas;
	private List<SituacaoProcesso> situacoesPprocesso;
	private List<Potencia> potencias;

	private List<Cidade> cidades;

	String situacao = null;
	
	public CadastroUsinaBean() {
		
	}
	
	@PostConstruct
	public void inicializar() {
		
		if(!FacesUtil.isPostback()) {
			estadoSelecionado = new Estado();
			usina = new Usina();
			estados = new ArrayList<Estado>();
			documentos = new ArrayList<Documento>();
			documentoSelecionado = new Documento();
			
			estadoSelecionado = estadoService.pesquisarPorCodigo(13L);
			cidades = cidadeService.buscarCidades(estadoSelecionado);
			
			usina.setSituacao(SituacaoProcesso.ATIVO);
			
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
		carregarDocumento();
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
	
	public boolean isUsinaTemParticionamento() {
		return usina.getUsinas().size() > 0;
	}

	public boolean isUsinaTemDocumentacao() {
		return usina.getDocumentacoes().size() > 0;
	}
	
	public boolean isUsinaTemProtocolo() {
		return usina.getProtocolos().size() > 0;
	}
	
	private void carregarDocumento() {
		documentos = documentoService.listar();
		
		for (Documentacao documentacao : usina.getDocumentacoes()) {			
			documentos.remove(documentacao.getDocumento());
		}
	}
	
	public void adicionarDocumento() {
		
		if(documentoSelecionado != null) {
			
			Documentacao doc = new Documentacao();
			doc.setDataCriacao(new Date());
			doc.setUsina(usina);
			doc.setDocumento(documentoSelecionado);
			doc.setSituacao(SituacaoDocumentacao.AGUARDANDO);			
			
			usina.getDocumentacoes().add(doc);
			usina = usinaService.salvar(usina);
			
			usina = usinaService.buscarPorCodigo(usina.getCodigo());
			carregarDocumento();
		}
	}
	
	public void excluirDocuemntacao(Documentacao doc) {
		usina.getDocumentacoes().remove(doc);
		//Documentacao doc = documentacaoService.pesquisarPorId(documentacao.getCodigo());
		
		documentacaoService.excluir(doc.getCodigo());
		//usina = usinaService.salvar(usina);
		usina = usinaService.buscarPorCodigo(usina.getCodigo());
		carregarDocumento();
				
	}
	
	public void listarCidades() {
		cidades = cidadeService.buscarCidades(estadoSelecionado);
	}
}
