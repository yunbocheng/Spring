package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : YunboCheng
 * @date : 14:37 2021/11/16
 */
public class TestUpdateByNum {

    @Test
    public void testUpdateByNum(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao) ac.getBean("studentDao");
        Map<String,Object> map = new HashMap<>();
        map.put("num1","110522");
        map.put("num2","110520");
        map.put("province","山西省");
        map.put("city","太原市");
        map.put("name","王蓉");
        map.put("age",30);
        map.put("score",34.6);
        map.put("room","Java1004");
        int i = dao.updateStudentByNum(map);
        if (i == 1){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }
    }
}
