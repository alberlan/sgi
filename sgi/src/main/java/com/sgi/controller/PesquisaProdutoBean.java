package com.sgi.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgi.filter.ProdutoFilter;
import com.sgi.model.Produto;
import com.sgi.repository.ProdutoRepository;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository produtoRepository;

	private ProdutoFilter filtro;
	private List<Produto> produtos;

	public PesquisaProdutosBean() {
		filtro = new ProdutoFilter();

	}

	public void pesquisar() {
		produtos = produtoRepository.buscarTodos();
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}