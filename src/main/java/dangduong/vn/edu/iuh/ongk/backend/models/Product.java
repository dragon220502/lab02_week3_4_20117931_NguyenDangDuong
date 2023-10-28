package dangduong.vn.edu.iuh.ongk.backend.models;

import dangduong.vn.edu.iuh.ongk.backend.enums.ProductEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity @Table(name ="product")
@NamedQueries(@NamedQuery(name = "product.getAll",query = "SELECT p FROM Product p WHERE p.status =?1"))
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
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


}
