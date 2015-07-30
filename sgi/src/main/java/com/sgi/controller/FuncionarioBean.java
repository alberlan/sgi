package com.sgi.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cidade;

	public void atualizar() {
		System.out.println("Profissão: " + this.cidade);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Perfil atualizado!"));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}