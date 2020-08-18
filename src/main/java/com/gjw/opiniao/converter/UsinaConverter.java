package com.gjw.opiniao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.dao.UsinaDAO;
import com.gjw.opiniao.model.Usina;

@Named
public class UsinaConverter  implements Converter {
	
	@Inject
	private UsinaDAO usinaDao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {
		Usina retorno = null;

		if (codigo != null) {
			Long id = new Long(codigo);
			retorno = usinaDao.buscarPorCodigo(id);
		}
		
		return retorno;	
	}


	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj != null) {
			Usina usina  = (Usina) obj;
			return  usina.getCodigo() == null ? null : usina.getCodigo().toString();
		}
		
		return "";
	}
}
