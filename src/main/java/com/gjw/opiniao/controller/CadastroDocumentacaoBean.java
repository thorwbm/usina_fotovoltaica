package com.gjw.opiniao.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;

import com.gjw.opiniao.model.Documentacao;
import com.gjw.opiniao.model.SituacaoDocumentacao;
import com.gjw.opiniao.service.DocumentacaoService;
import com.gjw.opiniao.util.jsf.FacesUtil;
import com.gjw.opiniao.util.upload.Upload;
import com.gjw.opiniao.util.utilitario.Utilitario;

import lombok.Data;

@Data
@Named
@ViewScoped
public class CadastroDocumentacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DocumentacaoService documentacaoService;
	
	@Inject
	private Upload upload;
	
	private Documentacao documentacao;
	private Documentacao documentacaoTratada;
	private String caminho;
	private String nomeArquivo;
	
	
	private List<SituacaoDocumentacao> situacoesDocumentacao;
	
	 private UploadedFile uploadedFile;
	
	public CadastroDocumentacaoBean() {
		
		
	}
	
	@PostConstruct
	public void inicializar() {		
		if(!FacesUtil.isPostback()){
			documentacao = new Documentacao();
			documentacaoTratada = new Documentacao();
			situacoesDocumentacao  = Arrays.asList(SituacaoDocumentacao.values());	
			
		}
	}
			
	public boolean isEditando() {	

		boolean teste = (documentacao) != null;
			if(teste) {
				teste =  ((Object) documentacao.getCodigo()) != null;
			}
		return teste;
	}
	
	public String salvar() {
		if(nomeArquivo != null) {
			documentacao.setArquivo(nomeArquivo);
		}
		documentacao = documentacaoService.salvar(documentacao);
		FacesUtil.addInfoMessage("O documento [" + documentacao.getDocumento().getNome() + "] da usina [" + documentacao.getUsina().getNome() + "] foi atualizada com sucesso.");
		return "cadastroUsina.xhtml?usina=" + documentacao.getUsina().getCodigo().toString() + "&faces-redirect=true";
	}
	
	public String voltar() {
		return "cadastroUsina.xhtml?usina=" + documentacao.getUsina().getCodigo().toString() + "&faces-redirect=true";		
	}

	public void upload() {
		  String extensao = Utilitario.capturarExtensaoArquivo(uploadedFile.getFileName());
		  try {
			 // UploadedFile uploadedFile = event.getFile();
			  caminho = "d:/arquivos/" + documentacao.getUsina().getConsorcio().getNome().replace(" ", "_") + "/" + documentacao.getUsina().getNome().replace(" ", "_");  
			  nomeArquivo =  documentacao.getUsina().getConsorcio().getCodigo().toString() + "_" 
					  		  + documentacao.getDocumento().getNome().replace(" ", "_") + "_"
		                      + documentacao.getUsina().getNome().replace(" ", "_") + "_" 
				              + (new Random()).nextInt(10000)
				              + "." + extensao; 
			  
			nomeArquivo = nomeArquivo.toLowerCase();
			caminho = caminho.toLowerCase();

			nomeArquivo = Utilitario.removerAcentos(nomeArquivo);
			caminho = Utilitario.removerAcentos(caminho);
				
			Utilitario.criarPasta(caminho);   
				
			
			//	File file = new File( caminho, uploadedFile.getFileName());
				
		    File file = new File(caminho,nomeArquivo);
		 
		    OutputStream out = new FileOutputStream(file);
		    out.write(uploadedFile.getContent());
		    out.close();
		 
		    FacesUtil.addInfoMessage("Upload do arquivo [" + nomeArquivo + "] efetuado com sucesso.");
		  } catch(IOException e) {
		    FacesContext.getCurrentInstance().addMessage(
		              null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
		  }
		 
		}
		
}