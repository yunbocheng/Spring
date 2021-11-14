package com.yunbocheng.di06;

public class Student {
    private String name;
    private int age;
    private School school;

    // spring默认调用实体类的无参构造方法来创建对象
    public Student() {
    }

    /*
        创建一个有参构造，测试di中的第二种方式赋值，通过构造方法进行属性的赋值。
    */

    public Student(String MyName, int MyAge, School MySchool) {
        System.out.println(MySchool); // 输出这个学校信息
        this.name = MyName;
        this.age = MyAge;
        this.school = MySchool;
    }


    public void setSchool(School school) {
        this.school = school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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
