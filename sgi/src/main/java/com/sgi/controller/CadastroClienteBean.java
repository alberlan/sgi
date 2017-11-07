package com.sgi.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cpf;
	private String cnpj;
	private String codigo;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}

