package org.dev.fhhf.testtask.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tblemployees")
public class Employee implements Serializable {

    private static final long serialVersionUD = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empID", nullable = false, updatable = false)
    private Integer empId;

    @Column(name = "empName")
    private String empName;

    @Column(name = "empActive")
    private Boolean empActive;

    //private Integer emp_dpID; //Foreing KEY

    public Employee() {
    }

    public Employee(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Boolean getEmpActive() {
        return empActive;
    }

    public void setEmpActive(Boolean empActive) {
        this.empActive = empActive;
    }
}
