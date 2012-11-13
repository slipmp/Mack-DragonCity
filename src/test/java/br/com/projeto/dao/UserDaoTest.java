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

import br.com.projeto.entity.User;

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
	public void testInsert() throws SQLException {
		/*
		User u = new User();
		u.setLogin("juca");
		u.setPassword("123");
		dao.insert(u);
		Connection con = ds.getConnection();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(" select * from usuario");
		while(rs.next()) {
			System.out.println(rs.getString(0)+"-"+ rs.getString(1));
		}*/
		dao.findById(User.class, 1);
		System.out.println("testFindById");

		System.out.println("testInsert");
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		System.out.println("testUpdate");
		//fail("Not yet implemented");
	}
}