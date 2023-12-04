package dangduong.vn.edu.iuh.ongk.backend.repository;

import dangduong.vn.edu.iuh.ongk.backend.models.ProductImage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class ProductImageRepository {
    private EntityManager em;
    private EntityTransaction trans;
    public ProductImageRepository(){
        this.em = Connection.getInStance().getEm().createEntityManager();
        this.trans = em.getTransaction();
    }
    public boolean create(ProductImage p){
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
    public boolean update(ProductImage p){
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

    public boolean delete (long id){
        trans.begin();
        try {
            Optional<ProductImage> op = findById(id);
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
    public Optional<ProductImage> findById(long id){
        ProductImage productImage = em.find(ProductImage.class, id);
        return productImage != null ? Optional.of(productImage) : Optional.empty();
    }
    public List<ProductImage> findAll(){
       List<ProductImage> list = em.createNamedQuery("ProductImage.findAll", ProductImage.class).getResultList();
        return list;
    }
}
