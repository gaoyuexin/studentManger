package com.gyx.dao;

import com.gyx.entity.Doctor;

import java.util.List;

public class DoctorDao extends BaseDao<Doctor>{
    public List<Doctor> findDoctorByDepartment(String department) {
        return moreLine("select * from doctor where department = ?",Doctor.class,department);
    }
}
