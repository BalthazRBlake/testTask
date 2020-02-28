package org.dev.fhhf.testtask.service;

import org.dev.fhhf.testtask.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Department getDepartmentById(int dpId);

    Department createDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartment(Department department);
}
