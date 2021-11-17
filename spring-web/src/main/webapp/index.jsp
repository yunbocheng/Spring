<%--
  Created by IntelliJ IDEA.
  User: YunboCheng
  Date: 2021/11/17
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% application.setAttribute("path",request.getContextPath());%>
<html>
<head>
    <title>注册学生信息</title>
</head>
<body>
    <p align="center">注册学生</p>
    <div style="color: red;font-size: 40px">${error}</div>
    <form action="${path}/reg" method="post">
        <table border="2px" align="center">
            <tr>
                <td>
                    学号：
                </td>
                <td>
                    <input type="text" name="num" />
                </td>
            </tr>
            <tr>
                <td>
                    省份：
                </td>
                <td>
                    <input type="text" name="province" />
                </td>
            </tr>
            <tr>
                <td>
                    城市：
                </td>
                <td>
                    <input type="text" name="city" />
                </td>
            </tr>
            <tr>
                <td>
                    姓名：
                </td>
                <td>
                    <input type="text" name="name" />
                </td>
            </tr>
            <tr>
                <td>
                    年龄：
                </td>
                <td>
                    <input type="text" name="age" />
                </td>
            </tr>
            <tr>
                <td>
                    分数：
                </td>
                <td>
                    <input type="text" name="score" />
                </td>
            </tr>
            <tr>
                <td>
                    班级：
                </td>
                <td>
                    <input type="text" name="room" />
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="录入信息">
                </td>
                <td>
                    <input type="reset" value="重置信息" />
                </td>
            </tr>

        </table>
    </form>
</body>
</html>
