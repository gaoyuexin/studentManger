package com.gyx.entity;

public class Doctor {
    private Integer did;
    private String dname;
    private String hobby;
    private Integer department;

    public Doctor(Integer did, String dname, String hobby, Integer department) {
        this.did = did;
        this.dname = dname;
        this.hobby = hobby;
        this.department = department;
    }

    public Doctor() {
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", hobby='" + hobby + '\'' +
                ", department=" + department +
                '}';
    }
}
