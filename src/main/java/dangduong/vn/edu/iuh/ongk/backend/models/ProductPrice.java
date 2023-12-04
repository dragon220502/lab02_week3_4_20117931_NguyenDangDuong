package dangduong.vn.edu.iuh.ongk.backend.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
        @Table(name = "product_price")
@NamedQueries(
        {@NamedQuery(name = "ProductPrice.find",query = "SELECT pp from ProductPrice pp where pp.product.prodcctId = :product and pp.priceDateTime = :price_date_time"),
            @NamedQuery(name = "ProductPrice.findAll", query = "select p from ProductPrice p"),
                @NamedQuery(name = "ProductPrice.getNewestOneByProductId", query = "SELECT pp from ProductPrice pp where pp.product.prodcctId = :productId order by pp.priceDateTime desc")
        }
)
public class ProductPrice {
    @Id
    @Column(name = "price_date_time")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime priceDateTime;
    @Column(columnDefinition = "VARCHAR(255)")
    private String note;
    private double price;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false, referencedColumnName = "product_id")
    private Product product;

    public ProductPrice(LocalDateTime priceDateTime, String note, double price) {
        this.priceDateTime = priceDateTime;
        this.note = note;
        this.price = price;
    }

    public ProductPrice(LocalDateTime priceDateTime, double price) {
        this.priceDateTime = priceDateTime;
        this.price = price;
    }
}
