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

	//aqui é a variavel de instancia, onde o usuario preenche na tela
	private GrupoProduto grupoProduto;

	public CadastroGrupoProdutoBean() {
		limpar();
		System.out.println("chamando contrutor");
	}
	
	public void salvar() {
		this.grupoProduto = cadastroGrupoProdutoService.salvar(this.grupoProduto);
		limpar();
		FacesUtil.addInfoMessage("Grupo cadastrado com sucesso!");
	}

	private void limpar() {
		grupoProduto = new GrupoProduto();
		System.out.println("chamando limpar");

	}

	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

}