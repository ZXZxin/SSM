package com.zxin.dao;


import com.zxin.bean.Student;

public interface IStudentDao {
	
	void insertStudent(Student student);
	Student selectStudentById(int id);
	Student selectStudentById2(int id);
}
