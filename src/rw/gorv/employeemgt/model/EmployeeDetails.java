/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gorv.employeemgt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ekire
 */
@Entity
@Table(name="employee_details")
public class EmployeeDetails {
    @Id
    @Column(name="emp_det_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empDetId;
    @Column(name="emmergency_contact")
    private String emmergencyContact;
    @Column(name="phone_number")
    private String phoneNumber;
    @OneToOne(mappedBy = "empDetails", cascade = CascadeType.ALL)
    private Employee employee;

    public EmployeeDetails(Integer empDetId) {
        this.empDetId = empDetId;
    }

    public EmployeeDetails() {
    }
    
    public Integer getEmpDetId() {
        return empDetId;
    }

//    public void setEmpDetId(Integer empDetId) {
//        this.empDetId = empDetId;
//    }

    public String getEmmergencyContact() {
        return emmergencyContact;
    }

    public void setEmmergencyContact(String emmergencyContact) {
        this.emmergencyContact = emmergencyContact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
   
}
