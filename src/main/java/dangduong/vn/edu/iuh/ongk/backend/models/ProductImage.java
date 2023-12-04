package dangduong.vn.edu.iuh.ongk.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
        @Table(name="product_image")
@NamedQueries(
        @NamedQuery(name = "ProductImage.findAll", query = "select p from ProductImage p")
)
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long imageId;
    @Column(columnDefinition = "varchar(250)")
    private String alternative;
    @Column(columnDefinition = "varchar(250)")
    private String path;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false,referencedColumnName = "product_id")
    private Product product;

    public ProductImage(String path) {
        this.path = path;
    }

}
