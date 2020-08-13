package com.gjw.opiniao.dao;

import java.io.Serializable;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Grupo;

public class GrupoDAO extends GenericoDAO<Grupo, Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Class<Grupo> getClasseDaEntidade() {
		return Grupo.class;
	}
	
}
