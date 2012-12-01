package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import br.com.projeto.entity.Jogador;

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
	
	public Jogador getJogador(String login,String senha) {
		Query query = super.em.createQuery("from Jogador j where j.login = :login and j.senha = :senha ");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		if (query.getResultList().size() == 1) {
			return (Jogador) query.getResultList().get(0);
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional()
	public List<Jogador> listarJogadores() {
		Query query = super.em.createQuery("from Jogador ");
		return (List<Jogador>) query.getResultList();
	}
}
