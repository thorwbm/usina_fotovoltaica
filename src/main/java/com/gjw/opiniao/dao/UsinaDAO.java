package com.gjw.opiniao.dao;

import java.io.Serializable;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Usina;

public class UsinaDAO extends GenericoDAO<Usina, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<Usina> getClasseDaEntidade() {
		return Usina.class;
	}

	public Usina buscarPorCodigo(Long usinaId) {
		StringBuffer sb = new StringBuffer();
		
		sb.append(" Select usi from Usina usi join fetch usi.potencia      pot ")
		  .append("                           join fetch usi.consorcio     con ")
		  .append("                      left join fetch usi.cidade        cid ")
		  .append("                      left join fetch cid.estado        est ")
		  .append("                      left join fetch usi.protocolos    pro ")
		  .append("                      left join fetch usi.documentacoes doc ")
		  .append("                      left join fetch usi.usina_origem  usn ")
		  .append("                      left join fetch usi.usinas        uns ")
		  .append("                      left join fetch usi.comodato      com ")
		  .append(" where usi.codigo = :usinaId");
		
		return getEntityManager().createQuery(sb.toString(), Usina.class)
				.setParameter("usinaId", usinaId)
				.getSingleResult();
	}

	public void dividirUsina(Long usinaId, String potencias) {
		StoredProcedureQuery sp = getEntityManager().createStoredProcedureQuery("SP_SUBDIVIDE_USINA")
				.registerStoredProcedureParameter("POTENCIA", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("USINA_ID", Long.class, ParameterMode.IN)
				.setParameter("POTENCIA", potencias)
				.setParameter("USINA_ID", usinaId);
		
		sp.execute();
		
	}

}
