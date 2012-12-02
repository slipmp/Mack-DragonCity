package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.DragaoTipoDao;
import br.com.projeto.dao.GenericDao;
import br.com.projeto.entity.DragaoTipo;

@Service
public class DragaoService extends GenericDao{
	
	@Autowired
	private DragaoTipoDao dragaoTipoDao;
	
	public DragaoTipo getDragaoTipoPorId(int id) 
	{
		return dragaoTipoDao.findById(DragaoTipo.class, id);
	}
}
