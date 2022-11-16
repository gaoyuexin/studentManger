package com.gyx.servlet;

import com.alibaba.fastjson.JSON;
import com.gyx.entity.Doctor;
import com.gyx.service.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/doctor")
public class DoctorServlet extends BaseServlet {
    private DoctorService doctorService = new DoctorService();

    private void findDoctorByDepartment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String department = req.getParameter("department");
        List<Doctor> doctors = doctorService.findDoctorByDepartment(department);
        String s = JSON.toJSONString(doctors);
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        resp.getWriter().write(s);
    }
}
