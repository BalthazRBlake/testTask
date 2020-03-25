package org.dev.fhhf.testtask.repository;

import org.dev.fhhf.testtask.model.Department;

import java.util.List;

public interface DepartmentDao {

    List<Department> findAllDepartments();

    Department findDepartmentById(int dpId);

    Department insertDepartment(Department department);

    Department updateDepartment(Department department);

    void deleteDepartment(Department department);
}
