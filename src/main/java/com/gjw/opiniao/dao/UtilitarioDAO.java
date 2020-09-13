package com.gjw.opiniao.dao;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.UserTransaction;

import org.hibernate.Session;

public class UtilitarioDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject @Default
	private EntityManager manager;
	
	@Resource
	private UserTransaction transaction;

	protected EntityManager getEntityManager() {
		return manager;
	}
	
	protected Session getSession() {
		return manager.unwrap(Session.class);
	}
	
	
	public void fazerbackup() {
		StoredProcedureQuery sp = getEntityManager().createStoredProcedureQuery("SP_BACKUP_USINA");		
		sp.execute();	
	}
}
