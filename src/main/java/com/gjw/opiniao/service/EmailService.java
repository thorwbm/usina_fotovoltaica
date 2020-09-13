package com.gjw.opiniao.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.gjw.opiniao.util.jms.ProdutorJMS;
import com.gjw.opiniao.util.mail.Email;

public class EmailService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutorJMS produtorJMSService;	
	
	private Email montarMensagem(String para, String assunto, String mensagem) {
		
		StringBuffer sb = new StringBuffer();
		sb.append(mensagem);		
		
		sb.append("<br /><br />Essa é uma mensagem automática, favor não responder!");
		sb.append("<br /><br />Att. <br />Sistema de Cadastro do Detão");
		Email email = new Email();
		email.setRemetente("detowe@gmail.com");
		email.setDestinatario(para);
		email.setAssunto(assunto);
		email.setMensagem(sb.toString());
		
		return email;
	}

	public void sendEmail(String para, String assunto, String mensagem ) {
		Email email = montarMensagem(para,assunto,mensagem);		
		produtorJMSService.produzirMensagem(email);
	}
	
	public void sendListaEmail(String para, String assunto, String mensagem, List<String> listaEmail ) {
		Email email = montarMensagem(para,assunto,mensagem);	
		for (String destinatario : listaEmail) {
			email.setDestinatario(destinatario);
			produtorJMSService.produzirMensagem(email);
		}
	}
}
