
package rw.gorv.employeemgt.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.gorv.employeemgt.model.SalaryHistory;

/**
 *
 * @author jeremie
 */
public class SalaryHistoryDao {
    public SalaryHistory registerSalaryHistory(SalaryHistory salaryHistoryObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(salaryHistoryObj);
            tr.commit();
            ss.close();
            return salaryHistoryObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public SalaryHistory updateSalaryHistory(SalaryHistory salaryHistoryObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.update(salaryHistoryObj);
            tr.commit();
            ss.close();
            return salaryHistoryObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public SalaryHistory deleteSalaryHistory(SalaryHistory salaryHistoryObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.delete(salaryHistoryObj);
            tr.commit();
            ss.close();
            return salaryHistoryObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public SalaryHistory findSalaryHistoryById(SalaryHistory salaryHistoryObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            SalaryHistory salaryHistory = (SalaryHistory) ss.get(SalaryHistory.class, salaryHistoryObj.getSalaryId());
            ss.close();
            return salaryHistory;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<SalaryHistory> retrieveAllSalaryHistory(SalaryHistory salaryHistoryObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<SalaryHistory> salaryHistoryloyees = ss.createQuery("SELECT salaryHistory FROM SalaryHistory salaryHistory").list();
            ss.close();
            return salaryHistoryloyees;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
