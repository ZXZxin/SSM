package com.zxin.test;

import com.zxin.bean.Student;
import com.zxin.dao.IStudentDao;
import com.zxin.dao.StudentDaoImpl;
import org.junit.Before;
import org.junit.Test;

public class MyTest {
    private IStudentDao dao;

    @Before
    public void before() {
        dao = new StudentDaoImpl();
    }

    @Test
    public void testInsert() {
        Student student = new Student("赵六", 26, 96.6);
        dao.insertStu(student);
    }
}
