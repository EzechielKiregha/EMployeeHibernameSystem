package rw.gorv.employeemgt.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.gorv.employeemgt.model.Employee;

/**
 *
 * @author ekire
 */
public class EmployeeDao {
     public Employee registerEmployee(Employee empObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            //create Transaction
            Transaction tr = ss.beginTransaction();
            //perform action
            ss.save(empObj);
            //commit 
            tr.commit();
            //close session
            ss.close();
            return empObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public Employee updateEmployee(Employee empObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            //create Transaction
            Transaction tr = ss.beginTransaction();
            //perform action
            ss.update(empObj);
            //commit 
            tr.commit();
            //close session
            ss.close();
            return empObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public Employee deleteEmployee(Employee empObj) {
        Session ss = null;
        Transaction tr = null;
        try {
            ss = HibernateUtil.getSessionFactory().openSession();
            tr = ss.beginTransaction();
            ss.delete(empObj);
            tr.commit();
            return empObj;
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.printStackTrace();
            return null;
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
    }
    
//    public Employee findEmployeeById(Employee empObj){
//        try{
//            // create session
//            Session ss = HibernateUtil.getSessionFactory().openSession();
//            Query query = ss.createQuery("SELECT e FROM Employee e LEFT JOIN FETCH e.empDetails WHERE e.empId = :empId");
//            query.setParameter("empId", empObj.getEmpId());
//            Employee theEmployee = (Employee) query.uniqueResult();
//            ss.close();
//            return theEmployee;
//        } catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }


    
    public Employee findEmployeeById(Employee empObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Employee theEmployee = (Employee) ss.get(Employee.class, empObj.getEmpId());
            ss.close();
            return theEmployee;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Employee> retrieveAllEMployee(){
        try{
            Session ss= HibernateUtil.getSessionFactory().openSession();
            List<Employee> employees = ss.createQuery("SELECT emp FROM Employee emp").list();
            ss.close();
            return employees;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
