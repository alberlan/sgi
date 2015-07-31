package com.sgi.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgi.model.GrupoProduto;
import com.sgi.model.Produto;
import com.sgi.repository.GrupoProdutoRepository;
import com.sgi.service.CadastroProdutoService;
import com.sgi.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoProdutoRepository grupoProdutoRepository;

	@Inject
	private CadastroProdutoService cadastroProdutoService;

	private List<GrupoProduto> listaGrupoProdutos;
	private Produto produto;

	public CadastroProdutoBean() {
		limpar();
	}

	public void inicializarGrupo() {
		if (FacesUtil.isNotPostback()) {
			listaGrupoProdutos = grupoProdutoRepository.buscarGrupo();
		}
	}

	public void salvar() {
		produto = cadastroProdutoService.salvar(produto);
		limpar();
		FacesUtil.addInfoMessage("Produto cadastrado com sucesso!");

	}
	
	public void calcularMargemLucro(){
		this.produto.margemLucro();
	}

	private void limpar() {
		produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<GrupoProduto> getListaGrupoProdutos() {
		return listaGrupoProdutos;
	}

}
