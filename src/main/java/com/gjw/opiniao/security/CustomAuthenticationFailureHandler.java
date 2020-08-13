package com.gjw.opiniao.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String caminhoPagina = null;
		Long processoSeletivo = null;
		
    	try {
    		processoSeletivo = (Long) request.getAttribute("processoSeletivo");
		} catch (Exception e) {}
    	
    	if(processoSeletivo == null) {
    		caminhoPagina = "/sipeps/index.xhtml?invalid=true";
    	} else {
    		caminhoPagina = "/sipeps/processo.xhtml?processoSeletivo="+processoSeletivo+"&style=titulo-verde&invalid=true";
    	}
    	
    	response.sendRedirect(caminhoPagina);
	}
}
