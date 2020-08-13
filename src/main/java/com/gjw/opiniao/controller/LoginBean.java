package com.gjw.opiniao.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjw.opiniao.util.jsf.FacesUtil;

import lombok.Data;

@Data
@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;
	

	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String login;
	
	private String cpf;
	
	public LoginBean(){
		
	}
	
		public void preRender() {
		request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
				
		if ("true".equals(request.getParameter("invalid"))) {
			FacesUtil.addErroMessage("Usuário ou senha inválido!");
		}
	}
	
	public void logar() throws ServletException, IOException {
		request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(request, response);
		
		facesContext.responseComplete();
	}
	
	public void limpar(){
		 cpf = new String();
	}
	
	public void restaurarSenha() {
		// TODO implementar a funcao de restaurar senha
	}
	
}