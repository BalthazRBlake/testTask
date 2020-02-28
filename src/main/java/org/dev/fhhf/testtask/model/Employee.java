package org.dev.fhhf.testtask.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employees.nameStartsWith", query = "SELECT e FROM Employee e WHERE e.empName LIKE :nameStartsWith"),
        @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.empId = :empId")
})
@Table(name = "tblemployees")
@ApiModel(description = "Employee details")
public class Employee implements Serializable {

    private static final long serialVersionUD = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empID", nullable = false, updatable = false)
    @ApiModelProperty(example = "Not needed")
    private Integer empId;

    @Column(name = "empName")
    @ApiModelProperty(required = true, example = "Pete")
    private String empName;

    @Column(name = "empActive")
    @ApiModelProperty(required = true)
    private Boolean empActive;

    @OneToOne
    @JoinColumn(name = "emp_dpID")
    private Department department;

    public Employee() {
    }

    public Employee(Integer empId) {
        this.empId = empId;
    }

    public Employee(String empName, Boolean empActive) {
        this.empName = empName;
        this.empActive = empActive;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empActive=" + empActive +
                ", department=" + department +
                '}';
    }
}
