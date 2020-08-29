package com.gjw.opiniao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.dao.ProtocoloDAO;
import com.gjw.opiniao.model.Protocolo;

@Named
public class ProtocoloConverter implements Converter {
	
	@Inject
	private ProtocoloDAO protocoloDao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {
		Protocolo retorno = null;

		if (codigo != null) {
			Long id = new Long(codigo);
			retorno = protocoloDao.buscarPorCodigo(id);
		}
		
		return retorno;	
	}


	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj != null) {
			Protocolo protocolo  = (Protocolo) obj;
			return  protocolo.getCodigo() == null ? null : protocolo.getCodigo().toString();
		}
		
		return "";
	}
}
