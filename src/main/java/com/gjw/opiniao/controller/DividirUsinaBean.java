package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.model.Potencia;
import com.gjw.opiniao.model.Usina;
import com.gjw.opiniao.service.PotenciaService;
import com.gjw.opiniao.service.UsinaService;
import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;

@Data
@Named
@ViewScoped
public class DividirUsinaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private UsinaService usinaService;
	
	@Inject
	private PotenciaService potenciaService;
	
	private Usina usina;
	private Potencia potenciaSelecionada;
	private int soma;
	
	private List<Potencia> potencias;
	private List<Potencia> potenciasSelecionadas;
	
	
	public DividirUsinaBean() {
		
	}
	
	
	public void inicializar() {
		
		if(!FacesUtil.isPostback()) {
			if (usina == null) {
				usina = new Usina();
			}
			potencias = potenciaService.listar();
			potenciasSelecionadas = new ArrayList<Potencia>();
			potenciaSelecionada = new Potencia();
		}
		potencias.remove(usina.getPotencia());
	}
		
	public String dividirUsina() {
		String potenciasStr = "";
		
		if(isValidarDivisaoPotencia()) {
			potenciasStr = potenciaService.montarListaPotencia(potenciasSelecionadas);
			usinaService.dividirUsina(usina.getCodigo(), potenciasStr);
			FacesUtil.addInfoMessage("A divisão foi efetuada com sucesso.");
			
			for(Potencia potencia : potenciasSelecionadas) {
				FacesUtil.addInfoMessage("# " + potencia.getNome() + " - " + potencia.getGrandeza());
			return "pesquisaUsina.xhtml?faces-redirect=true";
			}			
		} else {
			FacesUtil.addErroMessage("O somatório das potências selecionadas e diferente da potência a ser dividida.");
		}
		return null;
	}
		 
	 public void removerPotencia(Potencia potencia) {
		 potenciasSelecionadas.remove(potencia);
	 }
	 
	 public void adicionarPotencia() {
		 if (potenciaSelecionada != null) {
			 potenciasSelecionadas.add(potenciaSelecionada);
		 } 
	 }
	 
	 private boolean isValidarDivisaoPotencia() {		 
		 soma = 0;
		 
		 if(potenciasSelecionadas.size() == 0) {
			 return false;
		 } else {
			 for (Potencia potencia : potenciasSelecionadas) {
				 soma = soma + potencia.getNome();
			 }
			 if (soma != usina.getPotencia().getNome()) {
				 return false;
			 }
		 }	 
		 
		 return true;
	 }
	 
	 
	 
}
