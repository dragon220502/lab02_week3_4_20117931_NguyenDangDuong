package dangduong.vn.edu.iuh.ongk.backend.repository;

import dangduong.vn.edu.iuh.ongk.backend.enums.ProductEnum;
import dangduong.vn.edu.iuh.ongk.backend.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private EntityManager em;

    private EntityTransaction trans;

    public ProductRepository() {
        em = Connection.getInStance().getEm().createEntityManager();
        trans = em.getTransaction();
    }
    public boolean taoMoi(Product p){
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
    public   boolean update(Product p){
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
    public boolean delete(Long id){

        try {
            trans.begin();
            Optional<Product> op = findById(id);
            if (op.isPresent()){
                Product product = op.get();
                product.setStatus(ProductEnum.KHONGKINHDOANG);
                trans.commit();
                return true;
            }
        } catch (Exception ex){
            trans.rollback();
            ex.printStackTrace();
        }
        return false;
    }
    public Optional<Product> findById(long id){
        Product product = em.find(Product.class, id);
        return product != null ? Optional.of(product) : Optional.empty();
    }
    public List<Product> getAll(){
        List<Product> listProduct = em.createNamedQuery("product.getAll",Product.class).setParameter(1,ProductEnum.DANGKINHDOANG).getResultList();
        return  listProduct;
    }

}
