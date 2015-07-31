package com.sgi.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sgi.model.Produto;
import com.sgi.repository.ProdutoRepository;
import com.sgi.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository produtoRepository; 
	
	@Transactional
	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtoRepository.porNome(produto.getNome());
		
		if (produtoExistente != null && !produtoExistente.equals(produto)) {
			throw new NegocioException("O produto "+produtoExistente.getNome()+" já está cadastrado");
		}
		
		return produtoRepository.guardar(produto);
	}
	
		
}
