package com.gjw.opiniao.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
	
	public static boolean isPostback(){
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	public static void addErroMessage(String message){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	
	public static void addInfoMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	
	public static void addAlertMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	
	public static Object getSessionMapValue(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
    }

    public static void setSessionMapValue(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
    }
		
	
	/* Usando do mensage diferenciando qual componente de mensagem deve ser exebido em telas que temos mais de uma message */
		
	public static void addErroMessage(String message, String componenteMensagem){
		FacesContext.getCurrentInstance().addMessage(componenteMensagem, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}	
	
	public static void addInfoMessage(String message, String componenteMensagem) {
		FacesContext.getCurrentInstance().addMessage(componenteMensagem, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	
	public static void addAlertMessage(String message, String componenteMensagem) {
		FacesContext.getCurrentInstance().addMessage(componenteMensagem, new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	
	/* Usando para o grow */
	
	public static void addAlertMessage(String titulo, String message, String componenteMensagem) {
		FacesContext.getCurrentInstance().addMessage(componenteMensagem, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, message));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
		
}
