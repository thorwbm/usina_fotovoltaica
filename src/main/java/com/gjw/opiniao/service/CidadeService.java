package com.gjw.opiniao.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.gjw.opiniao.dao.CidadeDAO;
import com.gjw.opiniao.model.Cidade;

public class CidadeService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CidadeDAO cidadeDao;
	

	public void excluir(Long cidadeId) {
		try {
			cidadeDao.excluir(cidadeId);
		} catch (Exception e) {
			throw new NegocioException("A cidade não pode removida!!!", e);
		}
	}
		
	public List<Cidade> listar(){
		return cidadeDao.listar("nome", "asc");
	}
	 
	public Cidade pesquisarPorCodigo(Long cidadeId){
		return cidadeDao.pesquisarPorCodigo(cidadeId);
	}
	 
	public Cidade salvar(Cidade cidade) {
		try {
			return cidadeDao.salvar(cidade);
		} catch (Exception e) {
			throw new NegocioException("A cidade não pode ser cadastrada!!!", e);
		}
	}
	
	public Cidade buscaCidade(String cidadeNome, String siglaEstado) {
		return cidadeDao.buscaCidade( cidadeNome,  siglaEstado);
	}
		
}
