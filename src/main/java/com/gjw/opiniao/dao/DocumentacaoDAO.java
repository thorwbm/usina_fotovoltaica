package com.gjw.opiniao.dao;

import java.io.Serializable;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Documentacao;

public class DocumentacaoDAO extends GenericoDAO<Documentacao, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<Documentacao> getClasseDaEntidade() {
		return Documentacao.class;
	}

	public Documentacao buscarPorCodigo(Long documentacao_id) {
		StringBuffer sb = new StringBuffer();
		
		sb.append(" Select doc from Documentacao doc join fetch doc.usina usi     ")
		  .append("                             left join fetch doc.documento dct ")
		  .append(" where doc.codigo = :documentacao_id				              ");
		
		return getEntityManager().createQuery(sb.toString(), Documentacao.class)
				.setParameter("documentacao_id", documentacao_id)
				.getSingleResult();
	}

}
