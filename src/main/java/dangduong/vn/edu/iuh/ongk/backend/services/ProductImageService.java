package dangduong.vn.edu.iuh.ongk.backend.services;

import dangduong.vn.edu.iuh.ongk.backend.models.ProductImage;
import dangduong.vn.edu.iuh.ongk.backend.repository.ProductImageRepository;

import java.util.List;
import java.util.Optional;

public class ProductImageService {
    private ProductImageRepository productImageRepository;

    public ProductImageService(){
        this.productImageRepository = new ProductImageRepository();
    }
    public boolean add(ProductImage productImage){
        return productImageRepository.create(productImage);
    }
    public boolean update(ProductImage productImage){
        return productImageRepository.update(productImage);
    }
    public Optional<ProductImage> findOne(long id){
        return productImageRepository.findById(id);
    }
    public boolean delete (long id){
        return productImageRepository.delete(id);
    }
    public List<ProductImage> findAll(){
        return productImageRepository.findAll();
    }
}
