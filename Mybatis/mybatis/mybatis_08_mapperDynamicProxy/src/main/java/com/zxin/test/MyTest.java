package com.zxin.test;

import com.zxin.bean.Student;
import com.zxin.dao.IStudentDao;
import com.zxin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * 注意这个和之前的有很大的不同，这里使用的是SqlSession中的getMapper获取的Mapper
 * 和之前的实现类有很大的不同
 */
public class MyTest {
    private IStudentDao dao;
    private SqlSession sqlSession;

    @Before
    public void before() {
        sqlSession = MyBatisUtils.getSqlSession();
        // 通过sqlSession的getMapper方法获取指定接口的dao
        dao = sqlSession.getMapper(IStudentDao.class);
    }

    //使用after 关闭
    @After
    public void after() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void test01() {
        Student student = new Student("张三", 23, 93.5);
        System.out.println("插入前：student = " + student);
        dao.insertStudent(student);
        System.out.println("插入后：student = " + student);
        // 最后要记得提交 (没有了 实现类， 就要自己提交了)
        sqlSession.commit();
    }

    @Test
    public void test02() {
        Student student = new Student("张三", 23, 93.5);
        System.out.println("插入前：student = " + student);
        dao.insertStudentCacheId(student);
        System.out.println("插入后：student = " + student);
        sqlSession.commit();
    }

    @Test
    public void test03() {
        dao.deleteStudentById(26);
        sqlSession.commit();
    }

    @Test
    public void test04() {
        Student student = new Student("张三", 23, 93.5);
        student.setId(28);
        dao.updateStudent(student);
        sqlSession.commit();
    }

    @Test
    public void test05() {
        List<Student> students = dao.selectAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // 注意这里不能使用了，因为我们已经没有了实现类，而 selectAllStudentMap这个id 没有出现在mapper.xml文件中
    /*
    @Test
    public void test06() {
        Map<String, Object> map = dao.selectAllStudentsMap();
        System.out.println(map.get("张三"));
    }
    */
    @Test
    public void test07() {
        Student student = dao.selectStudentById(11);
        System.out.println(student);
    }

    @Test
    public void test08() {
        List<Student> students = dao.selectStudentsByName("张");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
