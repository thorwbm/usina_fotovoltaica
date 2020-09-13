package com.gjw.opiniao.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.gjw.opiniao.dao.UtilitarioDAO;

public class UtilitarioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UtilitarioDAO utilitarioDao;
	
	public void fazerBacup() {
		utilitarioDao.fazerbackup();
	}
}
