package dangduong.vn.edu.iuh.ongk.backend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class Customer {
    private EntityManager em;

    private EntityTransaction trans;

    public  Customer() {
        em = Connection.getInStance().getEm().createEntityManager();
        trans = em.getTransaction();
    }
    private boolean taoMoi(Customer c){
        try {
            trans.begin();
            em.persist(c);
            trans.commit();
            return  true;
        }catch (Exception exception ){
            trans.rollback();
            exception.printStackTrace();

        }
        return  false;
    }
    private  boolean updateId(Customer c){
        try {
            trans.begin();
            em.merge(c);
            trans.commit();
            return true;
        }catch (Exception ex){
            trans.rollback();
            ex.printStackTrace();
        }
        return  false;

    }
    private Customer findId(long id){
        return  em.find(Customer.class,id);
    }
    private List<Customer> getAll(){
        List<Customer> ListAll = em.createNamedQuery("Customer.getAll", Customer.class).getResultList();
        return ListAll;
    }

}
