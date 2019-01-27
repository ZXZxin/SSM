package com.zxin.di01;

public class Student {

    private String name;

    private Integer age;

    private School school;

    public void setName(String name) {
        System.out.println("调用Student的 setName()方法!");
        this.name = name;
    }

    public void setAge(Integer age) {
        System.out.println("调用Student的 setAge()方法!");
        this.age = age;
    }

    public void setSchool(School school) {
        System.out.println("调用Student的 setSchool()方法!");
        this.school = school;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
