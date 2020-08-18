package com.gjw.opiniao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.dao.PotenciaDAO;
import com.gjw.opiniao.model.Potencia;

@Named
public class PotenciaConverter  implements Converter {
	
	@Inject
	private PotenciaDAO potenciaDao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {
		Potencia retorno = null;

		if (codigo != null) {
			Long id = new Long(codigo);
			retorno = potenciaDao.pesquisarPorCodigo(id);
		}
		
		return retorno;	
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj != null) {
			Potencia potencia  = (Potencia) obj;
			return  potencia.getCodigo() == null ? null : potencia.getCodigo().toString();
		}
		
		return "";
	}
	
}
