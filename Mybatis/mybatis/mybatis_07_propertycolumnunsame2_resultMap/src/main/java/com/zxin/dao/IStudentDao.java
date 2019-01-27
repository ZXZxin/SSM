package com.zxin.dao;

import com.zxin.bean.Student;

import java.util.List;

public interface IStudentDao {
    void insertStudent(Student student);

    List<Student> selectAllStudents();

    Student selectStudentById(int id);
}
