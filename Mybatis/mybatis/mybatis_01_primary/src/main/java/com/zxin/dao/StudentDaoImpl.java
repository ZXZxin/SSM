package com.zxin.dao;

import com.zxin.bean.Student;
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
        InputStream inputStream = null; //这个
        try {
            // 1. 加载主配置文件
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 2. 创建sqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //在build的时候就会自己关闭inputStream(源码中)
            // 3. 创建 sqlSession
            sqlSession = sqlSessionFactory.openSession();
            // 4. 增删改查
//            sqlSession.insert("insertStudent", student); // 这个statement就是mapper.xml中的id
            sqlSession.insert("test.insertStudent", student); //加上具体的命令空间
            sqlSession.commit();  // 提交事务  --> 自动是false,必须要手动提交

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
