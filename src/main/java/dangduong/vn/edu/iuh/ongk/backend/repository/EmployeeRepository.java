package dangduong.vn.edu.iuh.ongk.backend.repository;

import dangduong.vn.edu.iuh.ongk.backend.enums.EmployeeStatus;
import dangduong.vn.edu.iuh.ongk.backend.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class EmployeeRepository {

    private EntityManager em;

    private EntityTransaction trans;

    public EmployeeRepository() {
        em = Connection.getInStance().getEm().createEntityManager();
        trans = em.getTransaction();
    }
    public boolean insertEmployee(Employee e){
        try {
            trans.begin();
            em.persist(e);
            trans.commit();
            return  true;
        }catch (Exception ex){
            trans.rollback();
            ex.printStackTrace();

        }
        return false;
    }
    public boolean updateEmployee(Employee e){
        try{
            trans.begin();
            em.merge(e);
            trans.commit();
            return  true;
        }catch (Exception ex){
            trans.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public  boolean deleteEmployee(Employee e){
        try {
            e.setStatus(EmployeeStatus.NGHI);
            updateEmployee(e);
            return  true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  false;
    }
    public Employee findById(long empId){
        return em.find(Employee.class, empId);

    }
    public List<Employee> getAll(){
        List<Employee> listEmpGetName = em.createNamedQuery("Employee.getALL",Employee.class).setParameter(1,EmployeeStatus.DANGLAM).getResultList();
        return listEmpGetName;
    }
}

