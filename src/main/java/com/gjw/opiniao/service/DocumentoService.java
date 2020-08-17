package com.gjw.opiniao.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.gjw.opiniao.dao.DocumentoDAO;
import com.gjw.opiniao.model.Documento;

public class DocumentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DocumentoDAO documentoDao;
	
	public void excluir(Long documentoId) {
		try {
			documentoDao.excluir(documentoId);
		} catch (Exception e) {
			throw new NegocioException("O documento não pode ser removido!!!", e);
		}
	}
	
	public List<Documento> listar(){
		return documentoDao.listar("nome", "asc");
	}
	
	public Documento pesquisarPorCodigo(Long documentoId) {
		return documentoDao.pesquisarPorCodigo(documentoId);
	}
	
	public Documento salvar(Documento documento) {
		try {
			return documentoDao.salvar(documento);
		} catch (Exception e) {
			throw new NegocioException("O documento não pode ser cadastrado!!!", e);
		}
	}
}
