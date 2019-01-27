package com.zxin.test;

import com.zxin.bean.Student;
import com.zxin.dao.IStudentDao;
import com.zxin.dao.StudentDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class MyTest {
    private IStudentDao dao;

    @Before
    public void before() {
        dao = new StudentDaoImpl();
    }

    @Test
    public void test01() {
        Student student = new Student("田七", 27, 97);
        System.out.println("插入前student = " + student);
        dao.insertStudent(student);
        System.out.println("插入后student = " + student);
    }

    @Test
    public void test02() {
        Student student = new Student("张三", 23, 93.5);
        System.out.println("插入前studentstudent = " + student);
        dao.insertStudentCacheId(student); //返回一个id  使用select @@identity
        System.out.println("插入后student = " + student); //这个可以输出id
    }

    @Test
    public void test03() {
        dao.deleteStudentById(10);
    }

    @Test
    public void test04() {
        Student student = new Student("张三", 23, 93.5);
        student.setId(28);
        dao.updateStudent(student);
    }

    @Test
    public void test05() {
        List<Student> students = dao.selectAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test06() {
        Map<String, Object> map = dao.selectAllStudentsMap();
        System.out.println(map.get("张三"));
    }

    @Test
    public void test07() {
        Student student = dao.selectStudentById(5);
        System.out.println(student);
    }

    // 模糊查询
    @Test
    public void test08() {
        List<Student> students = dao.selectStudentsByName("张");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
