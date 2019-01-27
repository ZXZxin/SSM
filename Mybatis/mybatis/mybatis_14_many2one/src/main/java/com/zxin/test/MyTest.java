package com.zxin.test;

import com.zxin.bean.Minister;
import com.zxin.dao.IMinisterDao;
import com.zxin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyTest {
    private IMinisterDao dao;
    private SqlSession sqlSession;

    @Before
    public void before() {
        sqlSession = MyBatisUtils.getSqlSession();
        dao = sqlSession.getMapper(IMinisterDao.class);
    }

    @After
    public void after() {
        if(sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void test01() {
        Minister minister = dao.selectMinisterById(2);
        System.out.println(minister);
    }
}
