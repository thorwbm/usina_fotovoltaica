package com.gjw.opiniao.dao;

import java.io.Serializable;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Consorcio;

public class ConsorcioDAO  extends GenericoDAO<Consorcio, Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Class<Consorcio> getClasseDaEntidade() {
		return Consorcio.class;
	}
	
	public Consorcio buscarPorCodigo(Long codigoConsorcio) {
		StringBuffer sb = new StringBuffer();
		
		sb.append(" Select con from Consorcio con                                     ")
		  .append("                               left join fetch con.responsavel res ")
		  .append("                               left join fetch con.cidade      cid ")
		  .append("                               left join fetch cid.estado      est ")
		  .append("                               left join fetch con.usinas      usi ")
		  .append("  where  con.codigo = :codigoConsorcio                             ");
		  
		return getEntityManager().createQuery(sb.toString(), Consorcio.class)
			.setParameter("codigoConsorcio", codigoConsorcio).getSingleResult();
	}
	
}
