package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.Jogo;

@Repository
public class JogoDao extends GenericDao {

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		super.em = em;
	}
		
	public Jogo getJogo(int idJogo) {
		Query query = super.em.createQuery("from Jogo where ID = :idJogo ");
		query.setParameter("idJogo", idJogo);
		
		if (query.getResultList().size() == 1) {
			return (Jogo) query.getResultList().get(0);
		} else {
			return null;
		}
	}

}