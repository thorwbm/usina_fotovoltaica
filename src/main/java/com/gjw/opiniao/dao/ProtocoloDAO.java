package com.gjw.opiniao.dao;

import java.io.Serializable;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Protocolo;

public class ProtocoloDAO extends GenericoDAO<Protocolo, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<Protocolo> getClasseDaEntidade() {
		return Protocolo.class;
	}

}
