package org.dev.fhhf.testtask.repo;

import org.dev.fhhf.testtask.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDaoImpl  implements  EmployeeDao{

    @PersistenceContext(unitName="JPASpring")
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAllEmployees() {
        return em.createNamedQuery("Employees.findAll")
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAllEmployeesNameStartsWith(String empName) {
        return em.createNamedQuery("Employees.nameStartsWith")
                .setParameter("nameStartsWith", empName.concat("%"))
                .getResultList();
    }

    @Override
    public Employee findEmployeeById(int empId) {
        return (Employee) em.createNamedQuery("Employee.findById")
                .setParameter("empId", empId)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Employee insertEmployee(Employee employee) {
        em.persist(employee);
        return employee;
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee){
        em.merge(employee);
        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee){
        em.remove( em.merge(employee) );
    }
}
