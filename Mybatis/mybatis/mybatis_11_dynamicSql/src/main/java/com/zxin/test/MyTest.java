package com.zxin.test;

import com.zxin.bean.Student;
import com.zxin.dao.IStudentDao;
import com.zxin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void test01() {
        // Student stu = new Student("张", 23, 0);
        // Student stu = new Student("", 23, 0);
        Student stu = new Student("", 0, 0);

        List<Student> students = dao.selectStudentsByIf(stu);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test02() {
        Student stu = new Student("张", 23, 0);
        // Student stu = new Student("", 23, 0);
        // Student stu = new Student("", 0, 0);

        List<Student> students = dao.selectStudentsByWhere(stu);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test03() {
        // Student stu = new Student("张", 23, 0);
        // Student stu = new Student("", 23, 0);
        Student stu = new Student("", 0, 0);

        List<Student> students = dao.selectStudentsByChoose(stu);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test04() {
        int[] ids = {1, 3, 4};
        List<Student> students = dao.selectStudentsByForeach(ids);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test05() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);

        List<Student> students = dao.selectStudentsByForeach2(ids);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test06() {
        Student stu1 = new Student();
        stu1.setId(1);
        Student stu2 = new Student();
        stu2.setId(3);

        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);

        List<Student> students = dao.selectStudentsByForeach3(stus);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test07() {
        Student stu1 = new Student();
        stu1.setId(1);
        Student stu2 = new Student();
        stu2.setId(3);

        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);

        List<Student> students = dao.selectStudentsBySqlFragment(stus);
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
