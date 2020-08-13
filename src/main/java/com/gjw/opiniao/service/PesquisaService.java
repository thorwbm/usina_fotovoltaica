package com.gjw.opiniao.service;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.gjw.opiniao.filter.PesquisaFilter;


public class PesquisaService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static List<PesquisaFilter> carregaListaParametrosPesquisa(Object filtro){
		List<PesquisaFilter> listaParametrosPesquisa = new ArrayList<PesquisaFilter>();
		if(filtro != null){
			String operacao = null;
			Object valor = null;
			Field[] campos = filtro.getClass().getDeclaredFields();
			
			for(int i=1; i<campos.length; i++){  
				campos[i].setAccessible(true);
				try {
					valor = campos[i].get(filtro);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				if(valor != null && !valor.equals("")){
					if(valor instanceof String) {
						operacao = "like";
					} else if (valor.getClass().isEnum()){
						operacao = "in";
					}else {
						operacao = "=";
					}
					listaParametrosPesquisa.add(new PesquisaFilter(campos[i].getName(), valor, operacao));
				}
			}
		}
		return listaParametrosPesquisa;
	}
		

		
		
}
