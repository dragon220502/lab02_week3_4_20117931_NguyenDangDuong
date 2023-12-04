package dangduong.vn.edu.iuh.ongk.backend.services;

import dangduong.vn.edu.iuh.ongk.backend.models.Product;
import dangduong.vn.edu.iuh.ongk.backend.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(){
        this.productRepository = new ProductRepository();
    }
    public boolean add(Product product){
        return productRepository.taoMoi(product);
    }
    public boolean update(Product product){
        return productRepository.update(product);
    }
    public Optional<Product> findOne(long id){
        return productRepository.findById(id);
    }
    public boolean delete (long id){
        return productRepository.delete(id);
    }
    public List<Product> findAll(){
        return productRepository.getAll();
    }
}
