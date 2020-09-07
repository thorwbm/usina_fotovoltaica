package com.gjw.opiniao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.dao.CidadeDAO;
import com.gjw.opiniao.model.Cidade;

@Named
public class CidadeConverter implements Converter {
	
	@Inject
	private CidadeDAO cidadeDao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {
		Cidade retorno = null;

		if (codigo != null) {
			Long id = new Long(codigo);
			retorno = cidadeDao.buscarPorCodigo(id);
		}
		
		return retorno;	
	}


	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj != null) {
			Cidade cidade  = (Cidade) obj;
			return  cidade.getCodigo() == null ? null : cidade.getCodigo().toString();
		}
		
		return "";
	}
}
