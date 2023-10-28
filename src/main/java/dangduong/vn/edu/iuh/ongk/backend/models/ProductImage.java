package dangduong.vn.edu.iuh.ongk.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="productImage")
public class ProductImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long imageId;
    @Column(columnDefinition = "varchar(250)", nullable = false)
    private String alternative;
    @Column(columnDefinition = "varchar(250)", nullable = false)

    private String path;
    @ManyToOne
    private Product productId;
}
