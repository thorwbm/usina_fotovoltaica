package com.gjw.opiniao.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		
		String caminhoPagina = null;
		Long tipoProcesso = null;
		Long processoSeletivo = null;
		
    	try {
    		tipoProcesso = (Long) request.getAttribute("tipoProcesso");
    		processoSeletivo = (Long) request.getAttribute("processoSeletivo");
		} catch (Exception e) {}
    	
    	if(processoSeletivo == null) {
    		caminhoPagina = "/sipeps/inicio.xhtml";
    	} else {
    		caminhoPagina = "/sipeps/inscricao/fichaInscricao.xhtml?tipoProcesso="+tipoProcesso+"&processoSeletivo="+processoSeletivo;
    	}
    	
    	response.sendRedirect(caminhoPagina);
	}
}
