package com.zxin.dao;

import java.util.List;

import com.zxin.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;


public interface IStudentDao {

	@Insert(value={"insert into mybatis_01_student(name,age,score) values(#{name}, #{age}, #{score})"})
	void insertStudent(Student student);
	
	@Insert("insert into mybatis_01_student(name,age,score) values(#{name}, #{age}, #{score})")
	@SelectKey(statement="select @@identity", resultType=int.class, keyProperty="id", before=false)
	void insertStudentCacheId(Student student);
	
	@Delete(value="delete from mybatis_01_student where id=#{xxx}")
	void deleteStudentById(int id);
	
	@Update("update mybatis_01_student set name=#{name}, age=#{age}, score=#{score} where id=#{id}")
	void updateStudent(Student student);
	
	@Select("select id,name,age,score from mybatis_01_student")
	List<Student> selectAllStudents();
	
	@Select("select id,name,age,score from mybatis_01_student where id=#{jjj}")
	Student selectStudentById(int id);
	
	@Select("select id,name,age,score from mybatis_01_student where name like '%' #{xxx} '%'")
	List<Student> selectStudentsByName(String name);
}
