package com.gjw.opiniao.dao;

import java.io.Serializable;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Documento;

public class DocumentoDAO extends GenericoDAO<Documento, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<Documento> getClasseDaEntidade() {
		return Documento.class;
	}


}
