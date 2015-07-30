package com.sgi.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgi.filter.GrupoProdutoFilter;
import com.sgi.model.GrupoProduto;
import com.sgi.repository.GrupoProdutoRepository;

@Named
@ViewScoped
public class PesquisaGrupoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoProdutoRepository grupoProdutoRepository;

	private GrupoProdutoFilter filtro;
	private List<GrupoProduto> listaGrupoProdutos;

	public PesquisaGrupoProdutoBean() {
		filtro = new GrupoProdutoFilter();
	}

	public void pesquisar() {
		listaGrupoProdutos = grupoProdutoRepository.filtrados(filtro);
	}

	public List<GrupoProduto> getListaGrupoProdutos() {
		return listaGrupoProdutos;
	}

	public GrupoProdutoFilter getFiltro() {
		return filtro;
	}

}