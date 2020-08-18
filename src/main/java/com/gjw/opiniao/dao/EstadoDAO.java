package com.gjw.opiniao.dao;

import java.io.Serializable;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Estado;

public class EstadoDAO extends GenericoDAO<Estado, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<Estado> getClasseDaEntidade() {
		return Estado.class;
	}

}
