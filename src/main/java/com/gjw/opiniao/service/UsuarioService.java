package com.gjw.opiniao.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.omnifaces.util.Utils;

import com.gjw.opiniao.dao.UsuarioDAO;
import com.gjw.opiniao.filter.UsuarioFilter;
import com.gjw.opiniao.model.Usuario;
import com.gjw.opiniao.security.Criptografia;

public class UsuarioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDAO dao;

	
	public List<Usuario> listar(String ordem, String sentido){
		return dao.listar(ordem, sentido);
	}

	public List<Usuario> listarUsuario() {
		return dao.listarUsuario();
	}
	
	public List<Usuario> pesquisar(UsuarioFilter filtro){
		return dao.pesquisar(PesquisaService.carregaListaParametrosPesquisa(filtro));
	}
	
	public Usuario pesquisarPorCodigo(Long codigo){
		return dao.pesquisarPorCodigo(codigo);
	}
	
	public Usuario criptografarSenha(Usuario usuario){
		if( usuario.getCodigo() > 0 && Utils.isAnyEmpty(usuario.getSenha())){
			usuario.setSenha(dao.pesquisarPorCodigo(usuario.getCodigo()).getSenha());
		} else {
			usuario.setSenha(Criptografia.criptografarSHA1(usuario.getSenha()));
		}
		return usuario;
	}
	
	public Usuario salvar(Usuario usuario){
		try {
			return dao.salvar(criptografarSenha(usuario));
		} catch (Exception e) {
			throw new NegocioException("Erro ao salvar o registro!");
		}
	}
	
	public Usuario excluir(Usuario usuario) {
		try {
			return dao.excluir(usuario.getCodigo());
		} catch (Exception e) {
			throw new NegocioException("O registro não pode ser excluído");
		}
	}

	public Usuario recuperarUsuario(Long codigo) {
		return dao.recuperarUsuario(codigo);
	}




}
