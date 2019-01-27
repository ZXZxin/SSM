package com.zxin.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


// 获取SqlSession的工具类
public class MyBatisUtils {

	private static SqlSessionFactory sqlSessionFactory; //这个是一个重量级对象,也是线程安全的(占用资源)

	public static SqlSession getSqlSession() {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			}
			return sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
