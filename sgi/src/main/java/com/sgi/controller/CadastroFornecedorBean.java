package com.sgi.controller;

import java.io.Serializable;



import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sgi.model.Fornecedor;
import com.sgi.service.CadastroFornecedorService;

@Named
@ViewScoped
public class CadastroFornecedorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroFornecedorService cadastroFornecedorService;

	private Fornecedor fornecedor;

	public CadastroFornecedorBean() {
		limpar();
	}

	public void salvar() {
		cadastroFornecedorService.salvar(fornecedor);
	}

	private void limpar() {
		fornecedor = new Fornecedor();

	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
