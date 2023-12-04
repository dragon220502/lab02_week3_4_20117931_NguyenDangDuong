package dangduong.vn.edu.iuh.ongk.fontend.model;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import dangduong.vn.edu.iuh.ongk.backend.enums.ProductEnum;
import dangduong.vn.edu.iuh.ongk.backend.models.Product;
import dangduong.vn.edu.iuh.ongk.backend.models.ProductImage;
import dangduong.vn.edu.iuh.ongk.backend.models.ProductPrice;
import dangduong.vn.edu.iuh.ongk.backend.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ProductModel {
    private ProductService productService;

    public ProductModel(){
        this.productService = new ProductService();
    }
    public void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        try {
            String name = req.getParameter("name").trim();
            Part image = req.getPart("image");
            String decription = req.getParameter("decription").trim();
            String manufacturer = req.getParameter("manufacturer").trim();
            String unit = req.getParameter("unit").trim();
            String priceStr = req.getParameter("price").trim();
            String statusStr = req.getParameter("status").trim();

            InputStream inputStream =image.getInputStream();
            File file = File.createTempFile("file", ".png");
            FileUtils.copyToFile(inputStream,file);

            Cloudinary cloudinary = new Cloudinary("cloudinary://932991143638458:7DaM0SDlRf4nNAAYIXNqpMrCJ3U@deh8pz5r3");
            cloudinary.config.secure = true;

            Map up = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

            ProductImage productImage = new ProductImage((String) up.get("url"));
            double price = Double.parseDouble(priceStr);
            ProductPrice productPrice = new ProductPrice(LocalDateTime.now(), price);
            ProductEnum productEnum = ProductEnum.valueOf(statusStr);
            Product product = new Product(name,decription,manufacturer,unit,productEnum);
            productImage.setProduct(product);
            productPrice.setProduct(product);
            product.setProductPrices(List.of(productPrice));
            product.setProductImageList(List.of(productImage));
            productService.add(product);
            resp.sendRedirect("listProduct.jsp");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException{
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("name").trim();
            String decription = req.getParameter("decription").trim();
            String manufacturer = req.getParameter("manufacturer").trim();
            String unit = req.getParameter("unit").trim();
            String statusStr = req.getParameter("status").trim();
        System.out.println(id);
            ProductEnum productEnum = ProductEnum.valueOf(statusStr);
            Product product = new Product(id,name,decription,manufacturer,unit,productEnum);
            productService.update(product);
            resp.sendRedirect("listProdcut.jsp");
    }
    public  void deleteProduct(HttpServletRequest rep, HttpServletResponse resp) throws IOException{
        long id = Long.parseLong(rep.getParameter("id"));
        productService.delete(id);
        resp.sendRedirect("listProduct.jsp");
    }
    public void getAll(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        List<Product> products = productService.findAll();
        req.getSession().setAttribute("products",products);
        resp.sendRedirect("listProduct.jsp");
    }

}
