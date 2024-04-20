package rw.gorv.employeemgt.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author ekire
 */
@Entity
public class Employee {
    @Id
    @Column(name="emp_id")
    private Integer empId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="start_date")
    private Date startDate;
    private boolean active;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="emp_det_id_fk")
    private EmployeeDetails empDetails;
    @OneToMany
    List<SalaryHistory> history;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public EmployeeDetails getEmpDetails() {
        return empDetails;
    }

    public void setEmpDetails(EmployeeDetails empDetails) {
        this.empDetails = empDetails;
    }

    public List<SalaryHistory> getHistory() {
        return history;
    }

    public void setHistory(List<SalaryHistory> history) {
        this.history = history;
    }
    
    public Object[] data2table(){
        return new Object[]{empId, firstName, lastName, startDate, active};
    }

    
}
