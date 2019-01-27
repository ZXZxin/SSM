package com.zxin.services;

import com.zxin.beans.Student;
import com.zxin.dao.IStudentDao;

public class StudentServiceImpl implements IStudentService {

    private IStudentDao dao;

    // 为了构造注入
    public void setDao(IStudentDao dao) {
        this.dao = dao;
    }

    @Override
    public void addStudent(Student student) {
        dao.insertStudent(student);
    }
}
