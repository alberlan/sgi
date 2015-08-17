package com.sgi.model;

import java.io.Serializable;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private String rg;
	private Cargo cargo;
	private String senha;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	

}
