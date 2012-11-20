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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.projeto.dao.UserDao;
import br.com.projeto.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
"classpath*:applicationContext.xml"})

public class UserDaoTest {

	@Autowired
	private UserDao dao;

	@Autowired
	private DriverManagerDataSource ds;

	@BeforeClass
	public static void comecoDeTudo() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}
	@Test
	public void testIniciandoOsTestes()
	{
		System.out.println("Iniciando os testes da UserDaoTest!");
	}
	@Test
	public void testCreate() throws SQLException {
		System.out.println("testCreate Iniciando!");
		UserDao dao =new UserDao();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto");
	    EntityManager em = emf.createEntityManager();
	    dao.setEntityManager(em);
	    
		User u = new User();
		u.setLogin("juca");
		u.setPassword("123");
		dao.insert(u);
		
	    System.out.println("testCreate Concluido!");
	} 

	@Test
	public void testRetrieve() throws SQLException {
		Connection con = ds.getConnection();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(" select * from tbUsuario");
		while(rs.next()) {
			System.out.println(rs.getString("id")+"-"+ rs.getString("login"));
		}
		System.out.println("testRetrieve Concluido!");
	}
	
	@Test
	public void testUpdate() throws SQLException {
		User u = dao.getUser("juca", "123");
		u.setLogin("JucaUpdated");
		dao.update(u);
		System.out.println("testUpdate Concluido!");
		//fail("Not yet implemented");
	}
	
	@Test
	public void testDelete() throws SQLException {
		User u = dao.getUser("JucaUpdated", "123");
		dao.remove(User.class,u.getId());
		System.out.println("testDelete Concluido!");
		//fail("Not yet implemented");
	}
}