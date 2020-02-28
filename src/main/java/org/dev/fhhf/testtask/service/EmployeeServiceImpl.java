package org.dev.fhhf.testtask.service;

import org.dev.fhhf.testtask.model.Employee;
import org.dev.fhhf.testtask.repo.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    @Override
    public List<Employee> getAllEmpNameStartsWith(String empName) {
        return employeeDao.findAllEmployeesNameStartsWith(empName);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeDao.findEmployeeById(empId);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }
}
