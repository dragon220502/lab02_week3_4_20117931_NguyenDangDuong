package dangduong.vn.edu.iuh.ongk.backend.repository;

import dangduong.vn.edu.iuh.ongk.backend.models.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


import java.util.List;
import java.util.Optional;

public class OrderDetailRepository {
    private EntityManager em;
    private EntityTransaction trans;
    public OrderDetailRepository(){
        this.em = Connection.getInStance().getEm().createEntityManager();
        this.trans = em.getTransaction();
    }

    public boolean insert(OrderDetail o){
        trans.begin();
        try {
            em.persist(o);
            trans.commit();
            return true;
        } catch (Exception ex){
            trans.rollback();
            ex.printStackTrace();
        }
        return false;
    }
    public boolean update(OrderDetail orderDetail){
        trans.begin();
        try {
            em.merge(orderDetail);
            trans.commit();
            return true;
        } catch (Exception ex){
            trans.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public boolean delete(long orderId, long productId){
        trans.begin();
        try {
            Optional<OrderDetail> op = findOne(orderId, productId);
            if (op.isPresent()){
                em.remove(op.get());
                trans.commit();
                return true;
            }
            trans.rollback();
        } catch (Exception e){
            trans.rollback();
            e.printStackTrace();
        }
        return false;
    }
    public Optional<OrderDetail> findOne(long orderId, long productId){
        List<OrderDetail> os = em.createNamedQuery("OrderDetail.find", OrderDetail.class).setParameter("product", productId).setParameter("order", orderId).getResultList();
        return os.size() > 0 ? Optional.of(os.get(0)) : Optional.empty();
    }
    public List<OrderDetail> getOrderDetailsByOrderId(long orderId){
        List<OrderDetail> list = em.createNamedQuery("OrderDetail.findAllByOrderId", OrderDetail.class).setParameter("orderId", orderId).getResultList();
        return list;
    }
}
