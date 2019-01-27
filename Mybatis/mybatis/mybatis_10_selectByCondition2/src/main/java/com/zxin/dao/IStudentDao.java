package com.zxin.dao;

import com.zxin.bean.Student;

import java.util.List;
import java.util.Map;

public interface IStudentDao {

    List<Student> selectStudentsByCondition(String name, int age);
}
