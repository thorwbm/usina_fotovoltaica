package com.gjw.opiniao.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.UserTransaction;

import com.gjw.opiniao.dao.generic.GenericoDAO;
import com.gjw.opiniao.model.Usuario;

public class UsuarioDAO extends GenericoDAO<Usuario, Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserTransaction transaction;
	
	protected Class<Usuario> getClasseDaEntidade() {
		return Usuario.class;
	}
	
	public Usuario logar(String login) {
		Usuario usuario = null;
		
		try {
			usuario = getEntityManager().createQuery("from Usuario usu inner join fetch usu.grupos gru "
					                                               + " inner join fetch gru.permissoes per "
					                               + " where usu.login like :login", Usuario.class)
					.setParameter("login", ""+login+"%")
					.getSingleResult();
		} catch (Exception e) {}
		
		return usuario;
	}

	public Usuario recuperarUsuario(Long codigoUsuario) {
		StringBuffer sb = new StringBuffer();
		sb.append("select u from Usuario u inner join fetch u.perfis p ");
		sb.append("where u.codigo = :codigoUsuario");
		
		return getEntityManager().createQuery(sb.toString(), Usuario.class)
				.setParameter("codigoUsuario", codigoUsuario)
				.getSingleResult();
	}

	public List<Usuario> listarUsuario() {
		StringBuffer sb = new StringBuffer();
		sb.append("select u from Usuario u inner join fetch u.perfis p ");
		sb.append("order by u.nome, p.nome");
		
		return getEntityManager().createQuery(sb.toString(), Usuario.class)
				.getResultList();
	}

}
