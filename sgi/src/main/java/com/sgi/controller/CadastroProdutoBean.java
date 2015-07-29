package com.sgi.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sgi.service.NegocioException;

@Named
@RequestScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> itens;

	public CadastroProdutoBean() {
		itens = new ArrayList<Integer>();
		itens.add(1);
	}

	public void salvar() {
		
	}

	public List<Integer> getItens() {
		return itens;
	}

}
