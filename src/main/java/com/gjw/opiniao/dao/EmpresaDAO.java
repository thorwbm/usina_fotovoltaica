package com.gjw.opiniao.dao;

import java.io.Serializable;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Empresa;

public class EmpresaDAO  extends GenericoDAO<Empresa, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<Empresa> getClasseDaEntidade() {
		return Empresa.class;
	}

}
