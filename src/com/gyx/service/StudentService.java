package com.gyx.service;

import com.gyx.dao.StudentDao;
import com.gyx.entity.Student;

import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public  Student findStudentById(String sid) {
        Student student = studentDao.findStudentById(sid);
        return student;
    }

    public boolean insertStudent(Student student) {
        int row = studentDao.insertStudent(student);
        return row > 0;
    }

    public List<Student> finAllStudent() {
        return studentDao.findAllStudent();
    }

    public boolean deleteStudentById(String sid) {
        return studentDao.deleteStudentById(sid) > 0;
    }

    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student) > 0;
    }
}
