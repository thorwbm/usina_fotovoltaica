package com.gjw.opiniao.dao;

import java.io.Serializable;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Cidade;

public class CidadeDAO extends GenericoDAO<Cidade, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<Cidade> getClasseDaEntidade() {
		return Cidade.class;
	}



}
