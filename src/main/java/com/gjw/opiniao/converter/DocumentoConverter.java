package com.gjw.opiniao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.dao.DocumentoDAO;
import com.gjw.opiniao.model.Documento;

@Named
public class DocumentoConverter implements Converter {
	
	@Inject
	private DocumentoDAO documentoDao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {
		Documento retorno = null;

		if (codigo != null) {
			Long id = new Long(codigo);
			retorno = documentoDao.pesquisarPorCodigo(id);
		}
		
		return retorno;	
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj != null) {
			Documento documento  = (Documento) obj;
			return  documento.getCodigo() == null ? null : documento.getCodigo().toString();
		}
		
		return "";
	}

}
