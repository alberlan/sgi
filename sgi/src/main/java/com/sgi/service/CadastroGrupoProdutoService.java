package com.sgi.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sgi.model.GrupoProduto;
import com.sgi.repository.GrupoProdutoRepository;
import com.sgi.util.jpa.Transactional;

public class CadastroGrupoProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoProdutoRepository grupoProdutoRepository;

	@Transactional
	public GrupoProduto salvar(GrupoProduto grupoProduto) {
		GrupoProduto grupoExistente = grupoProdutoRepository
				.porNome(grupoProduto.getNome());
		if (grupoExistente != null && !grupoExistente.equals(grupoProduto)) {
			throw new NegocioException("O Grupo " + grupoProduto.getNome()
					+ " já está cadastrado");
		}

		return grupoProdutoRepository.guardar(grupoProduto);
	}
		
}
