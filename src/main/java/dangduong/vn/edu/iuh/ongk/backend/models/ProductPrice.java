package dangduong.vn.edu.iuh.ongk.backend.models;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class ProductPrice {
    @Id
    private LocalDateTime priceDateTime;

    private String note;

    private double price;
    @ManyToOne
    private Product productId;
}
