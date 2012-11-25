package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.projeto.dao.UserDao;
import br.com.projeto.entity.User;
import br.com.projeto.util.CryptUtils;

import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static junit.framework.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

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
        User u = new User();
        u.setLogin("juca");
        u.setPassword(CryptUtils.md5("123"));
        dao.insert(u);
        System.out.println("testCreate Concluido!");
    }

    @Test
    @Rollback(true)
    public void testRetrieve() throws SQLException {
    	User u = CreateToUseInTests();
        User u2=dao.findById(User.class, u.getId());
        assertNotNull(u2);
        System.out.println("testRetrieve Concluido!");
    }

    @Test
    @Rollback(true)
    public void testUpdate() throws SQLException {
    	User u = CreateToUseInTests();
    	u.setLogin("teste");
        dao.update(u);
        System.out.println("testUpdate Concluido!");
    }

    @Test
    @Rollback(true)
    public void testDelete() throws SQLException {
    	User u = CreateToUseInTests();
    	dao.remove(User.class,u.getId());
        System.out.println("testDelete Concluido!");
    }
    
    private User CreateToUseInTests()
    {
        User u = new User();
        u.setLogin("juca");
        u.setPassword(CryptUtils.md5("123"));
        dao.insert(u);
        return u;
    }
}