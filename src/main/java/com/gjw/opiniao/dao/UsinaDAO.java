package com.gjw.opiniao.dao;

import java.io.Serializable;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Usina;

public class UsinaDAO extends GenericoDAO<Usina, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<Usina> getClasseDaEntidade() {
		return Usina.class;
	}

}
