package com.zxin.dao;

import java.util.List;

import com.zxin.beans.Student;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class StudentDaoImpl extends JdbcDaoSupport implements IStudentDao {

	@Override
	public void insertStudent(Student student) {
		String sql = "insert into student(name,age) values(?,?)";
		this.getJdbcTemplate().update(sql, student.getName(), student.getAge());
	}

	@Override
	public void deleteById(int id) {
		String sql = "delete from student where id=?";
		this.getJdbcTemplate().update(sql, id);
	}

	@Override
	public void updateStudent(Student student) {
		String sql = "update student set name=?, age=? where id=?";
		this.getJdbcTemplate().update(sql, student.getName(), student.getAge(), student.getId());
	}

	@Override
	public List<String> selectAllStudentsNames() {
		String sql = "select name from student";
		return this.getJdbcTemplate().queryForList(sql, String.class);
	}

	@Override
	public String selectStudentNameById(int id) {
		String sql = "select name from student where id=?";
		return this.getJdbcTemplate().queryForObject(sql, String.class, id);
	}

	@Override
	public List<Student> selectAllStudents() {
		String sql = "select id,name,age from student";
		return this.getJdbcTemplate().query(sql, new StudentRowMapper());
	}

	@Override
	public Student selectStudentById(int id) {
		String sql = "select id,name,age from student where id=?";
		return this.getJdbcTemplate().queryForObject(sql, new StudentRowMapper(), id);
	}

}
