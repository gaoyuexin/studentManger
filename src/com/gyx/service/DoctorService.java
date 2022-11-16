package com.gyx.service;

import com.gyx.dao.DoctorDao;
import com.gyx.entity.Doctor;

import java.util.List;

public class DoctorService {
    private DoctorDao doctorDao = new DoctorDao();
    public List<Doctor> findDoctorByDepartment(String department) {
        return  doctorDao.findDoctorByDepartment(department);
    }
}
