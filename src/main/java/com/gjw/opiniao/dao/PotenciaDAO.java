package com.gjw.opiniao.dao;

import java.io.Serializable;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Potencia;

public class PotenciaDAO extends GenericoDAO<Potencia, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<Potencia> getClasseDaEntidade() {
		return Potencia.class;
	}

}

