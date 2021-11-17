package com.yunbocheng.service.impl;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import com.yunbocheng.service.StudentService;

import java.util.List;

/**
 * @author : YunboCheng
 * @date : 9:45 2021/11/16
 */
public class StudentServiceImpl implements StudentService {

    // 实现这两个放需要调用dao层中的方法，所以需要在这来创建一个dao对象
    private StudentDao studentDao;

    // 使用set注入，进行对象的赋值，但是需要的是提供set方法
    public void setStudentDao(StudentDao studentDao){
        this.studentDao = studentDao;
    }


    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> queryStudents() {
        return studentDao.selectStudents();
    }
}
