package com.gjw.opiniao.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.gjw.opiniao.dao.ConsorcioDAO;
import com.gjw.opiniao.model.Consorcio;

public class ConsorcioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ConsorcioDAO consorcioDao;
	
	public void excluir(Long consorcioId) {
		try {
			consorcioDao.excluir(consorcioId);
		} catch (Exception e) {
			throw new NegocioException("O Consórcio não pode ser removido!!!", e);
		}
	}
	
	public List<Consorcio> listar(){
		return consorcioDao.listar("nome", "asc");
	}

	public Consorcio pesquisarPorCodigo(Long ConsorcioId) {
		return consorcioDao.pesquisarPorCodigo(ConsorcioId);
	}
	
	public Consorcio salvar(Consorcio consorcio) {
		try {
			return consorcioDao.salvar(consorcio);
		} catch (Exception e) {
			throw new NegocioException("O Consórcio não pode ser cadastrado!!!", e);
		}
	}
}
