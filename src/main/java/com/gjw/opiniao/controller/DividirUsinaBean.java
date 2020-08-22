package com.gjw.opiniao.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.UnselectEvent;

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
	
	private List<Potencia> potencias;
	private List<Potencia> potenciasSelecionadas;
	
	public DividirUsinaBean() {
		
	}
	
	@PostConstruct
	public void inicializar() {
		
		if(!FacesUtil.isPostback()) {
			usina = new Usina();
			potencias = potenciaService.listar();
			potenciasSelecionadas = new ArrayList<Potencia>();
		}
	}
	
	public String dividirUsina() {
		
		return null;
	}
	
	 public void onItemUnselect(UnselectEvent event) {
	        FacesContext context = FacesContext.getCurrentInstance();
	         
	        FacesMessage msg = new FacesMessage();
	        msg.setSummary("Item unselected: " + event.getObject().toString());
	        msg.setSeverity(FacesMessage.SEVERITY_INFO);
	         
	        context.addMessage(null, msg);
	    }
}
