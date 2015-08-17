package com.sgi.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.sgi.filter.ProdutoFilter;
import com.sgi.model.Produto;

public class ProdutoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager manager;
	
	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}
	
	public Produto porCodigo(Long codigo) {
		return manager.find(Produto.class, codigo);

	}

	public Produto porNome(String nome) {
		try {
			return manager
					.createQuery("from Produto where upper(nome) = :nome",
							Produto.class)
					.setParameter("nome", nome.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Produto>filtrados(ProdutoFilter filtro){
		Session session= manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);//Estou criando criterio para grupoproduto
		
		if(StringUtils.isNotBlank(filtro.getNome())){
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(org.hibernate.criterion.Order.asc("nome")).list();
	}
	
	public List<Produto>buscarTodos(){
		return manager.createQuery("from Produto", Produto.class).getResultList();
	}
}
