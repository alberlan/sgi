package com.sgi.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.sgi.model.GrupoProduto;
import com.sgi.repository.GrupoProdutoRepository;
import com.sgi.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = GrupoProduto.class)
public class GrupoProdutoConverter implements Converter {
	
	//@Inject
	private GrupoProdutoRepository grupoProdutoRepository;
	
	public GrupoProdutoConverter() {
		grupoProdutoRepository = CDIServiceLocator.getBean(GrupoProdutoRepository.class);
	}

	//recebo uma string para retornar um objeto nesse caso um objeto GrupoProduto
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		GrupoProduto retorno = null;
		if(value != null){
			Long codigo = new Long(value);
			retorno = grupoProdutoRepository.porCodigo(codigo);
		}
		return retorno;
	}

	//metodo para receber uma string 
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			return ((GrupoProduto)value).getCodigo().toString();
		}
		
		return "";
	}

}