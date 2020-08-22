package com.gjw.opiniao.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.gjw.opiniao.dao.DocumentacaoDAO;
import com.gjw.opiniao.model.Documentacao;

@Named
public class DocumentacaoConverter implements Converter {
	
	@Inject
	private DocumentacaoDAO documentacaoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {
		Documentacao retorno = null;

		if (codigo != null) {
			Long id = new Long(codigo);
			retorno = documentacaoDAO.buscarPorCodigo(id);
		}
		
		return retorno;	
	}
	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if (obj != null) {
			Documentacao documentacao  = (Documentacao) obj;
			return  documentacao.getCodigo() == null ? null : documentacao.getCodigo().toString();
		}
		
		return "";
	}

}
