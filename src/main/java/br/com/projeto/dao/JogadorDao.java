package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;
import br.com.projeto.entity.User;

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
	
	public Jogador getJogador(String login,String password) {
		Query query = super.em.createQuery("from Jogador j where j.login = :login and j.password = :password ");
		query.setParameter("login", login);
		query.setParameter("password", password);
		if (query.getResultList().size() == 1) {
			return (Jogador) query.getResultList().get(0);
		} else {
			return null;
		}
	}	
}
