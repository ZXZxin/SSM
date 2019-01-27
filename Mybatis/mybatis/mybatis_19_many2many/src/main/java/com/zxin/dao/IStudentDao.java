package com.zxin.dao;


import com.zxin.bean.Student;

public interface IStudentDao {
	Student selectStudentById(int sid); // 通过学生的id 查询到他所选择的课程
}
