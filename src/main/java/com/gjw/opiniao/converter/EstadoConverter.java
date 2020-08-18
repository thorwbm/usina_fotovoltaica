package com.gjw.opiniao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.dao.EstadoDAO;
import com.gjw.opiniao.model.Estado;

@Named
public class EstadoConverter implements Converter {
	
	@Inject
	private EstadoDAO estadoDao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {
		Estado retorno = null;

		if (codigo != null) {
			Long id = new Long(codigo);
			retorno = estadoDao.pesquisarPorCodigo(id);
		}
		
		return retorno;	
	}


	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj != null) {
			Estado estado  = (Estado) obj;
			return  estado.getCodigo() == null ? null : estado.getCodigo().toString();
		}
		
		return "";
	}
}

