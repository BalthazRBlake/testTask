package org.dev.fhhf.testtask.repo;

import org.dev.fhhf.testtask.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAllEmployees();

    List<Employee> findAllPaginated(int currentEmpId, int limit);

    Long countTotalEntries();

    List<Employee> findAllEmployeesNameStartsWith(String empName);

    Employee findEmployeeById(int empId);

    Employee insertEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}