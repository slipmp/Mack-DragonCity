package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.User;

@Repository
public class UserDao extends GenericDao {

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		super.em = em;
	}

	public User getUser(String login,String password) {
		Query query = super.em.createQuery("from User u where u.login = :login and u.password = :password ");
		query.setParameter("login", login);
		query.setParameter("password", password);
		
		System.out.println("query.getResultList().size()= " + query.getResultList().size());
		if (query.getResultList().size() == 1) {
			return (User) query.getResultList().get(0);
		} else {
			return null;
		}
	}

}