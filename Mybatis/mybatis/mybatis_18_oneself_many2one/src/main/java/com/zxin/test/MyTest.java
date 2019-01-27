package com.zxin.test;

import com.zxin.bean.NewsLabel;
import com.zxin.dao.INewsLabelDao;
import com.zxin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTest {
    private INewsLabelDao dao;
    private SqlSession sqlSession;

    @Before
    public void before() {
        sqlSession = MyBatisUtils.getSqlSession();
        dao = sqlSession.getMapper(INewsLabelDao.class);
    }

    @After
    public void after() {
        if(sqlSession != null) {
            sqlSession.close();
        }
    }


    @Test
    public void test01() {
        NewsLabel newslabel = dao.selectNewsLabelById(7);
        System.out.println(newslabel);
    }
}
