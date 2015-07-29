package com.sgi.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.sgi.model.GrupoProduto;

@Named
@ViewScoped
public class CadastroGrupoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private GrupoProduto grupoProduto;

	public CadastroGrupoProdutoBean() {
		grupoProduto = new GrupoProduto();
	}

	public void salvar() {

	}

	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

}