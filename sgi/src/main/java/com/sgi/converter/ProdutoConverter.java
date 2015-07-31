package com.sgi.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sgi.model.Produto;
import com.sgi.repository.ProdutoRepository;
import com.sgi.util.cdi.CDIServiceLocator;



@FacesConverter(forClass = ProdutoConverter.class)
public class ProdutoConverter implements Converter {

	
	private ProdutoRepository produtoRepository;
	
	public ProdutoConverter() {
		produtoRepository = CDIServiceLocator.getBean(ProdutoRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;
		
		if (value != null) {
			Long codigo = new Long(value);
			retorno = produtoRepository.porCodigo(codigo);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Produto produto = (Produto) value;
			return produto.getCodigo() == null ? null : produto.getCodigo().toString();
		}
		
		return "";
	}

}