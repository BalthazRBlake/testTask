package org.dev.fhhf.testtask.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbldepartments")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpID", nullable = false, updatable = false)
    private Integer dpId;

    @Column(name = "dpName")
    private String dpName;

    public Department() {
    }

    public Department(Integer dpId) {
        this.dpId = dpId;
    }

    public Department(Integer dpId, String dpName) {
        this.dpId = dpId;
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
}
