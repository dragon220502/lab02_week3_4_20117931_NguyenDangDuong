package dangduong.vn.edu.iuh.ongk.backend.repository;

import dangduong.vn.edu.iuh.ongk.backend.enums.ProductEnum;
import dangduong.vn.edu.iuh.ongk.backend.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ProductRepository {

    private EntityManager em;

    private EntityTransaction trans;

    public ProductRepository() {
        em = Connection.getInStance().getEm().createEntityManager();
        trans = em.getTransaction();
    }
    private boolean taoMoi(Product p){
        try {
            trans.begin();
            em.persist(p);
            trans.commit();
            return  true;
        }catch (Exception ex){
            trans.rollback();
            ex.printStackTrace();
        }
        return  false;
    }
    private  boolean update(Product p){
        try {
            trans.begin();
            em.merge(p);
            trans.commit();
            return  true;
        }catch (Exception ex){
            trans.rollback();
            ex.printStackTrace();
        }
        return false;
    }
    private boolean delete(Product p){
        try {
            p.setStatus(ProductEnum.KHONG);
            update(p);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    private List<Product> getAll(){
        List<Product> listProduct = em.createNamedQuery("product.getAll",Product.class).setParameter(1,ProductEnum.DANG).getResultList();
        return  listProduct;
    }
}
