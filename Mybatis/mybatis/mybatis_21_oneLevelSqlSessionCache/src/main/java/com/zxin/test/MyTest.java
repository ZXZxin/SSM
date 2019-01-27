package com.zxin.test;

import com.zxin.bean.Student;
import com.zxin.dao.IStudentDao;
import com.zxin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MyTest {
	private IStudentDao dao;
	private SqlSession sqlSession;

	@Before
	public void before() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}
	
	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	
	// 证明一级缓存是存在的
	@Test
	public void test01() {
		Student student = dao.selectStudentById(2);
		System.out.println(student);
		
		Student student2 = dao.selectStudentById(2);
		System.out.println(student2);
	}
	
	
	// 缓存的底层实现是一个Map，Map的value是查询结果
	// Map的key，即查询依据，使用的ORM构架不同，查询依据是不同的。
	// MyBatis的查询依据是：Sql的id + SQL语句
	// Hibernate的查询依据是：查询结果对象的id
	@Test
	public void test02() {
		Student student = dao.selectStudentById(2);
		System.out.println(student);
		
		Student student2 = dao.selectStudentById2(2);
		System.out.println(student2);
	}
	
	// 证明一级缓存是存在的
	@Test
	public void test03() {
		Student student = dao.selectStudentById(2);
		System.out.println(student);
		
		// 增删改操作都会清空一级缓存，无论是否提交
		dao.insertStudent(new Student("赵六", 26, 96.5));
		
		Student student2 = dao.selectStudentById(2);
		System.out.println(student2);
	}
	
}






























