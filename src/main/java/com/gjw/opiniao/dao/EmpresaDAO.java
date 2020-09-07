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

	public Empresa buscarPorNome(String empresaNome) {
		StringBuffer sb = new StringBuffer();
		
		sb.append(" select emp from Empresa emp where emp.nome = :empresaNome ");
		
		return getEntityManager().createQuery(sb.toString(),Empresa.class)
				.setParameter("empresaNome", empresaNome)
				.getSingleResult();
	}

}
