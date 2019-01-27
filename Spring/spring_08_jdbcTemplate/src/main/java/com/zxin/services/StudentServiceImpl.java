package com.zxin.services;

import com.zxin.beans.Student;
import com.zxin.dao.IStudentDao;

import java.util.List;


public class StudentServiceImpl implements IStudentService {
	private IStudentDao dao;
	
	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}

	@Override
	public void addStudent(Student student) {
		dao.insertStudent(student);
	}

	@Override
	public void removeById(int id) {
		dao.deleteById(id);
	}

	@Override
	public void modifyStudent(Student student) {
		dao.updateStudent(student);
	}

	@Override
	public List<String> findAllStudentsNames() {
		return dao.selectAllStudentsNames();
	}

	@Override
	public String findStudentNameById(int id) {
		return dao.selectStudentNameById(id);
	}

	@Override
	public List<Student> findAllStudents() {
		return dao.selectAllStudents();
	}

	@Override
	public Student findStudentById(int id) {
		return dao.selectStudentById(id);
	}

}
