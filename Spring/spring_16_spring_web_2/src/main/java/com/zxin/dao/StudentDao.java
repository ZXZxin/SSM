package com.zxin.dao;

import com.zxin.beans.Student;

import java.util.List;


public interface StudentDao {
	void insertStudent(Student student);
	void deleteById(int id);
	void updateStudent(Student student);
	
	List<Student> selectAllStudents();
	Student selectStudentById(int id);
}
