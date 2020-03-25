package org.dev.fhhf.testtask.repository;

import org.dev.fhhf.testtask.model.Department;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @PersistenceContext(unitName="JPASpring")
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Department> findAllDepartments() {
        return em.createNamedQuery("Department.findAll")
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Department findDepartmentById(int dpId) {
        return (Department) em.createNamedQuery("Department.findById")
                .setParameter("dpId", dpId)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Department insertDepartment(Department department) {
        em.persist(department);
        return department;
    }

    @Override
    @Transactional
    public Department updateDepartment(Department department) {
        em.merge(department);
        return department;
    }

    @Override
    @Transactional
    public void deleteDepartment(Department department) {
        em.remove( em.merge(department) );
    }
}
