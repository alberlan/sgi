package com.sgi.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.sgi.model.GrupoProduto;

public class GrupoProdutoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager manager;
	
	public GrupoProduto guardar(GrupoProduto grupoProduto) {
		return manager.merge(grupoProduto);
	}

	public GrupoProduto porCodigo(Long codigo) {
		return manager.find(GrupoProduto.class, codigo);

	}

	public GrupoProduto porNome(String nome) {
		try {
			return manager
					.createQuery("from GrupoProduto where upper(nome) = :nome",
							GrupoProduto.class)
					.setParameter("nome", nome.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

}
