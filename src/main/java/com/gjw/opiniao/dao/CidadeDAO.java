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

	public Cidade buscaCidade(String cidadeNome, String siglaEstado) {
		StringBuffer sb = new StringBuffer();
		sb.append(" Select cid from Cidade cid join fetch cid.estado est        ")
		  .append("  Where est.sigla = :siglaEstado and cid.nome = :cidadeNome  ")
		  .append("  order by est.sigla, cid.nome                               ");
		
		return getEntityManager().createQuery(sb.toString(),Cidade.class)
				.setParameter("siglaEstado", siglaEstado)
				.setParameter("cidadeNome", cidadeNome)
				.getSingleResult(); 
		
	}

}
