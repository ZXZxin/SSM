package com.zxin.test;

import com.zxin.bean.Student;
import com.zxin.dao.IStudentDao;
import com.zxin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;


public class MyTest {
	private IStudentDao dao;
	private SqlSession sqlSession;

	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	
	// 证明二级缓存是存在的
	// 开启内置的二级缓存步骤：
	// 1）对实体进行序列化
	// 2）在映射文件中添加<cache/>标签
	@Test
	public void test01() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		Student student = dao.selectStudentById2(2);
		System.out.println(student);
		
		sqlSession.close();
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		Student student2 = dao.selectStudentById2(2);
		System.out.println(student2);
	}
	
	// 本例说明以下几点内容：
	// 1.增删改同样也会清空二级缓存
	// 2.对于二级缓存的清空，实质上是对所查找key对应的value置为null，
	//   而并非将<key，value>对，即Entry对象删除
	// 3.从DB中进行select查询的条件是：
	//   1)缓存中根本就不存在这个key
	//   2)缓存中存在该key所对应的Entry对象，但其value为null
	@Test
	public void test02() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		Student student = dao.selectStudentById2(2);
		System.out.println(student);
		
		sqlSession.close();
		
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
		
		// 插入
		dao.insertStudent(new Student("", 0, 0));
		
		Student student2 = dao.selectStudentById2(2);
		System.out.println(student2);
	}
	
}






























