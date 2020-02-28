package org.dev.fhhf.testtask.service;

import org.dev.fhhf.testtask.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    List<Employee> getAllEmpNameStartsWith(String empName);

    Employee getEmployeeById(int empId);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
