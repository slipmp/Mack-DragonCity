package br.com.projeto.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.projeto.dao.UserDao;

import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;

import org.springframework.test.context.transaction.TransactionConfiguration;

import static junit.framework.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class JogoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserDao dao;

    @Autowired
    private DriverManagerDataSource ds;

    @Test
    public void testIniciandoTestes()
    {
    	System.out.println("Iniciando tests. Nao foi feito nenhum println para os dados aqui propositalmente.");
    }

    @Test
    @Rollback(true) //Esse codigo faz com que tudo que for executado aqui nesse metodo, seja dado Rollback.
    public void testCreate() throws SQLException {
    	Jogo u = new Jogo();
        u.setVlrTotalComida(30);
        dao.insert(u);
        System.out.println("testCreate Concluido!");
    }

    @Test
    @Rollback(true)
    public void testRetrieve() throws SQLException {
    	Jogo u = CreateToUseInTests();
    	Jogo u2=dao.findById(Jogo.class, u.getCodigo());
    	assertNotNull(u2);
        System.out.println("testRetrieve Concluido!");
    }

    @Test
    @Rollback(true)
    public void testUpdate() throws SQLException {
    	Jogo u = CreateToUseInTests();
    	u.setVlrTotalComida(100);
        dao.update(u);
        System.out.println("testUpdate Concluido!");
    }

    @Test
    @Rollback(true)
    public void testDelete() throws SQLException {
    	Jogo u = CreateToUseInTests();
    	dao.remove(Jogo.class,u.getCodigo());
        System.out.println("testDelete Concluido!");
    }
    
    private Jogo CreateToUseInTests()
    {
    	Jogo u = new Jogo();
        u.setVlrTotalComida(30);
        dao.insert(u);
        return u;
    }
}