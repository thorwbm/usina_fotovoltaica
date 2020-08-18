package com.gjw.opiniao.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.gjw.opiniao.dao.PotenciaDAO;
import com.gjw.opiniao.model.Potencia;

public class PotenciaService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private PotenciaDAO potenciaDao;
	
	public List<Potencia> listar(){
		return potenciaDao.listar("nome", "asc");
	}
	
}
