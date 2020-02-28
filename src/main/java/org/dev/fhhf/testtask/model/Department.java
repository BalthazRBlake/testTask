package org.dev.fhhf.testtask.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
        @NamedQuery(name = "Department.findById", query = "SELECT d FROM Department d WHERE d.dpId = :dpId")
})
@Table(name = "tbldepartments")
public class Department implements Serializable {

    private static final long serialVersionUD = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpID", nullable = false, updatable = false)
    @ApiModelProperty(notes = "Needed to Update an Employee | Not needed to create a new department")
    private Integer dpId;

    @Column(name = "dpName")
    @ApiModelProperty(required = true)
    private String dpName;

    public Department() {
    }

    public Department(Integer dpId) {
        this.dpId = dpId;
    }

    public Department(String dpName) {
        this.dpName = dpName;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public String getDpName() {
        return dpName;
    }

    public void setDpName(String dpName) {
        this.dpName = dpName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dpId=" + dpId +
                ", dpName='" + dpName + '\'' +
                '}';
    }

}
