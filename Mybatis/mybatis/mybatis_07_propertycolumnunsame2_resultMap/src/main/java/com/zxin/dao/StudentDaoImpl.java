package com.zxin.dao;

import com.zxin.bean.Student;
import com.zxin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements IStudentDao {

    private SqlSession sqlSession;

    @Override
    public void insertStudent(Student student) {
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.insert("insertStudent", student);
            sqlSession.commit();
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            students = sqlSession.selectList("selectAllStudents");
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return students;
    }

    @Override
    public Student selectStudentById(int id) {
        Student student = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            student = sqlSession.selectOne("selectStudentById", id);
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return student;
    }

}
