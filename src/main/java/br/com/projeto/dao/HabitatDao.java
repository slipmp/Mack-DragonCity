package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class HabitatDao extends GenericDao {

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		super.em = em;
	}
}