package rw.gorv.employeemgt.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.gorv.employeemgt.model.EmployeeDetails;

/**
 *
 * @author jeremie
 */
public class EmployeeDetailsDao {
    public EmployeeDetails registerEmployeeDetails(EmployeeDetails empDetailsObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(empDetailsObj);
            tr.commit();
            ss.close();
            return empDetailsObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public EmployeeDetails updateEmployeeDetails(EmployeeDetails empDetailsObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.update(empDetailsObj);
            tr.commit();
            ss.close();
            return empDetailsObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public EmployeeDetails deleteEmployeeDetails(EmployeeDetails empDetailsObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.delete(empDetailsObj);
            tr.commit();
            ss.close();
            return empDetailsObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public EmployeeDetails findEmployeeDetailsById(EmployeeDetails empDetailsObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            EmployeeDetails empDetails = (EmployeeDetails) ss.get(EmployeeDetails.class, empDetailsObj.getEmpDetId());
            ss.close();
            return empDetails;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<EmployeeDetails> retrieveAllEmployeeDetails(EmployeeDetails empDetailsObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<EmployeeDetails> empDetailsloyees = ss.createQuery("SELECT empDetails FROM EmployeeDetails empDetails").list();
            ss.close();
            return empDetailsloyees;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
