package com.gjw.opiniao.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.service.UtilitarioService;

@Named
@ViewScoped
public class UtilitarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UtilitarioService utilitarioService;
	
	public void fazerBackup() {
		utilitarioService.fazerBacup();
	}
	

}
