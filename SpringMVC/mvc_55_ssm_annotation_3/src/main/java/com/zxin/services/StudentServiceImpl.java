package com.zxin.services;

import com.zxin.beans.Student;
import com.zxin.dao.IStudentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Resource(name = "IStudentDao") //红线不要管
    private IStudentDao dao;

    // 为了构造注入
    public void setDao(IStudentDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void addStudent(Student student) {
        dao.insertStudent(student);
    }
}
