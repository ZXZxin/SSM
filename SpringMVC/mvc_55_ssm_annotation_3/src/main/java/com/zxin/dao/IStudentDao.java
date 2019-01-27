package com.zxin.dao;

import com.zxin.beans.Student;
import org.apache.ibatis.annotations.Insert;

public interface IStudentDao {

    @Insert("insert into student(name,age) values(#{name},#{age})")
    public void insertStudent(Student student);

}
