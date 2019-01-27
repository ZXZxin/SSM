package com.zxin.dao;

import com.zxin.beans.Student;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component("myStudentDao")
public interface IStudentDao {
	void insertStudent(Student student);
	void deleteById(int id);
	void updateStudent(Student student);
	
	List<Student> selectAllStudents();
	Student selectStudentById(int id);
}
