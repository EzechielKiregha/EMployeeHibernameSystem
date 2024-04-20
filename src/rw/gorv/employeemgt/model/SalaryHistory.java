package rw.gorv.employeemgt.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ekire
 */
@Entity
@Table(name="employee_history")
public class SalaryHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "salary_id")
    private Integer salaryId;
    @Column(name= "salary_amount")
    private Double salaryAmount;
    @Column(name= "start_date")
    private Date startDate;
    @Column(name= "end_date")
    private Date endDate;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "emp_id_fk")
    private Employee employee;

    public SalaryHistory(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public SalaryHistory() {
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(Double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
  
    
}
