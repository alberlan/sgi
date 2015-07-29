package com.sgi.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sgi.model.GrupoProduto;

public class GrupoProdutoRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager manager;

	public GrupoProduto porCodigo(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
