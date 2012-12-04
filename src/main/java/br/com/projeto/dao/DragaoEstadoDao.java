package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.DragaoEstado;

@Repository
public class DragaoEstadoDao extends GenericDao {

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		super.em = em;
	}
	
	public DragaoEstado getDragaoEstado(int LevelDragao, int IdDragaoTipo) {
		
		Query query = super.em.createQuery("from DragaoEstado where levelDe >= :LevelDragao and levelPara <= :LevelDragao and IdDragaoTipo = :IdDragaoTipo ");
		query.setParameter("LevelDragao", LevelDragao);
		query.setParameter("IdDragaoTipo", IdDragaoTipo);
		
		if (query.getResultList().size() == 1) {
			return (DragaoEstado) query.getResultList().get(0);
		} else {
			return null;
		}
	}
	
}