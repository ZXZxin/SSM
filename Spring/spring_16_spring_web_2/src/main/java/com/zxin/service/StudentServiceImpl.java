package com.zxin.service;

import com.zxin.beans.Student;
import com.zxin.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;


public class StudentServiceImpl implements IStudentService {
	private StudentDao dao;
	
	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	public void addStudent(Student student) {
		dao.insertStudent(student);
	}

	public void removeById(int id) {
		dao.deleteById(id);
	}

	public void modifyStudent(Student student) {
		dao.updateStudent(student);
	}

	public List<String> findAllStudentsNames() {
		List<String> names = new ArrayList<String>();
		List<Student> students = this.findAllStudents();
		for (Student student : students) {
			names.add(student.getName());
		}
		return names;
	}

	public String findStudentNameById(int id) {
		Student student = this.findStudentById(id);
		return student.getName();
	}

	public List<Student> findAllStudents() {
		return dao.selectAllStudents();
	}

	public Student findStudentById(int id) {
		return dao.selectStudentById(id);
	}

}
