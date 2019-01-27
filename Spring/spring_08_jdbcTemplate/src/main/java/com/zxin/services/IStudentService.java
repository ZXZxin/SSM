package com.zxin.services;

import com.zxin.beans.Student;

import java.util.List;

public interface IStudentService {
	void addStudent(Student student);
	void removeById(int id);
	void modifyStudent(Student student);
	
	List<String> findAllStudentsNames();
	String findStudentNameById(int id);
	
	List<Student> findAllStudents();
	Student findStudentById(int id);
}
