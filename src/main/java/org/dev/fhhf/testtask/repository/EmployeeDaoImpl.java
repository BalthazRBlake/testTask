package org.dev.fhhf.testtask.repository;

import org.dev.fhhf.testtask.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public List<Employee> findAllPaginated(int page, int size) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);
        CriteriaQuery<Employee> select = criteriaQuery.select(from);

        TypedQuery<Employee> typedQuery = em.createQuery(select);
        typedQuery.setFirstResult( (page - 1) * size );
        typedQuery.setMaxResults( size );
        List<Employee> paginatedEmployees = typedQuery.getResultList();

        return paginatedEmployees;
    }

    @Override
    @Transactional(readOnly = true)
    public Long countTotalEntries() {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(Employee.class)));
        Long count = em.createQuery(countQuery).getSingleResult();

        return count;
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
