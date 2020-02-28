package org.dev.fhhf.testtask.service;

import org.dev.fhhf.testtask.model.Department;
import org.dev.fhhf.testtask.repo.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.findAllDepartments();
    }

    @Override
    public Department getDepartmentById(int dpId) {
        return departmentDao.findDepartmentById(dpId);
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentDao.insertDepartment(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        departmentDao.deleteDepartment(department);
    }
}
