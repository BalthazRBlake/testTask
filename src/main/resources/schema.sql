--CREATE DATABASE IF NOT EXISTS testtask;
--USE testtask;

CREATE TABLE IF NOT EXISTS tblemployees (
    empID   INT NOT NULL AUTO_INCREMENT,
    empName VARCHAR(45) NOT NULL,
    empActive TINYINT,
    emp_dpID,
    FOREIGN KEY (emp_dpID) REFERENCES tbldepartments(dpID),
    PRIMARY KEY (empID)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS tbldepartments (
    dpID   INT NOT NULL AUTO_INCREMENT,
    dpName VARCHAR(45) NOT NULL,
    PRIMARY KEY (dpID)
) engine=InnoDB;
