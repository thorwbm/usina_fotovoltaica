package com.gjw.opiniao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.dao.ConsorcioDAO;
import com.gjw.opiniao.model.Consorcio;

@Named
public class ConsorcioConverter implements Converter {
	
	@Inject
	private ConsorcioDAO consorcioDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {
		Consorcio retorno = null;

		if (codigo != null) {
			Long id = new Long(codigo);
			retorno = consorcioDAO.buscarPorCodigo(id);
		}
		
		return retorno;	
	}
	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj != null) {
			Consorcio consorcio  = (Consorcio) obj;
			return  consorcio.getCodigo() == null ? null : consorcio.getCodigo().toString();
		}
		
		return "";
	}
	

}
