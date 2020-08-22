package com.gjw.opiniao.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.gjw.opiniao.dao.DocumentacaoDAO;
import com.gjw.opiniao.model.Documentacao;

public class DocumentacaoService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private DocumentacaoDAO documentacaoDao;
	
	public List<Documentacao> listar(){
		return documentacaoDao.listar("nome", "asc");
	}

	public List<Documentacao> listar(String campo){
		return documentacaoDao.listar(campo, "asc");
	}
	
	public List<Documentacao> listar(String campo, String ordem){
		return documentacaoDao.listar(campo, ordem);
	}
	
	public Documentacao salvar(Documentacao documentacao) {
		try {
			return documentacaoDao.salvar(documentacao);
		} catch (Exception e) {
			throw new NegocioException("A documentação não pode ser atualizada!",e);
		}
	}
	
	public void excluir(Long documentacaoId) {
		try {
			documentacaoDao.excluir(documentacaoId);
		} catch (Exception e) {
			throw new NegocioException("A documentação não pode ser excluida!",e);
		}
	}
}
