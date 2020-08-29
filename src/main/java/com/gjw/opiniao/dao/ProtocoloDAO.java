package com.gjw.opiniao.dao;

import java.io.Serializable;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Protocolo;

public class ProtocoloDAO extends GenericoDAO<Protocolo, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<Protocolo> getClasseDaEntidade() {
		return Protocolo.class;
	}

	public Protocolo buscarPorCodigo(Long protocoloId) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Select pro from Protocolo pro inner join fetch pro.usina   usi ")
		  .append("                              inner join fetch pro.empresa emp ")
		  .append("  where pro.codigo = :protocoloId ");
		
		return getEntityManager().createQuery(sb.toString(), Protocolo.class)
				.setParameter("protocoloId", protocoloId)
				.getSingleResult();
	}

}
