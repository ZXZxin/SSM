package com.zxin.di01;

public class School {

    private String name;

    public void setName(String name) {
        System.out.println("调用School的setName()方法!");
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                '}';
    }
}
