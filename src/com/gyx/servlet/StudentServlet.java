package com.gyx.servlet;

import com.gyx.entity.Student;
import com.gyx.service.StudentService;
import com.gyx.utils.PageTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends BaseServlet {
    private StudentService studentService = new StudentService();

    private void batchDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取到所有的id
        String ids = req.getParameter("ids");
        boolean isSuccess = studentService.batchDelete(ids);
        if (isSuccess){
            resp.sendRedirect("student?func=findAllStudent");
        }
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        String gender = req.getParameter("gender");
        String degree = req.getParameter("degree");
        String mark = req.getParameter("mark");
        String[] hobbies = req.getParameterValues("hobby");
        Student student = new Student(Integer.valueOf(sid), sname, gender, Arrays.toString(hobbies), degree, mark);
        boolean isSuccess = studentService.updateStudent(student);
        if (isSuccess){
            resp.sendRedirect("student?func=findAllStudent");
        }

    }

    private void findStudentById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        Student student = studentService.findStudentById(sid);
        req.setAttribute("student", student);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    private void deleteStudentById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sid = req.getParameter("sid");
        boolean isSuccess = studentService.deleteStudentById(sid);
        if (isSuccess) {
            resp.sendRedirect("student?func=findAllStudent");
        } else {
            resp.setHeader("refresh", "0,url=show.jsp");
        }
    }

    private void findAllStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int totalCount = studentService.selectStudentCount();
        String currentPage = req.getParameter("currentPage");
        PageTools pageTools = new PageTools(totalCount,currentPage,3);
        List<Student> stus = studentService.finAllStudent(pageTools);
        req.setAttribute("stus",stus);
        req.setAttribute("pageTool",pageTools);
        req.getRequestDispatcher("show.jsp").forward(req,resp);
//        resp.setHeader("Content-Type", "text/html;charset=utf-8");
//        PrintWriter writer = resp.getWriter();
//        writer.write("<table border=\"1\" cellspacing = \"0\" cellpadding = \"10\" width = \"1000\" align=\"center\">\n" +
//                "<caption>\n" +
//                "<h2>学生信息表</h2>\n" +
//                "</caption>\n" +
//                "<tr>\n" +
//                "<th>姓名</th>\n" +
//                "<th>性别</th>\n" +
//                "<th>爱好</th>\n" +
//                "<th>学历</th>\n" +
//                "<th>简介</th>\n" +
//                "</tr>");
//        //遍历学生拿到数据
//        for (Student student : list) {
//            writer.write("<tr align=\"center\">\n" +
//                    "<td>" + student.getSname() + "</td>\n" +
//                    "<td>" + student.getGender() + "</td>\n" +
//                    "<td>" + student.getHobby().substring(1, student.getHobby().length() - 1) + "</td>\n" +
//                    "<td>" + student.getDegree() + "</td>\n" +
//                    "<td>" + student.getMark() + "</td>\n" +
//                    "</tr>");
//        }
//        writer.write("</table>");
        //1.将数据存储到request中
//        req.setAttribute("stus", stus);
//        //2.重定向到新的页面,因为要携带数据，所以用请求转发
//        req.getRequestDispatcher("show.jsp").forward(req, resp);

    }

    private void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String sname = req.getParameter("sname");
        String gender = req.getParameter("gender");
        String degree = req.getParameter("degree");
        String mark = req.getParameter("mark");
        String[] hobbies = req.getParameterValues("hobby");
        Student student = new Student(sname, gender, Arrays.toString(hobbies), degree, mark);
        boolean isSuccess = studentService.insertStudent(student);
        if (isSuccess) {
//            resp.setHeader("refresh", "0;url=student.jsp");
            resp.sendRedirect("student.jsp");
        } else {
//            resp.setHeader("refresh", "0;insertStudent.jsp");
            req.setAttribute("errorMsg", "添加失败，请重写添加");
            req.getRequestDispatcher("insert.jsp").forward(req, resp);
        }
    }
}
