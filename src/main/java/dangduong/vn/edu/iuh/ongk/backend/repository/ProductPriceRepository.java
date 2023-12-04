package dangduong.vn.edu.iuh.ongk.backend.repository;

import dangduong.vn.edu.iuh.ongk.backend.models.ProductPrice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceRepository {
    private EntityManager em;
    private EntityTransaction trans;
    public ProductPriceRepository(){
        this.em = Connection.getInStance().getEm().createEntityManager();
        this.trans = em.getTransaction();
    }
    public boolean add(ProductPrice p){
        trans.begin();
        try {
            em.persist(p);
            trans.commit();
            return true;
        } catch (Exception e){
            trans.rollback();
            e.printStackTrace();
        }
        return false;
    }
    public boolean update(ProductPrice p){
        trans.begin();
        try {
            em.merge(p);
            trans.commit();
            return true;
        } catch (Exception e){
            trans.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(long productId, LocalDateTime priceDateTime){
        trans.begin();
        try {
            Optional<ProductPrice> op = findOne(productId, priceDateTime);
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
    public Optional<ProductPrice> findOne(long productId, LocalDateTime priceDateTime){
        List<ProductPrice> p = em.createNamedQuery("ProductPrice.find", ProductPrice.class).setParameter("product", productId).setParameter("price_date_time", priceDateTime).getResultList();
        return p.size() > 0 ? Optional.of(p.get(0)) : Optional.empty();
    }
    public List<ProductPrice> findAll(){
        List<ProductPrice> list = em.createNamedQuery("ProductPrice.findAll", ProductPrice.class).getResultList();
        return list;
    }
    public Optional<ProductPrice> getNewestProductPriceByProductId(long id){
        List<ProductPrice> listAll = em.createNamedQuery("ProductPrice.getNewestOneByProductId", ProductPrice.class).setParameter("productId", id).setMaxResults(1).getResultList();
        return listAll.isEmpty() ? Optional.empty() : Optional.of(listAll.get(0));
    }
    public Double getNewPriceByIdProduct(String product_id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "SELECT price from product_price where product_id = :product_id  ORDER BY price_date_time DESC LIMIT 1";
            Double price = (Double) em.createNativeQuery(sql).setParameter("product_id", product_id).getSingleResult();
            tr.commit();
            return price;
        } catch (Exception e) {
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
