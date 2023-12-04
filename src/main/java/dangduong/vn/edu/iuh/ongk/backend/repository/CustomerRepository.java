package dangduong.vn.edu.iuh.ongk.backend.repository;

import dangduong.vn.edu.iuh.ongk.backend.models.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager em;

    private EntityTransaction trans;

    public CustomerRepository() {
        em = Connection.getInStance().getEm().createEntityManager();
        trans = em.getTransaction();
    }
    public boolean create(Customer c){
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
    public   boolean updateId(Customer c){
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
    public boolean delete(long custId){

        try {
            trans.begin();
            Optional<Customer> op = findId(custId);
            if (op.isPresent()){
                em.remove(op.get());
                trans.commit();
                return true;
            }
            trans.rollback();
        } catch (Exception ex){
            trans.rollback();
            ex.printStackTrace();
        }
        return false;

    }
    public Optional<Customer> findId(long id){
        Customer customer = em.find(Customer.class, id);
        return customer != null ? Optional.of(customer) : Optional.empty();
    }
    public List<Customer> getAll(){
        List<Customer> ListAll = em.createNamedQuery("Customer.getAll", Customer.class).getResultList();
        return ListAll;
    }

}
