package dangduong.vn.edu.iuh.ongk.backend.models;

import dangduong.vn.edu.iuh.ongk.backend.enums.ProductEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity @Table(name ="product")
@NamedQueries(@NamedQuery(name = "product.getAll",query = "SELECT p FROM Product p WHERE p.status =?1"))
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", insertable = false, updatable = false)
    private long prodcctId;
    @Column(columnDefinition = "varchar(250)")
    private String description;
    @Column(columnDefinition = "varchar(100)")
    private String manufacturerName;
    @Column(columnDefinition = "varchar(150)")
    private String name;
    @Column(columnDefinition = "varchar(25)")
    private String unit;
    @Column(columnDefinition = "int(11)")
    @Enumerated(EnumType.ORDINAL)
    private ProductEnum status;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductImage> productImageList;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductPrice> productPrices;

    public Product(String description, String manufacturerName, String name, String unit, ProductEnum status) {
        this.description = description;
        this.manufacturerName = manufacturerName;
        this.name = name;
        this.unit = unit;
        this.status = status;
    }

    public Product(long prodcctId, String description, String manufacturerName, String name, String unit, ProductEnum status, List<ProductImage> productImageList, List<ProductPrice> productPrices) {
        this.prodcctId = prodcctId;
        this.description = description;
        this.manufacturerName = manufacturerName;
        this.name = name;
        this.unit = unit;
        this.status = status;
        this.productImageList = productImageList;
        this.productPrices = productPrices;
    }

    public Product(long id, String name, String decription, String manufacturer, String unit, ProductEnum productEnum) {
        this.prodcctId = id;
        this.description = description;
        this.manufacturerName = manufacturerName;
        this.name = name;
        this.unit = unit;
        this.status = status;
    }
}
