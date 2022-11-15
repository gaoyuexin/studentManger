package com.gyx.dao;

import com.gyx.entity.Student;
import com.gyx.utils.PageTools;

import java.util.List;

public class StudentDao extends BaseDao<Student>{

    public int insertStudent(Student student) {
        return dml("insert into student values (null,?,?,?,?,?)",student.getSname(),
                student.getGender(),student.getHobby(),student.getDegree(),student.getMark()
                );
    }

    public List<Student> findAllStudent(PageTools pageTools) {
        return moreLine("select * from student limit ?,?",
                Student.class,pageTools.getStartIndex(),pageTools.getPageSize());
    }

    public int deleteStudentById(String sid) {
        return dml("delete from student where sid = ?",sid);
    }

    public Student findStudentById(String sid) {
        return oneLine("select * from student where sid = ?",Student.class,sid);
    }

    public int updateStudent(Student student) {
        return dml("update student set sname = ?, gender = ?,hobby = ?,degree = ?,mark = ? where sid = ?",
                student.getSname(),student.getGender(),student.getHobby(),student.getDegree(),
                student.getMark(),student.getSid());
    }

    public Object selectStudentCount() {
        return singleData("select count(*) from student");
    }

    public int batchDelete(String ids) {
        return dml("delete from student where sid in (" + ids + ")");
    }
}
