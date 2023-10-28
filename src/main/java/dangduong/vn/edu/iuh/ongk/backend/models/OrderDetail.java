package dangduong.vn.edu.iuh.ongk.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "orderdetaiil")
public class OrderDetail {

    private String note;

    private double price;

    private double quantity;
    @ManyToOne
    @Id
    private Orders orderId;
    @ManyToOne
    @Id
    private Product productId;



}
