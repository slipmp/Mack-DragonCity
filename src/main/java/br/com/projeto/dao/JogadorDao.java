package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;

@Repository
public class JogadorDao extends GenericDao {
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		super.em = em;
	}
	
	public Jogador getJogador(String login) {
		Query query = super.em.createQuery("from Jogador j where j.login = :login ");
		query.setParameter("login", login);
		
		if (query.getResultList().size() == 1) {
			return (Jogador) query.getResultList().get(0);
		} else {
			return null;
		}
	}
	
	public Jogo getJogo(int idJogador) {
		Query query = super.em.createQuery("from Jogo where idJogador = :idJogador ");
		query.setParameter("idJogador", idJogador);
		
		if (query.getResultList().size() == 1) {
			return (Jogo) query.getResultList().get(0);
		} else {
			return null;
		}
	}	
}
