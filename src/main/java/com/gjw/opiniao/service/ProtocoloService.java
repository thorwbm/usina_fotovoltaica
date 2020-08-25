package com.gjw.opiniao.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.gjw.opiniao.dao.ProtocoloDAO;
import com.gjw.opiniao.model.Protocolo;

public class ProtocoloService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ProtocoloDAO protocoloDao;
	
	public List<Protocolo> listar(){
		return protocoloDao.listar("nome", "asc");
	}
}
