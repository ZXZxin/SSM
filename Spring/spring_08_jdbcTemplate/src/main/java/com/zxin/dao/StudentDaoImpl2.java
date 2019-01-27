package com.zxin.dao;

import java.util.List;

import com.zxin.beans.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


// 这个类纯属是为了表明JDBCTemplate 是多例的，不能这样写成成员变量，必须在每次用的时候都要获取,
// 代码不能写为下面的形式
public class StudentDaoImpl2 extends JdbcDaoSupport implements IStudentDao {
	private JdbcTemplate jt;
	
	public StudentDaoImpl2() {
		jt = this.getJdbcTemplate();
	}

	@Override
	public void insertStudent(Student student) {
		String sql = "insert into student(name,age) values(?,?)";
		jt.update(sql, student.getName(), student.getAge());
	}

	@Override
	public void deleteById(int id) {
		String sql = "delete from student where id=?";
		jt.update(sql, id);
	}

	@Override
	public void updateStudent(Student student) {
		String sql = "update student set name=?, age=? where id=?";
		jt.update(sql, student.getName(), student.getAge(), student.getId());
	}

	@Override
	public List<String> selectAllStudentsNames() {
		String sql = "select name from student";
		return jt.queryForList(sql, String.class);
	}

	@Override
	public String selectStudentNameById(int id) {
		String sql = "select name from student where id=?";
		return jt.queryForObject(sql, String.class, id);
	}

	@Override
	public List<Student> selectAllStudents() {
		String sql = "select id,name,age from student";
		return jt.query(sql, new StudentRowMapper());
	}

	@Override
	public Student selectStudentById(int id) {
		String sql = "select id,name,age from student where id=?";
		return jt.queryForObject(sql, new StudentRowMapper(), id);
	}

}
