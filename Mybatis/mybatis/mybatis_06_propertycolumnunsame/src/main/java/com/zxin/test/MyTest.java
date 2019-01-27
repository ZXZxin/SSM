package com.zxin.test;

import com.zxin.bean.Student;
import com.zxin.dao.IStudentDao;
import com.zxin.dao.StudentDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MyTest {
    private IStudentDao dao;

    @Before
    public void before() {
        dao = new StudentDaoImpl();
    }

    @Test
    public void test01() {
        Student student = new Student("张三", 23, 93.5);
        System.out.println("插入前：student = " + student);
        dao.insertStudent(student);
        System.out.println("插入后：student = " + student);
    }

    @Test
    public void test05() {
        List<Student> students = dao.selectAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test07() {
        Student student = dao.selectStudentById(4);
        System.out.println(student);
    }
}
