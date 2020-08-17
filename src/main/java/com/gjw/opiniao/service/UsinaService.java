package com.gjw.opiniao.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.gjw.opiniao.dao.UsinaDAO;
import com.gjw.opiniao.model.Usina;

public class UsinaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsinaDAO usinaDao;

	public Usina salvar(Usina usina) {
		
		try {
			return usinaDao.salvar(usina);
		} catch (Exception e) {
			throw new NegocioException("A usina não pode ser cadastrada!!!", e);
		}
	}

	public void excluir(Long usinaId) {
		try {
			usinaDao.excluir(usinaId);
		} catch (Exception e) {
			throw new NegocioException("A usina não pode ser removida!!!", e);
		}
		
	}

	public List<Usina> listar() {
		return usinaDao.listar("nome", "asc");
	}

}
