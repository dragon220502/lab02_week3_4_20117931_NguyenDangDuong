package dangduong.vn.edu.iuh.ongk.backend.repository;

import dangduong.vn.edu.iuh.ongk.backend.models.Customer;
import dangduong.vn.edu.iuh.ongk.backend.models.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private EntityManager em;

    private EntityTransaction trans;

    public OrderRepository() {
        em = Connection.getInStance().getEm().createEntityManager();
        trans = em.getTransaction();
    }
    public boolean taoMoi(Order c){
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
    public boolean updateId(Order c){
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
            Optional<Order> op = findId(custId);
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
    public  Optional<Order> findId(long id){
        Order order = em.find(Order.class, id);
        return order != null ? Optional.of(order) : Optional.empty();
    }
    public  List<Order> getAll(){
        List<Order> ListAll = em.createNamedQuery("Order.getAll", Order.class).getResultList();
        return ListAll;
    }

}
