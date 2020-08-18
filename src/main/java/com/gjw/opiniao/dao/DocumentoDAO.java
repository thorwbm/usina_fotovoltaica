package com.gjw.opiniao.dao;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.UserTransaction;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Documento;

public class DocumentoDAO extends GenericoDAO<Documento, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserTransaction transaction;
	
	@Override
	protected Class<Documento> getClasseDaEntidade() {
		return Documento.class;
	}

	public void carga_inicial_documentacao(Long usinaId) throws Exception {
		StoredProcedureQuery sp = getEntityManager().createStoredProcedureQuery("SP_CARGA_INICIAL_DOCUMENTACAO")
				.registerStoredProcedureParameter("USINA_ID", Long.class, ParameterMode.IN)
				.setParameter("USINA_ID", usinaId);
		
		sp.execute();
	}

}
