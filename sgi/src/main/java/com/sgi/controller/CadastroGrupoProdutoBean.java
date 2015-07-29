package com.sgi.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgi.model.GrupoProduto;
import com.sgi.service.CadastroGrupoProdutoService;
import com.sgi.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroGrupoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroGrupoProdutoService cadastroGrupoProdutoService;

	private GrupoProduto grupoProduto;

	public CadastroGrupoProdutoBean() {
		limpar();
	}

	public void salvar() {
		this.grupoProduto = cadastroGrupoProdutoService.salvar(this.grupoProduto);
		limpar();
		FacesUtil.addInfoMessage("Grupo cadastrado com sucesso!");

	}

	private void limpar() {
		grupoProduto = new GrupoProduto();

	}

	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

}