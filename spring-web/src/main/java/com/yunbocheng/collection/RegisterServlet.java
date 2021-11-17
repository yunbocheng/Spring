package com.yunbocheng.collection;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import com.yunbocheng.service.StudentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author : YunboCheng
 * @date : 21:04 2021/11/17
 */
public class RegisterServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求参数以及相应信息的编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 获取请求头中的参数信息
        String num = req.getParameter("num");
        String province = req.getParameter("province");
        String city = req.getParameter("city");
        String name = req.getParameter("name");
        String ageStr = req.getParameter("age");
        String scoreStr = req.getParameter("score");
        String room = req.getParameter("room");

        // 转换数据类型
        int age = Integer.parseInt(ageStr);
        double score = Double.parseDouble(scoreStr);

        // 创建spring的容器对象
        /*
        * spring容器中的对象都是一样的，我们只需要创建一次即可。
        * 但是此时的代码，每调用一次这个servlet请求就会创建一个spring容器对象
        * 这样会占用很多的内存资源，需要改进
        * 我们使用监听器的方式，创建一次spring容器对象，并且将这个spring容器对象放入到全局作用域 ServletContext之中
        *
        * 监听器的作用：
        *   1. 创建容器对象 ClassPathXmlApplicationContext sc = new ClassPathXmlApplicationContext(config);
        *   2. 将容器对象放入到ServletContext，ServletContext.setAttribute(key,sc)
        *
        * 监听器可以自己创建也可以使用框架提供好的 ContextLoaderListener
        *
        * 在web.xml中配置监听器
        * */
        /*String config = "applicationContext.xml";
        ClassPathXmlApplicationContext sc = new ClassPathXmlApplicationContext(config);
        System.out.println("容器对象的信息=====" + sc);
        // 容器对象的信息=====org.springframework.context.support.ClassPathXmlApplicationContext@184590a0,
        // started on Wed Nov 17 21:52:08 CST 2021*/

        /*使用监听器创建spring容器对象，此时只会创建一个spring容器对象，以下是我们手动获取的*/
/*        WebApplicationContext sc = null;
        // 获取ServletContext中的容器对象，创建好的容器对象，拿来就用
        String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        Object attr= getServletContext().getAttribute(key);
        if (attr != null){
            sc = (WebApplicationContext) attr;
        }*/

        /*这里我们使用框架中的一个方法，获取spring容器对象*/
        WebApplicationContext sc = null;
        ServletContext context = getServletContext();
        sc = WebApplicationContextUtils.getRequiredWebApplicationContext(context);

        System.out.println("容器对象的信息=====" + sc);

        // 获取service
        StudentService service = (StudentService) sc.getBean("studentService");
        Student student = new Student();
        student.setAge(age);
        student.setCity(city);
        student.setNum(num);
        student.setScore(score);
        student.setRoom(room);
        student.setProvince(province);
        student.setName(name);

        int result = service.addStudent(student);
        // 跳转显示页面
        if (result == 1){
            resp.sendRedirect(req.getContextPath() + "/show.jsp");
        }else {
            HttpSession session = req.getSession();
            session.setAttribute("error","录入学生信息失败！");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
