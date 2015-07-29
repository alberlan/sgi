package com.sgi.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgi.model.GrupoProduto;
import com.sgi.repository.GrupoProdutoRepository;
import com.sgi.util.cdi.CDIServiceLocator;



@FacesConverter(forClass = GrupoProdutoConverter.class)
public class GrupoProdutoConverter implements Converter {

	
	private GrupoProdutoRepository grupoProdutoRepository;
	
	public GrupoProdutoConverter() {
		grupoProdutoRepository = CDIServiceLocator.getBean(GrupoProdutoRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		GrupoProduto retorno = null;
		
		if (value != null) {
			Long codigo = new Long(value);
			retorno = grupoProdutoRepository.porCodigo(codigo);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			GrupoProduto grupoProduto = (GrupoProduto) value;
			return grupoProduto.getCodigo() == null ? null : grupoProduto.getCodigo().toString();
		}
		
		return "";
	}

}