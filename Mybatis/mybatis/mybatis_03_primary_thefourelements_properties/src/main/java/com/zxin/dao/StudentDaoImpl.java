package com.zxin.dao;

import com.zxin.bean.Student;
import com.zxin.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class StudentDaoImpl implements IStudentDao {

    private SqlSession sqlSession;

    @Override
    public void insertStu(Student student) {
        try {
            //直接通过工具类来获取
            sqlSession = MyBatisUtils.getSqlSession();
//            sqlSession.insert("insertStudent", student); // 这个statement就是mapper.xml中的id
            sqlSession.insert("test.insertStudent", student); //加上具体的命令空间
            sqlSession.commit();  // 提交事务  --> 自动是false,必须要手动提交

        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
