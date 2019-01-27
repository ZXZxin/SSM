package com.zxin.test;

import com.zxin.bean.Student;
import com.zxin.dao.IStudentDao;
import com.zxin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test08() {
        Student stu = new Student("田七", 27, 95);

        Map<String, Object> map = new HashMap<>();
        map.put("nameCon", "张");
        map.put("ageCon", 23);
        map.put("stu", stu);

        List<Student> students = dao.selectStudentsByCondition(map);
        for (Student student : students)
            System.out.println(student);
    }

}
