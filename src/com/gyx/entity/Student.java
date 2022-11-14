package com.gyx.entity;

public class Student {
    private Integer sid;
    private String sname;
    private String gender;
    private String hobby;
    private String degree;
    private String mark;

    public Student() {
    }

    public Student(String sname, String gender, String hobby, String degree, String mark) {
        this.sname = sname;
        this.gender = gender;
        this.hobby = hobby;
        this.degree = degree;
        this.mark = mark;
    }

    public Student(Integer sid, String sname, String gender, String hobby, String degree, String mark) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.hobby = hobby;
        this.degree = degree;
        this.mark = mark;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", hobby='" + hobby + '\'' +
                ", degree='" + degree + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
