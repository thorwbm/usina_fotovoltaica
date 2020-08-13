package com.gjw.opiniao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.gjw.opiniao.dao.EmpresaDAO;
import com.gjw.opiniao.model.Empresa;

@FacesConverter(forClass= Empresa.class)
public class EmpresaConverter  implements Converter {
	
	@Inject
	private EmpresaDAO dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {
		Empresa retorno = null;
		
		if (codigo != null) {
			Long id = new Long(codigo);
			retorno = dao.pesquisarPorCodigo(id);
		}
		
		return retorno;		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj != null) {
			Empresa empresa  = (Empresa) obj;
			return  empresa.getCodigo() == null ? null : empresa.getCodigo().toString();
		}
		
		return "";
	}

}
