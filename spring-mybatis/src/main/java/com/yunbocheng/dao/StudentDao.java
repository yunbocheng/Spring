package com.yunbocheng.dao;

import com.yunbocheng.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @author : YunboCheng
 * @date : 22:11 2021/11/15
 */
public interface StudentDao {

    // 添加学生
    int insertStudent(Student student);

    // 查询全部学生
    List<Student> selectStudents();

    // 删除学生对象
    int deleteStudent(@Param("num") String num);

    // 修改学生信息
    @Update("update tab_student set age = #{age},score=#{score},room = #{room} where num = #{num}")
    int updateStudent(Student student);

    // 根据学生的学号修改学生的全部信息(包括学号).因为此时设计到两个num，此时使用map集合的思想
    @Update("update tab_student set num = #{num1},province=#{province},city=#{city},name=#{name},age=#{age},score=#{score},room=#{room} where num= #{num2}")
    int updateStudentByNum(Map<String,Object> map);

    // 根据num以及班级查询学生信息
    @Select("select * from tab_student where num = #{num} and room = #{room}")
    Student selectByNumAndRoom(@Param("num")String num,@Param("room")String room);

}
