package com.gjw.opiniao.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.gjw.opiniao.dao.EmpresaDAO;
import com.gjw.opiniao.model.Empresa;



public class EmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaDAO empresaDao;
	
	public List<Empresa> listar(){
		return empresaDao.listar("nome", "asc");
	
	}

	public Empresa pesquisarPorCodigo(Long empresaId) {
		return empresaDao.pesquisarPorCodigo(empresaId);
	}
	
	public Empresa salvar (Empresa empersa) {
		try {
			return empresaDao.salvar(empersa);
		} catch (Exception e) {
			throw new NegocioException("A Empresa não pode ser cadastrada!!!", e);
		}
	}
	
	public void excluir(Long empresaId) {
		try {
			empresaDao.excluir(empresaId);
		} catch (Exception e) {
			throw new NegocioException("A Empresa não pode ser excluida!!!", e);
		}
	}
}
