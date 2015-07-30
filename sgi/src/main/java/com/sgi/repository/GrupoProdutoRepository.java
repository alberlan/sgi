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

import com.sgi.filter.GrupoProdutoFilter;
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

	@SuppressWarnings("unchecked")
	public List<GrupoProduto>filtrados(GrupoProdutoFilter filtro){
		Session session= manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(GrupoProduto.class);//Estou criando criterio para grupoproduto
		
		if(StringUtils.isNotBlank(filtro.getNome())){
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(org.hibernate.criterion.Order.asc("nome")).list();
	}
}
