package com.gjw.opiniao.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.gjw.opiniao.dao.EstadoDAO;
import com.gjw.opiniao.model.Estado;

public class EstadoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EstadoDAO estadoDao;
	
	public List<Estado> listar(){
		return estadoDao.listar("nome", "asc");
	}

	public Estado pesquisarPorCodigo(Long estadoId) {
		return estadoDao.pesquisarPorCodigo(estadoId);
	}
}
